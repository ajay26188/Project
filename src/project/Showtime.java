
package project;

import java.time.LocalDateTime;

public class Showtime {
    Movie movie; //Movie object
    private LocalDateTime dateTime;
    private double ticketPrice;
    private Seat[][] seats;
    
    public Seat[][] getSeats() {
        return seats;
    }
    
    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
     
    
    public double getTicketPrice() {
        return ticketPrice;
    }
    
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    
    public String toString() {
        return "DateTime: "+ dateTime + ", Movie: "+ movie.getTitle()+", Ticket Price: "+ ticketPrice;
    }
}
