package com.company.todolist;

import com.company.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller { // the Controller handles interaction between UI and data model

    // singleton will create one instance over the entire run of the application
    // the singleton class creates one instance of itself, having a private constructor ensuring
    // no other class can create an instance
    // usually containing a static method

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;


    public void initialize(){
        TodoItem item1 = new TodoItem("Mail birthday card",
                "Buy a 'Happy 30th birthday' card for John",
                LocalDate.of(2016, Month.APRIL, 25));

        TodoItem item2 = new TodoItem("Doctor's Appointment",
                "See Dr. Smith at 123 Main St. Bring paperwork",
                LocalDate.of(2018, Month.MAY, 25));

        TodoItem item3 = new TodoItem("Finish design proposal for Toyota",
                "Promised Mike, I'd email website mockups by Friday 22nd April",
                LocalDate.of(2022, Month.JANUARY, 22));

        TodoItem item4 = new TodoItem("Mail mom's gift ",
                "Mail mom's mother's day flowers",
                LocalDate.of(2021, Month.APRIL, 20));

        TodoItem item5 = new TodoItem("Buy groceries",
                "Preferably from Trader Joe's",
                LocalDate.of(2020, Month.DECEMBER, 28));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

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

        todoListView.getItems().setAll(todoItems); // getting all items and setting them on the UI
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // selecting one item at a time
        todoListView.getSelectionModel().selectFirst(); // setting the first item as the view using .selectFirst()
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
}
