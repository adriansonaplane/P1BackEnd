package dev.ledesma.entity;

import java.util.Objects;

public class Meeting {

    private int id;
    private String date;
    private int time;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id && time == meeting.time && Objects.equals(date, meeting.date) && Objects.equals(location, meeting.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, location);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
}
