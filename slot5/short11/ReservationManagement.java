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
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReservationManagement {
    private static List<Reservation> reservations = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.print("You choose: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1": createReservation(); break;
                case "2": updateReservation(); break;
                case "3": deleteReservation(); break;
                case "4": printFlightInfo(); break;
                case "5": printAll(); break;
                case "6":
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ==============================
    // 1. CREATE
    private static void createReservation() {
        System.out.println("*** Create new reservation ***");
        String id;
        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();
            if (!id.matches("\\d{6}") || findById(id) != null) {
                System.out.println("Data input is invalid");
            } else break;
        }

        String name;
        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine();
            if (!name.matches("[A-Za-z ]+")) {
                System.out.println("Data input is invalid");
            } else break;
        }

        String phone;
        while (true) {
            System.out.print("Phone: ");
            phone = sc.nextLine();
            if (!phone.matches("\\d{12}")) {
                System.out.println("Data input is invalid");
            } else break;
        }

        String room;
        while (true) {
            System.out.print("RoomNumbers: ");
            room = sc.nextLine();
            if (!room.matches("\\d{4}")) {
                System.out.println("Data input is invalid");
            } else break;
        }

        LocalDateTime bookingDate;
        while (true) {
            System.out.print("BookingDate (dd/MM/yyyy HH:mm): ");
            try {
                bookingDate = LocalDateTime.parse(sc.nextLine() + " 00:00", formatter);
                if (bookingDate.isBefore(LocalDateTime.now())) {
                    System.out.println("Data input is invalid");
                } else break;
            } catch (Exception e) {
                System.out.println("Data input is invalid");
            }
        }

        FlightInformation fi = null;
        System.out.print("Need airport pick up? (Y/N): ");
        String pickup = sc.nextLine();
        if (pickup.equalsIgnoreCase("Y")) {
            String flight, seat;
            LocalDateTime pickUpTime;

            System.out.print("Flight: ");
            flight = sc.nextLine();

            System.out.print("Seat: ");
            seat = sc.nextLine();

            while (true) {
                System.out.print("TimePickUp (dd/MM/yyyy HH:mm): ");
                try {
                    pickUpTime = LocalDateTime.parse(sc.nextLine(), formatter);
                    if (pickUpTime.isBefore(LocalDateTime.now()) || pickUpTime.isAfter(bookingDate)) {
                        System.out.println("Data input is invalid");
                    } else break;
                } catch (Exception e) {
                    System.out.println("Data input is invalid");
                }
            }
            fi = new FlightInformation(flight, seat, pickUpTime);
        }

        reservations.add(new Reservation(id, name, phone, room, bookingDate, fi));
        System.out.println("Information saved successfully.");
    }

    // ==============================
    // 2. UPDATE
    private static void updateReservation() {
        System.out.println("*** Update reservation ***");
        Reservation r = searchReservation();
        if (r == null) return;

        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!name.isEmpty() && name.matches("[A-Za-z ]+")) r.setCustomerName(name);

        System.out.print("Phone: ");
        String phone = sc.nextLine();
        if (!phone.isEmpty() && phone.matches("\\d{12}")) r.setPhoneNumber(phone);

        System.out.print("RoomNumbers: ");
        String room = sc.nextLine();
        if (!room.isEmpty() && room.matches("\\d{4}")) r.setRoomNumber(room);

        System.out.println("Information saved successfully.");
    }

    // ==============================
    // 3. DELETE
    private static void deleteReservation() {
        System.out.println("*** Delete reservation ***");
        Reservation r = searchReservation();
        if (r == null) return;
        System.out.print("Are you sure you want to delete this information? (Y/N): ");
        if (sc.nextLine().equalsIgnoreCase("Y")) {
            reservations.remove(r);
            System.out.println("Information deleted successfully.");
        }
    }

    // ==============================
    private static void printFlightInfo() {
        System.out.println("*** Flight Information ***");
        for (Reservation r : reservations) {
            if (r.getFlightInformation() != null) {
                System.out.println(r.getBookingID() + " - " + r.getCustomerName() + " - " +
                        r.getPhoneNumber() + " - " + r.getFlightInformation().toString());
            }
        }
    }

    private static void printAll() {
        if (reservations.isEmpty()) {
            System.out.println("No information to view");
            return;
        }
        System.out.println("*** Reservation Information ***");
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }

    // ==============================
    private static Reservation searchReservation() {
        while (true) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            Reservation r = findById(id);
            if (r == null) {
                System.out.println("No information found");
                System.out.print("You want to find again? (Y/N): ");
                if (!sc.nextLine().equalsIgnoreCase("Y")) return null;
            } else return r;
        }
    }

    private static Reservation findById(String id) {
        for (Reservation r : reservations) {
            if (r.getBookingID().equals(id)) return r;
        }
        return null;
    }
}

