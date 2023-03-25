package com.lakhan.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lakhan.enums.Status;
import com.lakhan.enums.TaskType;

@JsonTypeName("Story")
public class Story extends Type {

	
	 Integer subTrackID;
	    public Story() {
	        super(TaskType.STORY);
	    }
	    List<SubTrack> subTracks = new ArrayList<>();

	    public List<SubTrack> getSubTracks() {
	        return subTracks;
	    }

	    public void setSubTracks(List<SubTrack> subTracks) {
	        this.subTracks = subTracks;
	    }

	    public void  addSubTracks(SubTrack subTrack) {
	        if (subTrack.status != Status.COMPLETED)
	            subTracks.add(subTrack);
	    }

	    public Integer getSubTrackID() {
	        return subTrackID;
	    }

	    @Override
	    public Status nextStatus(Status taskStatus) {
	        switch (taskStatus) {
	            case OPEN:
	                return Status.IN_PROGRESS;
	            case IN_PROGRESS:
	                return Status.COMPLETED;
	            default:
	                return null;
	        }
	    }

	    public class SubTrack {
	        String title;
	        Status status=Status.OPEN;
	        public String getTitle() {
	            return title;
	        }

	        public void setTitle(String title) {
	            this.title = title;
	        }

	        public SubTrack(String title) {
	            this.title = title;
	            subTrackID++;
	        }

	        public Status nextStatus(Status taskStatus) {
	            switch (taskStatus) {
	                case OPEN:
	                    return Status.IN_PROGRESS;
	                case IN_PROGRESS:
	                    return Status.COMPLETED;
	                default:
	                    return null;
	            }
	        }
	    }
}
