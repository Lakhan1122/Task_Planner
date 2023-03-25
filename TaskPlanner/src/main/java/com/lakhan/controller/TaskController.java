package com.lakhan.controller;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lakhan.enums.Status;
import com.lakhan.enums.TaskType;
import com.lakhan.model.Story;
import com.lakhan.model.Task;
import com.lakhan.service.TaskService;

@RestController
public class TaskController {

	
	    @Autowired
	    TaskService taskService;


	    @PostMapping("/createtask")
	    public ResponseEntity<Object> createUser(@Validated @RequestBody Task task) {
	        taskService.addTask(task.getNextTaskID(), task);

	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{taskID}")
	                .buildAndExpand(task.getTaskID()).toUri();

	        return ResponseEntity.created(location).build();

	    }

	    @PutMapping("/changestatus")
	    public ResponseEntity<String> changeStatus(@RequestParam(value = "taskid") Integer taskID) {


	        return ResponseEntity.accepted().body(MessageFormat.format("Changed to-{0}",taskService.getTask(taskID).changeStatus()));
	       
	    }

	    @GetMapping("/createsubtrack")
	    public ResponseEntity<String> createSubTrack(@RequestParam(value = "name") String subTrack,
	                                  @RequestParam(value = "taskID") Integer taskID) {
	        Task task = taskService.getTask(taskID);
	        if(task.getTaskType().getTaskType().equals(TaskType.STORY)) {
	            if (Status.COMPLETED.equals(task.getTaskStatus()))
	                return ResponseEntity.badRequest().body("Status is already complete, cant add sub track");
	            else {
	                ((Story) task.getTaskType()).addSubTracks(((Story) task.getTaskType()).new SubTrack(subTrack));
	            }
	            return ResponseEntity.accepted().
	                    body(String.format("Story created with ID-",((Story) task.getTaskType()).getSubTrackID().toString()));
	        }
	        return ResponseEntity.badRequest().
	                body("Story not found.");
	    }

	    @GetMapping("/changeassignee")
	    public void changeAssignee(@RequestParam(value = "name") String name,
	                               @RequestParam(value = "taskID") Integer taskID) {
	        if (taskService.getTask(taskID) != null)
	            taskService.getTask(taskID).setAssignee(name);
	    }

	    @GetMapping("/getalltask")
	    @ResponseBody
	    public List<Task> getAllTask() {
	        List<Task> tasks = new ArrayList<>();
	        for (Task t : taskService.getAllTask().values()) {
	            tasks.add(t);
	        }
	        return tasks;
	    }

	    @GetMapping("/gettaskforuser")
	    public List<Task> getTasksForUser(@RequestParam(value = "user") String name) {
	        return taskService.taskAssignedToUser(name);
	    }
}
