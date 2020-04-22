package com.api.pojo;

/*Used following POJO to represent booking and some of ist attribute*/

public class Booking {

    private com.api.pojo.Bookingdates bookingdates;
    private int bookingid;
    private boolean depositpaid;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private int roomid;


    public Booking(int bookingid, boolean depositpaid, String email, String firstname, String lastname, String phone, int roomid, String checkin, String checkout)
    {
        this.bookingid=bookingid;
        this.depositpaid=depositpaid;
        this.email=email;
        this.firstname=firstname;
        this.lastname=lastname;
        this.phone=phone;
        this.roomid=roomid;
        bookingdates = new Bookingdates(checkin,checkout);
    }
    // Getter Methods
}

class Bookingdates {
    private String checkin;
    private String checkout;

    public Bookingdates(String checkin, String checkout){
        this.checkin=checkin;
        this.checkout=checkout;
    }
}