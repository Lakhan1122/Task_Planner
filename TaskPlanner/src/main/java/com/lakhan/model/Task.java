package com.lakhan.model;

import java.time.Instant;

import com.lakhan.enums.Status;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity(name="task_table")
public class Task {
	
	    @Id
	    @GeneratedValue
	    Integer id = 100;
	    String title;
	    String creator;
	    String Assignee;
	    String attribute;
	    Type taskType;
	    Instant dueDate;
	    Status taskStatus = Status.OPEN;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getAssignee() {
			return Assignee;
		}
		public void setAssignee(String assignee) {
			Assignee = assignee;
		}
		public String getAttribute() {
			return attribute;
		}
		public void setAttribute(String attribute) {
			this.attribute = attribute;
		}
		public Type getTaskType() {
			return taskType;
		}
		public void setTaskType(Type taskType) {
			this.taskType = taskType;
		}
		public Instant getDueDate() {
			return dueDate;
		}
		public void setDueDate(Instant dueDate) {
			this.dueDate = dueDate;
		}
		public Status getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(Status taskStatus) {
			this.taskStatus = taskStatus;
		}
		public Object[] changeStatus() {
			return null;
			// TODO Auto-generated method stub
			
		}
		public Integer getTaskID() {
			// TODO Auto-generated method stub
			return null;
		}
		public Integer getNextTaskID() {
			// TODO Auto-generated method stub
			return null;
		}
		
	    
	    
	    
	  

}
