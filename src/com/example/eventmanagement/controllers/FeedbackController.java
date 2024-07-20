package com.example.eventmanagement.controllers;

import com.example.eventmanagement.model.Feedback;
import com.example.eventmanagement.service.FeedbackService;

import java.util.List;

public class FeedbackController {
private FeedbackService feedbackService = new FeedbackService();

        // Method to handle submitting feedback
        public void submitFeedback(String eventId, String userId, String comments, int rating) {
            String result = feedbackService.submitFeedback(eventId, userId, comments, rating);
            System.out.println(result);
        }

        // Method to handle viewing feedback for an event
        public void viewFeedbackForEvent(String eventId) {
            List<Feedback> feedbackList = feedbackService.viewFeedbackForEvent(eventId);
            if (feedbackList.isEmpty()) {
                System.out.println("No feedback found for the event.");
            } else {
                feedbackList.forEach(feedback -> System.out.println("Feedback ID: " + feedback.getFeedbackId() + ", User ID: " + feedback.getUserId() + ", Comments: " + feedback.getComments() + ", Rating: " + feedback.getRating()));
            }
        }


}
