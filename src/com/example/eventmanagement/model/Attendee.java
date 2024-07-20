package com.example.eventmanagement.model;

public class Attendee {
    private String attendeeId;
    private String userId;
    private String eventId;

    public Attendee(){}

    public Attendee(String attendeeId, String userId, String eventId){
        this.attendeeId = attendeeId;
        this.userId = userId;
        this.eventId = eventId;
    }
    public String getAttendeeId(){
        return attendeeId;
    }
    public String getUserId(){
        return userId;
    }
    public String getEventId(){
        return eventId;
    }
    public void setAttendeeId(String attendeeId){
        this.attendeeId = attendeeId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public void setEventId(String eventId){
        this.eventId = eventId;
    }
}
