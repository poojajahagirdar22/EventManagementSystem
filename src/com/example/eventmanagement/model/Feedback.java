package com.example.eventmanagement.model;

public class Feedback {
        private String FeedbackId;
        private String eventId;
        private String userId;
        private String comments;
        private int rating;

        // Constructors, getters, and setters
        public Feedback() {}

        public Feedback(String FeedbackId, String eventId, String userId, String comments, int rating) {
            this.FeedbackId = FeedbackId;
            this.eventId = eventId;
            this.userId = userId;
            this.comments = comments;
            this.rating = rating;
        }

        public String getFeedbackId() {
            return FeedbackId;
        }

        public void setFeedbackId(String FeedbackId) {
            this.FeedbackId = FeedbackId;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }


}
