package com.example.eventmanagement.model;

import javax.xml.stream.Location;
import java.time.LocalDateTime;
//create event with its details
public class Event {
    private String eventId;
    private String eTitle;
    private String eDescription;
    private LocalDateTime date;
    private String location;
    private String eOrganizerId; // Id of event organizer

    //create default event constructor
    public Event(){}

    //now create parametrized constructor so as to maintain the logic and format through, also while trying to create the object of the event
    public Event(String eventId, String eTitle, String eDescription, LocalDateTime date,String location, String eOrganizerId){
        this.eventId = eventId;
        this.eTitle = eTitle;
        this.eDescription = eDescription;
        this.date = date;
        this.location = location;
        this.eOrganizerId = eOrganizerId;

    }
    // getters and setters
    public String geteventId(){
        return eventId;
    }
    public void seteventId(String eventId){
        this.eventId = eventId;
    }
    public String geteTitle(){
        return eTitle;
    }
    public void seteTitle(String eTitle){
        this.eTitle = eTitle;
    }
    public String geteDescription() {
        return eDescription;
    }
    public void seteDescription(String eDescription){
        this.eDescription = eDescription;
    }
    public LocalDateTime getDate(){
        return date;
    }
    public void setDate(LocalDateTime date){
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public String geteOrganizerId(){
        return eOrganizerId;
    }
    public void seteOrganizerId(String eOrganizerId){
        this.eOrganizerId = eOrganizerId;
    }
}
