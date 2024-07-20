package com.example.eventmanagement;

import com.example.eventmanagement.controllers.AttendeeController;
import com.example.eventmanagement.controllers.UserController;
import com.example.eventmanagement.controllers.EventController;
import com.example.eventmanagement.controllers.FeedbackController;
import java.time.LocalDateTime;
import java.util.UUID;

public class EventManagementSystemApplication {
    public static void main(String[] args) {
        UserController userController = new UserController();
        EventController eventController = new EventController();
        AttendeeController attendeeController = new AttendeeController();
        FeedbackController feedbackController = new FeedbackController();
        // Test user registration
        //1: pass
        userController.registerUser("abc", "ab.cd1@gmail.com", "Password@1234");
        //2: pass
        userController.registerUser("efg", "ef.gh1@gmail.com", "Password@567");
        //3: fail saying email exists
        userController.registerUser("abc", "ab.cd1@gmail.com", "Password@1234");
        //4: fail email invalid
        userController.registerUser("abcx", "1Ab.cd1@g1.com1", "1234");

        //Test user login
        //1: pass
        userController.loginUser("ab.cd1@gmail.com", "Password@1234");
        //2: email doesnot exist
        userController.loginUser("ab.cd@gmail.com", "Password@1234");
        //3: invalid password
        userController.loginUser("ab.cd1@gmail.com", "Password@12345");

        //Test updating user profile
        //1: email already exists, update failed
        userController.UpdateUserProfile("1", "abcd", "ab.cd1@gmail.com");
        //2: email updated
        userController.UpdateUserProfile("2", "efg", "efgh@gmail.com");
        //3: new user added-doubtful
        userController.UpdateUserProfile("1", "abcd", "ab.cd@gmail.com");


        //Test event creation
        //1:
        eventController.createEvent("Conference", "Tech Conference", LocalDateTime.now().plusDays(10), "Pune", "1");

        //Test list of event
        //1:
        eventController.listAllEvents();

        //Test view event details
        //1:
        eventController.viewEventDetails("1");

        //Test update event
        //1:
        eventController.editEvent("1", "New Conference", "New data for Tech Conference", LocalDateTime.now().plusDays(15), "Gulbarga");


        //Test deletion of event
        //1:
        eventController.deleteEvent("1");

        // Test registering attendees
        attendeeController.RegisterAttendee("1", "1");
        attendeeController.RegisterAttendee("2", "1");

        // Test viewing attendee list
        attendeeController.ViewAttendeeList("1");

        // Test sending reminders
        attendeeController.SendReminder("1");

        // Test submitting feedback
        feedbackController.submitFeedback("1", "1", "Great event!", 5);
        feedbackController.submitFeedback("1", "2", "Very informative.", 4);

        // Test viewing feedback for an event
        feedbackController.viewFeedbackForEvent("1");
    }
}
