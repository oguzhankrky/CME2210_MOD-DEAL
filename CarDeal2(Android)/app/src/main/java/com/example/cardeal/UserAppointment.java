package com.example.cardeal;

public class UserAppointment {
    // date and time added.
    User us;
    private String Date;
    private String Time;

    public UserAppointment(User us, String date, String time) {
        this.us = us;
        Date = date;
        Time = time;
    }

    public User getUs() {
        return us;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public void setUs(User us) {
        this.us = us;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setTime(String time) {
        Time = time;
    }
}
