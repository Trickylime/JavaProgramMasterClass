package com.javamasterclass.todolist;

import com.javamasterclass.todolist.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    public void initialize() {
        TodoItem item1 = new TodoItem("Post birthday card", "Buy a birthday card for Jon",
                LocalDate.of(2024, Month.NOVEMBER, 16));
        TodoItem item2 = new TodoItem("Doctor's Appointment", "See Dr. Smith at 123 main street",
                LocalDate.of(2024, Month.DECEMBER, 3));
        TodoItem item3 = new TodoItem("Finish Design proposal for client", "I promised Mike I'd email website mock ups",
                LocalDate.of(2024, Month.NOVEMBER, 25));
        TodoItem item4 = new TodoItem("Pick up Doug at the train station", "Doug's arriving on November 1st on 5pm train",
                LocalDate.of(2024, Month.NOVEMBER, 1));
        TodoItem item5 = new TodoItem("Pick up washing", "Clothes should be ready by Wednesday",
                LocalDate.of(2024, Month.NOVEMBER, 6));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);
    }
}