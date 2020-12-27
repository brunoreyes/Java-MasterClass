package com.company.todolist;

import com.company.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller { // the Controller handles interaction between UI and data model

    private List<TodoItem> todoItems;

    @FXML
    private ListView todoListView;

    @FXML
    private TextArea itemDetailsTextArea;


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

        todoListView.getItems().setAll(todoItems); // getting all items and setting them on the UI
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // selecting one item at a time
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();
//        System.out.println("The selected item is "+ item); // shortcut: type: souf to print as string instead of variable
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(sb.toString());
    }
}
