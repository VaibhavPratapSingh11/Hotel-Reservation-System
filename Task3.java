package hotelreservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static int reservationCounter = 1;

    public static void main(String[] args) {
        System.out.println("\n\nHOTEL RESERVATION SYSTEM");
        initializeRooms();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Search available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookingDetails(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 300.0));
    }

    private static void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        Room room = getRoomByNumber(roomNumber);

        if (room != null && !room.isBooked()) {
            System.out.print("Enter guest name: ");
            String guestName = scanner.next();
            System.out.print("Enter number of nights: ");
            int numberOfNights = scanner.nextInt();

            room.setBooked(true);
            Reservation reservation = new Reservation(reservationCounter++, room, guestName, numberOfNights);
            reservations.add(reservation);

            System.out.println("Reservation made successfully.");
            System.out.println(reservation);
        } else {
            System.out.println("Room not available or already booked.");
        }
    }

    private static void viewBookingDetails(Scanner scanner) {
        System.out.print("Enter reservation ID: ");
        int reservationId = scanner.nextInt();
        Reservation reservation = getReservationById(reservationId);

        if (reservation != null) {
            System.out.println("\nBooking Details:");
            System.out.println(reservation);
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private static Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private static Reservation getReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }
}

