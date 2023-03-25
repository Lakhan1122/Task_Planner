package com.lakhan.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lakhan.dao.Storage;
import com.lakhan.exceptions.TaskException;
import com.lakhan.model.Sprint;
import com.lakhan.model.Task;


@Service
public class TaskServiceImpl implements TaskService{

	
	 private static TaskService taskService = null;

	    Storage storage = Storage.getStorage();

	    private TaskServiceImpl() {
	    }

	    static {
	        taskService = new TaskServiceImpl();
	    }

	    public static TaskService getTaskService() {
	        return taskService;
	    }
	    
	    
	    
	    public void addTask(Integer taskID, Task task) {
	        storage.getTaskMap().put(taskID, task);
	    }

	    public void changeStatus(Integer taskID) {
	        storage.getTaskMap().get(taskID).changeStatus();
	    }

	    public List<Task> taskAssignedToUser(String user) {
	        List<Task> taskList = new ArrayList<>();
	        for (Task t : storage.getTaskMap().values()) {
	            if (t.getAssignee().equalsIgnoreCase(user))
	                taskList.add(t);
	        }
	        return taskList;
	    }

	    public HashMap<Integer, Task> getAllTask() {
	        return storage.getTaskMap();
	    }

	    public Task getTask(Integer taskID)
	    {
	        if(!storage.getTaskMap().containsKey(taskID))
	            throw new TaskException(MessageFormat.format("{0}-Task ID is not correct.",taskID));
	        return storage.getTaskMap().get(taskID);
	    }

	    public Integer createSprint(String sprintName) {
	        storage.getSprintHashMap().put(sprintName, new Sprint(sprintName));
	        return storage.getSprintHashMap().get(sprintName).getSprintID();
	    }

	    public Integer deleteSprint(String sprintName) {
	        Integer sprintID=storage.getSprintHashMap().get(sprintName).getSprintID();
	        storage.getSprintHashMap().remove(sprintName);
	        return sprintID;
	    }

	    public void createSprintWithTask(String sprintName, Integer taskNo) {
	        if (!storage.getSprintHashMap().containsKey(taskNo))
	            storage.getTaskSprintMap().put(taskNo, sprintName);
	        else
	            throw new TaskException("Task already attached to sprint");
	        storage.getSprintHashMap().put(sprintName, new Sprint(sprintName));
	        storage.getSprintHashMap().get(sprintName).addTask(storage.getTaskMap().get(taskNo));
	    }

	    public void addTaskToSprint(String sprintName, Integer taskNo) {
	        if (!storage.getTaskSprintMap().containsKey(taskNo))
	            storage.getTaskSprintMap().put(taskNo, sprintName);
	        else
	            throw new TaskException("Task already attached to sprint");

	        if (storage.getTaskMap().containsKey(taskNo)) {
	            storage.getSprintHashMap().get(sprintName).addTask(storage.getTaskMap().get(taskNo));
	        } else
	            throw new TaskException("Task dont exist");
	    }

	    public void changeSprintForTask(String oldSprint, String newSprint, Integer taskNo) {
	        List<Task> list = storage.getSprintHashMap().get(oldSprint).getTasks();
	        for (Task t : list) {
	            if (t.getTaskID() == taskNo) {
	                list.remove(t);
	                break;
	            }
	        }
	        storage.getSprintHashMap().get(newSprint).getTasks().add(storage.getTaskMap().get(taskNo));
	    }

	    private List<Task> tasksForSprint(String sprint) {
	        return storage.getSprintHashMap().get(sprint).getTasks();
	    }

}
