package com.example.eventmanagement.service;
import com.example.eventmanagement.model.Feedback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FeedbackService {
        private Map<String, Feedback> feedbackById = new HashMap<>();
        private Map<String, List<Feedback>> feedbackByEventId = new HashMap<>();

        // Method to submit feedback
        public String submitFeedback(String eventId, String userId, String comments, int rating) {
            String feedbackId = generateFeedbackId();
            Feedback feedback = new Feedback(feedbackId, eventId, userId, comments, rating);
            feedbackById.put(feedbackId, feedback);

            // Add the feedback to the list of feedback for the event
            feedbackByEventId.computeIfAbsent(eventId, k -> new ArrayList<>()).add(feedback);
            return "Feedback submitted successfully with ID: " + feedbackId;
        }

        // Method to view feedback for a given event
        public List<Feedback> viewFeedbackForEvent(String eventId) {
            return feedbackByEventId.getOrDefault(eventId, new ArrayList<>());
        }

        // Helper method to generate feedback ID
        private String generateFeedbackId() {
            return UUID.randomUUID().toString();
        }


}
