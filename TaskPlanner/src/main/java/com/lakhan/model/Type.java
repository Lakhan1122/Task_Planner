package com.lakhan.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lakhan.enums.Status;
import com.lakhan.enums.TaskType;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Bug.class, name = "Bug"),
    @JsonSubTypes.Type(value = Feature.class, name = "Feature"),
    @JsonSubTypes.Type(value = Story.class, name = "Story")})
public abstract class Type {

	   TaskType taskType;

	    public Type(TaskType taskType) {
	        this.taskType = taskType;
	    }

	    public TaskType getTaskType() {
	        return taskType;
	    }

	    abstract Status nextStatus(Status taskStatus);

}
