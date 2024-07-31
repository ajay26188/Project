
package project;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;


public class Theater {
    Scanner sc = new Scanner(System.in);
    private int rowNum;
    private int colNum;
    ArrayList <Movie> movies = new ArrayList<>();
    ArrayList <Showtime> showtimes = new ArrayList<>();
    Seat[][] seats = new Seat[6][6]; //5 rows and 5 columns ; rows and columns start from 1
            
    public void addMovie() {
        
        System.out.print("Enter the movie title:");
        String title = sc.nextLine();
        
        System.out.print("Enter the director:");
        String director = sc.nextLine();
        
        System.out.print("Enter the duration:");
        int duration;
        duration = Integer.parseInt(sc.nextLine());
        
        movies.add(new Movie(title, director, duration));
        System.out.println("Movie added successfully!");
    }
    
    public void removeMovie() {
        System.out.println("Enter the title of the movie to remove:");
        String title = sc.nextLine();
        boolean removed = false;
        
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equalsIgnoreCase (title)) {
                movies.remove(i);
                removed = true;
                break;
        }
        }
        if (removed) {
            System.out.println("Movie removed successfully!");
        }
        else {
            System.out.println("Movie not found.");
        }
    }
    
    public void viewAMovie() {
        System.out.println("Enter the title of the movie you want to view:");
        String title = sc.nextLine();
        boolean found = false;
        
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("---------------------");
                System.out.println("Title: "+m.getTitle());
                System.out.println("Director: "+m.getDirector());
                System.out.println("Duration: "+m.getDuration()+" minutes");
                System.out.println("---------------------");
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Movie found!");
        }
        else {
            System.out.println("Movie not found.");
        }
    }
    
    public void viewAllMovie() {
        if (movies.isEmpty()) {
            System.out.println("No movie available.");
        }
        else {
            System.out.println("List of movies:");
            for (Movie m: movies) {
                System.out.println("---------------------");
                System.out.println("Title: "+m.getTitle());
                System.out.println("Director: "+m.getDirector());
                System.out.println("Duration: "+m.getDuration()+" minutes");
                System.out.println("---------------------");
            }
        }
    }
    public void addShowTime() {
        System.out.println("Enter the details for adding a showtime!");
        
        System.out.println("Enter the movie title:");
        String title = sc.nextLine();
        Movie movie = null;
        
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                movie = m;
                break;
            }
        }
        if (movie == null) {
            System.out.println("Movie not found!");
            return;
        }
        
        System.out.println("Enter the year:");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the month(1-12):");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the day of month:");
        int day = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the hour(0-23):");
        int hour = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the minute:");
        int minute = Integer.parseInt(sc.nextLine());
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);
        
        System.out.println("Enter the ticket price:");
        double ticketPrice = Double.parseDouble(sc.nextLine());
        
        Showtime showtime = new Showtime();
        showtime.setMovie(movie);
        showtime.setDateTime(dateTime);
        showtime.setTicketPrice(ticketPrice);
        
        showtimes.add(showtime);
        System.out.println("Showtime added successfully!");
    }
    
    public void removeShowTime() {
        System.out.println("Enter the date and time of the showtime you want to remove:");
        
        //Details for the showtime
        System.out.println("Enter the year:");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the month(1-12):");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the day of month:");
        int day = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the hour(0-23):");
        int hour = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the minute:");
        int minute = Integer.parseInt(sc.nextLine());
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);
        
        boolean removed = false;
        for (int i = 0; i < showtimes.size(); i++) {
            Showtime st = showtimes.get(i);
            if (st.getDateTime().isEqual(dateTime)) {
                showtimes.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Showtime removed successfully!");
        }
        else {
            System.out.println("Showtime not found!");
        }
    }
    
    public void viewAShowTime() {
        System.out.println("Enter the title of the movie you want to view showtime for:");
        String title = sc.nextLine();
        
        //Check if the movie exists
        boolean movieExists = false;
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                movieExists = true;
                break;
            }
        }
        
        if (!movieExists) {
            System.out.println("Movie not found");
            return;
        }
        
        //Display showtimes for a movie
        boolean found = false;
        for (Showtime s: showtimes) {
            if (s.getMovie().getTitle().equalsIgnoreCase(title)) {
                System.out.println("---------------------");
                System.out.println(s.toString());
                System.out.println("---------------------");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No showtimes found for "+title+"!");
        }
    }
    
    public void viewAllShowTime() {
        if (showtimes.isEmpty()) {
            System.out.println("No shotimes available!");
        }
        else {
            System.out.println("List of showtimes:");
            for (Showtime s: showtimes) {
                System.out.println("---------------------");
                System.out.println("Movie title: "+s.getMovie().getTitle());
                System.out.println("Showtime: "+s.getDateTime());
                System.out.println("Ticket Price: "+s.getTicketPrice());
                System.out.println("---------------------");
            }
        }
    }
    
    public boolean findMovies(String title) {
        boolean found = false;
        
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie not found!");
        }
        return found;
    }
    
    // This method is for checking if showtime exists for a particular movie and date time
    public boolean findShowtimes(String title, LocalDateTime dateTime) {
        boolean found = false;
        
        for (Showtime st: showtimes) {
            if (st.getMovie().getTitle().equalsIgnoreCase(title) && st.getDateTime().isEqual(dateTime)) {
                System.out.println("---------------------");
                System.out.println("Movie title: "+st.getMovie().getTitle());
                System.out.println("Director: "+st.getMovie().getDirector());
                System.out.println("Duration: "+st.getMovie().getDuration()+" minutes");
                System.out.println("Showtime: "+st.getDateTime().toString());
                System.out.println("Ticket Price: "+st.getTicketPrice());
                System.out.println("---------------------");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Showtime not found!");
        }
        
        return found;        
}
    // This method ask the user for movie title, showtime details and seat prefernces and if all exists, the user can buy a ticket
    public void buyTicket() {
        System.out.println("Enter the title of the movie you want to view:");
        String title = sc.nextLine();
        
        boolean movieFound = findMovies(title);
        
        if (movieFound) {
            //If the movie exists, then user will be asked about the showtime details and if that also exists then user can proceed to select a seat.
            System.out.println("Showtime details:");
            System.out.println("Enter the year:");
            int year = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the month(1-12):");
            int month = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the day of month:");
            int day = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the hour(0-23):");
            int hour = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the minute:");
            int minute = Integer.parseInt(sc.nextLine());
            LocalDateTime dateTime = LocalDateTime.of(year,month, day, hour, minute);
        
            boolean found = findShowtimes(title, dateTime);
        
            if (found) {
                //Users can select the seat and the seat will be occupied after it is bought.
                System.out.println("Enter the row number:");
                int row = Integer.parseInt(sc.nextLine());
                
                System.out.println("Enter the column number:");
                int col = Integer.parseInt(sc.nextLine());
                
                if (row < seats.length && col < seats[0].length && seats[row][col] == null) {
                    seats[row][col] = new Seat(row,col);
                    System.out.printf("Seat [%d][]%d] bought!",row,col);
                    System.out.println();
                }
                else {
                    System.out.println("Invalid row or column number or seat alreday occupied!");
                }
            }
        }
        
    }
   
    // This method will display all the seats with the status "Enpty" or "Occupied".
    public void viewSeating() {
        System.out.println("Enter the title of the movie:");
        String title = sc.nextLine();
        
        //Finding movie first
        Movie movie = null;
        for (Movie m: movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                movie = m;
                break;
            }
        }
        if (movie == null) {
            System.out.println("Movie not found!");
            return;
        }
        
        
        System.out.println("Showtime details:");
        System.out.println("Enter the year:");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the month(1-12):");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the day of month:");
        int day = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the hour(0-23):");
        int hour = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the minute:");
        int minute = Integer.parseInt(sc.nextLine());
        LocalDateTime dateTime = LocalDateTime.of(year,month, day, hour, minute);
        
        Showtime showtime = null;
        for (Showtime st : showtimes) {
            if (st.getMovie().equals(movie) && st.getDateTime().isEqual(dateTime)) {
                showtime = st;
                break;
            }
        }
        
        if (showtime == null) {
            System.out.println("Showtime not found!");
            return;
        }
        
        System.out.println("Seating information:");
        for (int i = 1; i < seats.length ; i++) {
            for (int j = 1; j < seats[i].length ; j++) {
                Seat seat = showtime.getSeats()[i][j];
                if (seats[i][j]==null) {
                    System.out.printf("Seat [%d][%d]: [Empty]",i,j);
                    System.out.println();
                }
                else {
                    System.out.printf("Seat [%d][%d]: [Occupied]",i,j);
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

}
