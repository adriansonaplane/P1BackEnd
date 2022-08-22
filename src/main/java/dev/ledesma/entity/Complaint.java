package dev.ledesma.entity;

import java.util.Objects;

public class Complaint {

    private int id;
    private String category;
    private String description;
    private PriorityStatus status;
    private int meetingId;

    public Complaint(){    }
    public Complaint(int id, String category, String description, PriorityStatus status, int meetingId) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.status = status;
        this.meetingId = meetingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityStatus getStatus() {
        return status;
    }

    public void setStatus(PriorityStatus status) {
        this.status = status;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return id == complaint.id && meetingId == complaint.meetingId && Objects.equals(category, complaint.category) && Objects.equals(description, complaint.description) && status == complaint.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, description, status, meetingId);
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", meetingId=" + meetingId +
                '}';
    }
}
