
package project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        
        Theater theater = new Theater();
        
        while (!exit) {
            System.out.println("Welcome to the LUT Kino at Yliopistonkatu!");
            System.out.println("1. Add a movie\n2. Remove a movie\n3. View a movie\n4. View all movies\n5. Add a showtime\n6. Remove a showtime\n7. View a showtime\n8. View all showtimes\n9. Buy a ticket\n10. View seating\n0. Exit");
            System.out.print("Enter your choice:");
            //int choice;
            //choice = Integer.parseInt(sc.nextLine());
            try {
                if (sc.hasNext()) {
                
                    int userSelection;
            
                    userSelection = Integer.parseInt(sc.nextLine());
                
            
                    switch (userSelection) {
                
                        case 1:
                            theater.addMovie();
                            break;
                    
                        case 2:
                            theater.removeMovie();
                            break;
                    
                        case 3:
                            theater.viewAMovie();
                            break;
                    
                        case 4:
                            theater.viewAllMovie();
                            break;
                    
                        case 5:
                            theater.addShowTime();
                            break;
                    
                        case 6:
                            theater.removeShowTime();
                            break;
                    
                        case 7:
                            theater.viewAShowTime();
                            break;
                
                        case 8:
                            theater.viewAllShowTime();
                            break;
                    
                        case 9:
                            theater.buyTicket();
                            break;
                    
                        case 10:
                            theater.viewSeating();
                            break;
                    
                        case 0:
                            exit = true;
                            System.out.println("Goodbye!");
                            break;
                            
                        default:
                            System.out.println("Please input integers from 0-10!");
                    }
                }
                
            }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input, please enter an integer!");
                }
            
        }
        
        
           
    }

}
