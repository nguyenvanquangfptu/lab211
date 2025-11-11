/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab211.slot5.short11;

/**
 *
 * @author HP
 */
import java.time.LocalDateTime;

public class Reservation {

    private String bookingID;
    private String customerName;
    private String phoneNumber;
    private String roomNumber;
    private LocalDateTime bookingDate;
    private FlightInformation flightInformation;

    // Constructor có tham số
    public Reservation(String bookingID, String customerName, String phoneNumber,
            String roomNumber, LocalDateTime bookingDate, FlightInformation flightInformation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }

    // Constructor mặc định
    public Reservation() {
        this.bookingID = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = "";
        this.bookingDate = LocalDateTime.now();
        this.flightInformation = null;
    }

    // Getter / Setter
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }

    @Override
    public String toString() {
        String flightInfo = (flightInformation != null) ? flightInformation.toString() : "";
        return bookingID + " - " + customerName + " - " + phoneNumber + " - "
                + roomNumber + " - " + bookingDate + " - " + flightInfo;
    }
}
