package com.lakhan.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lakhan.enums.Status;
import com.lakhan.enums.TaskType;



@JsonTypeName("Bug")
public class Bug extends Type{

	
	 public Bug() {
	        super(TaskType.BUG);
	    }

	    @Override
	    public Status nextStatus(Status taskStatus) {
	        switch (taskStatus) {
	            case OPEN:
	                return Status.IN_PROGRESS;
	            case IN_PROGRESS:
	                return Status.FIXED;
	            default:
	                return null;
	        }
	    }

	    @Override
	    public String toString() {
	        return taskType.getType();
	    }
}
