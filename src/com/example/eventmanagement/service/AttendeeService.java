package com.example.eventmanagement.service;

import com.example.eventmanagement.model.Attendee;
import java.util.*;

public class AttendeeService {
    private Map<String, Attendee> attendeeById = new HashMap<>();
    private Map<String, List<Attendee>> attendeeByEventId = new HashMap<>();

    //Register attendee
    public String RegisterAttendee(String userId, String eventId){
        String attendeeId = generateAttendeeId();
        Attendee newAttendee = new Attendee(attendeeId, userId, eventId);
        attendeeById.put(attendeeId, newAttendee);
        //
        attendeeByEventId.computeIfAbsent(eventId, k -> new ArrayList<>()).add(newAttendee);
        return "Attendee registered successfully with ID: " + attendeeId;
    }
    public String generateAttendeeId(){
        return UUID.randomUUID().toString();
    }
    //view attendee list
    public List<Attendee> ViewAttendeeList(String eventId){
        return attendeeByEventId.getOrDefault(eventId, new ArrayList<>());
    }
    //send reminder to attendees
    public String SendReminder(String eventId) {
        List<Attendee> attendees = ViewAttendeeList(eventId);
        if (attendees.isEmpty()){
            return "No attendees for the event";
        }
        attendees.forEach(attendee -> System.out.println("Reminder sent to user ID: " + attendee.getUserId()));
    return "Reminders sent to all attendees of event ID: " + eventId;
    }
}
