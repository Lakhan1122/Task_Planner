package com.lakhan.enums;


public enum TaskType {

	
	BUG("bug"), STORY("Story"), FEATURE("Feature");
    String type;

    TaskType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
