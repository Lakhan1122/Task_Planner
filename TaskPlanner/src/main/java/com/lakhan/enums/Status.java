package com.lakhan.enums;

public enum Status {

	
	 OPEN("Open"), IN_PROGRESS("InProgress"), TESTING("Testing"), DEPLOYED("Deployed"),
	    FIXED("Fixed"), COMPLETED("Completed");
	
	    private String displayStatus;

	    Status(String displayStatus) {
	        this.displayStatus = displayStatus;
	    }

	    Status() {
	    }
}
