package com.example.hp.susithra.AccountActivity;

public class journeyX {
    private String destination,jdate,jtype,location;
    private int seat;

    public journeyX() {
    }

    public journeyX(String destination, String jdate, String jtype, String location, int seat) {
        this.destination = destination;
        this.jdate = jdate;
        this.jtype = jtype;
        this.location = location;
        this.seat = seat;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getJdate() {
        return jdate;
    }

    public void setJdate(String jdate) {
        this.jdate = jdate;
    }

    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}
