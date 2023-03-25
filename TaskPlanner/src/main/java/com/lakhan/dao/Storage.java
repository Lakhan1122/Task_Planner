package com.lakhan.dao;

import java.util.HashMap;

import com.lakhan.model.Sprint;
import com.lakhan.model.Task;

public class Storage {

	
	 private static Storage storage = null;
	    private HashMap<Integer, Task> taskMap = new HashMap<>();
	    private HashMap<String, Sprint> sprintHashMap = new HashMap<>();
	    private HashMap<Integer, String> taskSprintMap = new HashMap<>();

	    public HashMap<Integer, Task> getTaskMap() {
	        return taskMap;
	    }

	    public void setTaskMap(HashMap<Integer, Task> taskMap) {
	        this.taskMap = taskMap;
	    }

	    public HashMap<String, Sprint> getSprintHashMap() {
	        return sprintHashMap;
	    }

	    public void setSprintHashMap(HashMap<String, Sprint> sprintHashMap) {
	        this.sprintHashMap = sprintHashMap;
	    }

	    public HashMap<Integer, String> getTaskSprintMap() {
	        return taskSprintMap;
	    }

	    public void setTaskSprintMap(HashMap<Integer, String> taskSprintMap) {
	        this.taskSprintMap = taskSprintMap;
	    }

	    public Storage() {
	    }

	    static {
	        storage = new Storage();
	    }

	    public static Storage getStorage() {
	        return storage;
	    }
}
