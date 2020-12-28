package com.company.todolist;

import com.company.todolist.datamodel.TodoData;
import com.company.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller { // the Controller handles interaction between UI and data model

    // singleton will create one instance of itself over the entire run of the application
    // the singleton class creates one instance of itself, having a private constructor ensuring
    // no other class can create an instance
    // usually containing a static method that allows any class to get the single instance and call's its methods

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    @FXML // instance var for border pane that we can ask for ref to parent calling the scene to get dialog window
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;


    public void initialize(){

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

//        temporarily getting rid of hard coded instances
//        TodoItem item1 = new TodoItem("Mail birthday card",
//                "Buy a 'Happy 30th birthday' card for John",
//                LocalDate.of(2016, Month.APRIL, 25));
//
//        TodoItem item2 = new TodoItem("Doctor's Appointment",
//                "See Dr. Smith at 123 Main St. Bring paperwork",
//                LocalDate.of(2018, Month.MAY, 25));
//
//        TodoItem item3 = new TodoItem("Finish design proposal for Toyota",
//                "Promised Mike, I'd email website mockups by Friday 22nd April",
//                LocalDate.of(2022, Month.JANUARY, 22));
//
//        TodoItem item4 = new TodoItem("Mail mom's gift ",
//                "Mail mom's mother's day flowers",
//                LocalDate.of(2021, Month.APRIL, 20));
//
//        TodoItem item5 = new TodoItem("Buy groceries",
//                "Preferably from Trader Joe's",
//                LocalDate.of(2020, Month.DECEMBER, 28));

//        todoItems = new ArrayList<TodoItem>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        TodoData.getInstance().setTodoItems(todoItems); // retrieving the singleton and passing items to set to it

        // overriding method change, this event handler is aka an event listener
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue <? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails()); // setting details

                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy"); // using dateTime formatter
                    deadlineLabel.setText(df.format(item.getDeadline()));
//                    deadlineLabel.setText(item.getDetails().toString()); // setting due dates
                }
            }
        });

        todoListView.setItems(TodoData.getInstance().getTodoItems());
//        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); // getting all items and setting them on the UI
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // selecting one item at a time
        todoListView.getSelectionModel().selectFirst(); // setting the first item as the view using .selectFirst()

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>(){

                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty){
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))){ // if the item is set to be due today or before today
                                setTextFill(Color.RED);                 // than make the short description red
                            } else if (item.getDeadline().equals(LocalDate.now().plusDays(1))){
                                setTextFill(Color.ORANGE);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty){
                                cell.setContextMenu(null);
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                });

                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Use this dialog to create a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
//            dialog.getDialogPane().setContent(root);
            dialog.getDialogPane().setContent(fxmlLoader.load()); // getting content from fxml loader
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace(); // Prints this throwable and its backtrace to the standard error stream.
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            controller.processResults();
            // refreshing the list after adding an item by setting it to the new list
            TodoItem newItem = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); // replace contents with what comes back from dialog box
            todoListView.getSelectionModel().select(newItem); // selecting the newly added item to display details
//            System.out.println("Ok Pressed");
        } else {
//            System.out.printf("Cancel pressed");
        }
    }
public void handleKeyPressed(KeyEvent keyEvent){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            if (keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
}

    @FXML
    public void handleClickListView(){
        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
//        System.out.println("The selected item is "+ item); // shortcut: type: souf to print as string instead of variable

//        StringBuilder sb = new StringBuilder(item.getDetails()); // used StringBuilder when all info of item was in VBox
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());
    }

    public void deleteItem(TodoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)){
            TodoData.getInstance().deleteTodoItem(item);
        }
    }
}
