package com.example.eventmanagement.controllers;

import com.example.eventmanagement.model.Attendee;
import com.example.eventmanagement.service.AttendeeService;

import java.util.HashMap;
import java.util.List;

public class AttendeeController {
    //create attendee service object
    private AttendeeService attendeeService = new AttendeeService();

    //handle attendee registration
    public void RegisterAttendee(String userId, String eventId){
        String result = attendeeService.RegisterAttendee(userId, eventId);
        System.out.println(result);
    }

    //handle list of attendee display
    public void ViewAttendeeList(String eventId){
        List<Attendee> attendees = attendeeService.ViewAttendeeList(eventId);
        if (attendees.isEmpty()){
            System.out.println("No attendees found for this event.");
        }
        else {
            attendees.forEach(attendee -> System.out.println("Attendees ID: " + attendee.getAttendeeId() + ", User ID: " + attendee.getUserId()));
        }
    }

    //handle sending of reminders
    public void SendReminder(String eventId){
        String result = attendeeService.SendReminder(eventId);
        System.out.println(result);
    }

}
