public class Ticket {
    private String ticketId ;
    private int seatNumber;
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private String username;
    private double price;


    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId() {
        String str = String.valueOf(seatNumber);
        ticketId = flightId + str ;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int z) {
        seatNumber  = 100 + z ;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
