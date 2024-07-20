package com.example.eventmanagement.controllers;

import com.example.eventmanagement.model.Event;
import com.example.eventmanagement.service.EventService;

import java.time.LocalDateTime;
import java.util.Map;

public class EventController {
private EventService eventService = new EventService();
//handle creation of event
    public void createEvent(String eTitle, String eDescription, LocalDateTime date, String location, String eOrganizerId) {
        String result = eventService.createEvent(eTitle, eDescription, date, location, eOrganizerId);
        System.out.println(result);
    }

    public void deleteEvent(String eventId){
    String result = eventService.deleteEvent(eventId);
        System.out.println(result);
    }

    public void editEvent(String eventId, String eTitle, String eDescription, LocalDateTime date, String location) {
    String result = eventService.editEvent(eventId, eTitle, eDescription, date, location);
        System.out.println(result);
    }

    public void viewEventDetails(String eventId) {
    Event event = eventService.viewEventDetails(eventId);
    if(event !=null){
        System.out.println("Event Details: "+ event.toString());
    } else {
        System.out.println("Event not found!!");
    }

    }

    public void listAllEvents() {
        Map<String,Event> events = eventService.listAllEvents();
        events.forEach((eventId, event) -> System.out.println("Event ID: " + eventId + ", Event: " + event.toString()));
    }

}
