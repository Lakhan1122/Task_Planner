package com.lakhan.model;

import java.util.ArrayList;
import java.util.List;

public class Sprint {

	
	  String name;
	    static Integer sprintID=500;
	    List<Task> tasks=new ArrayList<>();

	    public Sprint(String name, List<Task> tasks) {
	        this.name = name;
	        this.tasks = tasks;
	    }

	    public Sprint() {
	    }

	    public Sprint(String name) {
	        this.name = name;
	        sprintID++;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<Task> getTasks() {
	        return tasks;
	    }

	    public void setTasks(List<Task> tasks) {
	        this.tasks = tasks;
	    }

	    public void addTask(Task task) {
	        tasks.add(task);
	    }

	    public Integer getSprintID() {
	        return sprintID;
	    }

	    public Integer getNextSprintID() {
	        return sprintID++;
	    }
	    
	    
}
