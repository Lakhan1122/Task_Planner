package com.lakhan.service;

import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.lakhan.model.Sprint;


@Service
public class SprintService {

	
	  HashMap<String, LinkedList<Integer>> sprintListHashMap = new HashMap<>();
	    private static SprintService sprintService = null;

	    public SprintService() {
	    }

	    static {
	        sprintService = new SprintService();
	    }

	    HashMap<String, Sprint>sprintHashMap=new HashMap<>();

	    public void createSprint(String sprintName, Sprint sprint)
	    {
	        sprintHashMap.put(sprintName,sprint);
	    }

	    public void addTaskToSprint(String sprintName, Integer taskNo) {
	        LinkedList<Integer> taskList = sprintListHashMap.get(sprintName);
	        if (taskList == null) {
	            taskList = new LinkedList<Integer>();
	            taskList.add(taskNo);
	            sprintListHashMap.put(sprintName, taskList);
	        } else {
	            taskList.add(taskNo);
	        }
	    }

	    public void changeSprintForTask(String oldSprint, String newSprint, Integer taskNo) {
	        if (sprintListHashMap.containsKey(oldSprint)) {
	            sprintListHashMap.get(oldSprint).remove(taskNo);
	            addTaskToSprint(newSprint, taskNo);
	        } else
	            throw new RuntimeException();
	    }
}
