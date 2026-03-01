//Ahmed hassan 20240024
import java.util.Scanner;

public class TicketBookingSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Welcome to Ticket Booking System ");
        System.out.println("=================================");

        String[][] seats = new String[10][10];
        char c = 'A';

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                seats[i][j] = c + "" + (j+1);
            }
            c++;
        }

        boolean[][] booked = new boolean[10][10];
        boolean run = true;

        while(run){

            System.out.println("\n1 Display Seats");
            System.out.println("2 Book Seat");
            System.out.println("3 Cancel Seat");
            System.out.println("4 Exit");
            System.out.print("Choose: ");

            int choice = input.nextInt();

            switch(choice){

                case 1:
                    for(int i=0;i<10;i++){
                        for(int j=0;j<10;j++){
                            if(booked[i][j]){
                                System.out.print("[X]\t");
                            }else{
                                System.out.print("[" + seats[i][j] + "]\t");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Enter row A-J: ");
                    int r = input.next().toUpperCase().charAt(0)-'A';
                    System.out.print("Enter seat 1-10: ");
                    int s = input.nextInt()-1;

                    if(r>=0 && r<10 && s>=0 && s<10){
                        if(!booked[r][s]){
                            booked[r][s]=true;
                            System.out.println("Booked " + seats[r][s]);
                        }else{
                            System.out.println("Already booked");
                        }
                    }else{
                        System.out.println("Invalid input");
                    }
                    break;

                case 3:
                    System.out.print("Enter row A-J: ");
                    int cr = input.next().toUpperCase().charAt(0)-'A';
                    System.out.print("Enter seat 1-10: ");
                    int cs = input.nextInt()-1;

                    if(cr>=0 && cr<10 && cs>=0 && cs<10){
                        if(booked[cr][cs]){
                            booked[cr][cs]=false;
                            System.out.println("Canceled " + seats[cr][cs]);
                        }else{
                            System.out.println("Not booked");
                        }
                    }else{
                        System.out.println("Invalid input");
                    }
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("Wrong choice");
            }

            if(run){
                System.out.print("\nDo you want to do anything else? (yes/no): ");
                String again = input.next();
                if(again.equalsIgnoreCase("no")){
                    run = false;
                }
            }
        }

        System.out.println("Thank you for using the system!");
        input.close();
    }
}
