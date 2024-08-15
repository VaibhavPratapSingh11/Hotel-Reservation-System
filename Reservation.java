package hotelreservationsystem;

public class Reservation {
    private int reservationId;
    private Room room;
    private String guestName;
    private int numberOfNights;
    private double totalAmount;

    public Reservation(int reservationId, Room room, String guestName, int numberOfNights) {
        this.reservationId = reservationId;
        this.room = room;
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
        this.totalAmount = room.getPricePerNight() * numberOfNights;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", room=" + room +
                ", guestName='" + guestName + '\'' +
                ", numberOfNights=" + numberOfNights +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

