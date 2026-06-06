
package model;

public class Ticket {
    private String ticketId, licensePlate, vehicleType, date, checkin, checkout;

    public Ticket(String ticketId, String licensePlate, String vehicleType, String date, String checkin, String checkout) {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.date = date;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getDate() {
        return date;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
