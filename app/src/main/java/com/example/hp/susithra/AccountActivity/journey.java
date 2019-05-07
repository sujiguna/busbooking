package com.example.hp.susithra.AccountActivity;

public class journey {
    public String location,destination,jdate,jtype;
    public int seat;
    public journey(){}
    public journey(String location,String destination ,String jdate,String jtype,int seat){
        this.destination=destination;
        this.jdate=jdate;
        this.jtype=jtype;
        this.location=location;
        this.seat=seat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
