package com.lakhan.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lakhan.enums.Status;
import com.lakhan.enums.TaskType;


@JsonTypeName("Feature")
public class Feature extends Type {

	

    public Feature() {
        super(TaskType.FEATURE);
    }
    @Override
    public Status nextStatus(Status taskStatus) {
        switch (taskStatus) {
            case OPEN:
                return Status.IN_PROGRESS;
            case IN_PROGRESS:
                return Status.TESTING;
            case TESTING:
                return Status.DEPLOYED;
            default:
                return null;
        }
    }
}
