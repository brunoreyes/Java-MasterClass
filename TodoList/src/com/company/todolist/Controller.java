package com.company.todolist;

import com.company.todolist.datamodel.TodoData;
import com.company.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

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

    @FXML
    private ToggleButton filterToggleButton;

    // a filtered list called filteredList comprised of item's with type: TodoItem
    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;


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
                    String formattedDetails = item.getDetails().substring(0,1).toUpperCase() + // making 1st char Uppercase
                            item.getDetails().substring(1).toLowerCase(); // making rest of details lowercase
                    itemDetailsTextArea.setText(formattedDetails); // setting details

                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy"); // using dateTime formatter
                    deadlineLabel.setText(df.format(item.getDeadline()));
//                    deadlineLabel.setText(item.getDetails().toString()); // setting due dates
                }
            }
        });

        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return (todoItem.getDeadline().equals(LocalDate.now()));
            }
        };

        filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), wantAllItems);
//                new Predicate<TodoItem>() { // Predicate a boolean type argument, usually expressed as a Lamda
//            // if test returns true, the item is granted access and is passed,
//            // if test returns false, the item fails the filter and isn't kept for display
//                    @Override
//                    public boolean test(TodoItem todoItem) {
//                        return true;
//                    }
//                });

        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList,
                new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem o1, TodoItem o2) {
                // returns a negative value if 01 < 02, return 0 if 01 = 02, return 1 if 01 > 02
                return o1.getDeadline().compareTo(o2.getDeadline());
            }
        });

//        todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.setItems(sortedList); // Sets items in order of soonest due at top to later due at bottom
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
                            setText(item.getShortDescription().substring(0,1).toUpperCase() + item.getShortDescription().substring(1));
                            // if the item is set to be due today or before today than make the short description red
                            if (item.getDeadline().isBefore(LocalDate.now())){
                                setTextFill(Color.MAROON);
                                setFont(Font.font("Arial",16));

                            } else if (item.getDeadline().equals(LocalDate.now())){ //.plusDays(1)
                                setTextFill(Color.RED);
                                setFont(Font.font("Arial",16));
                            } else if (item.getDeadline().isAfter(LocalDate.now())){
                                setTextFill(Color.ORANGE);
                                setFont(Font.font("Arial",16));
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

            // refreshing the list after adding an item by setting it to the new list
            TodoItem newItem = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); // replace contents with what comes back from dialog box
            todoListView.getSelectionModel().select(newItem); // selecting the newly added item to display details
//            System.out.println("Ok Pressed");
        }
//        else {
////            System.out.printf("Cancel pressed");
//        }
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

    @FXML
    public void handleFilterButton(){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (filterToggleButton.isSelected()){
            filteredList.setPredicate(wantTodaysItems);
            if (filteredList.isEmpty()){
                itemDetailsTextArea.clear();
                deadlineLabel.setText("");
            } else if (filteredList.contains(selectedItem)){
                todoListView.getSelectionModel().select(selectedItem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }
            // code functionality for handleFilterButton() is now in predicates wantAllItems & wantTodaysItems above
//            new Predicate<TodoItem>() {
//                @Override
//                public boolean test(TodoItem todoItem) {
//                    // returning list of items of which their deadline is today
//                    return (todoItem.getDeadline().equals(LocalDate.now()));
//                }
//            });
        }else{
           filteredList.setPredicate(wantAllItems); // if button isn't clicked we want all items
           todoListView.getSelectionModel().select(selectedItem);
                   //new Predicate<TodoItem>() {
//                @Override
//                public boolean test(TodoItem todoItem) {
//                    return true; // returning ture instead of false, thus returning all items
//                }
//            });
        }
    }

    @FXML
    public void handleExit(){
        Platform.exit(); // closes down the app when pressed
    }
}
