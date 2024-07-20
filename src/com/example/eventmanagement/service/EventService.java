package com.example.eventmanagement.service;

import com.example.eventmanagement.model.Event;
import java.time.LocalDateTime;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EventService {
    //events map
    private Map<String, Event> eventsById = new HashMap<>();
    //generate event UUID
    String eventId = UUID.randomUUID().toString();

    //create event
    public String createEvent(String eTitle, String eDescription, LocalDateTime date, String location, String eOrganizerId) {
        Event newEvent = new Event(eventId, eTitle, eDescription, date, location, eOrganizerId);
        eventsById.put(eventId, newEvent);
        return "Event created Successfully with ID: " + eventId;
    }

    //delete event
    public String deleteEvent(String eventId) {
        Event event = getEventById(eventId);
        if(event == null)
        {
            return "Event not found!!";
        }
        eventsById.remove(eventId);
        return "Event deleted successfully";
    }
//update event
    public String editEvent(String eventId, String eTitle, String eDescription, LocalDateTime date, String location){
        Event event = getEventById(eventId);
        if (event == null){
            return "Event not found!!";
        }
        event.seteTitle(eTitle);
        event.seteDescription(eDescription);
        event.setDate(date);
        event.setLocation(location);
        return "Event Updated successfully!!";
    }

//view event
    public Event viewEventDetails(String eventId){
            return getEventById(eventId);
    }
//list of events
    public Map<String, Event> listAllEvents(){
        return eventsById;
    }

//method to get an event by its ID from the map
    public Event getEventById(String eventId) {
        return eventsById.get(eventId);
    }
}