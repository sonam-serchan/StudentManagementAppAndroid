package com.example.sonamserchan.studentmanagementapp.model;

import java.util.ArrayList;

public class TodoTasks {

    //declare private data instead of public to ensure the privacy of data field of each class
    private int taskId;
    private String taskName;
    private String status;

    public TodoTasks(int taskId, String taskName, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    //retrieve task's ID
    public int getTaskId(){
        return taskId;
    }

    //retrieve name of the task
    public String getTaskName() {
        return taskName;
    }

    //retrieve status of the task
    public String getStatus() {
        return status;
    }

    public static ArrayList<TodoTasks> getTasks(){
        ArrayList<TodoTasks> todoTasks = new ArrayList<TodoTasks>();
        todoTasks.add(new TodoTasks(1, "Add students", "Not Completed"));
        todoTasks.add(new TodoTasks(2, "Register Exams", "Not Completed"));
        todoTasks.add(new TodoTasks(3, "Assign Images", "Not Completed"));
        return todoTasks;
    }

}
