import java.util.Scanner;

public class cinemaManager {

    private static char[][] cinemaHall;
    static Scanner sc = new Scanner(System.in);
    static int rows;
    static int seats;
    static int rowNum;
    static int seatNum;
    static int occupency;
    static int totalCapacity;
    static int currentIncome;
    static int totalincome;



    public static void main(String[] args) {

        createCinema();
        int command;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            command = sc.nextInt();
            switch (command) {
                case 1:
                    printCinemaHall();
                    break;
                
                case 2:
                    buyTicekt();
                    break;
                
                case 3:
                    showStatistics();
                    break;
                

                case 0:
                    break;

                default:
                    System.out.println("inavlid number");
    
            }
        } while (command != 0);


    }

    public static void createCinema() {
        System.out.println("Enter the number of rows:");
        rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = sc.nextInt();

        cinemaHall = new char[rows][seats];

        int firtHalfRows = rows / 2;
        int secondHalfRows = rows - firtHalfRows;
        //total capacity
        totalCapacity = rows * seats;

        // total income
        if (rows * seats <= 60) {
            totalincome = rows * seats * 10;
        } else if (rows * seats > 60 && rowNum > rows / 2){
            totalincome = (firtHalfRows * seats * 10) + (secondHalfRows * seats * 8);
        } else {
            totalincome = (firtHalfRows * seats * 10) + (secondHalfRows * seats * 8);
        }
        

        for (int i = 0; i < cinemaHall.length; i++) {
            for (int j = 0; j < cinemaHall[i].length; j++) {
                cinemaHall[i][j] = 'S';
            }
        }
    }

    public static void printCinemaHall() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaHall[0].length; i++) {
            System.out.print(" "+ i); //change for loop if needed
        }
        System.out.println();
        
        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[i].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
    }

    public static void buyTicekt() {
        
        int ticketPrice = 0; 
        

        System.out.println("Enter a row number:");
        rowNum = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        seatNum = sc.nextInt();



        if (rowNum > rows || seatNum > seats) {
            System.out.println("Wrong input!");
            buyTicekt();

        } else if (cinemaHall[rowNum - 1][seatNum - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            buyTicekt();

        } else {


            if (rows * seats <= 60) {
                ticketPrice = 10;
                currentIncome += ticketPrice;
                //totalincome = rows * seats * 10;
            } else if (rows * seats > 60 && rowNum > rows / 2){
                ticketPrice = 8;
                currentIncome += ticketPrice;
                //totalincome = (firtHalfRows * seats * 10) + (secondHalfRows * seats * 8);
            } else {
                ticketPrice = 10;
                currentIncome += ticketPrice;
                //totalincome = (firtHalfRows * seats * 10) + (secondHalfRows * seats * 8);
            }
        
            System.out.println("Ticket Price: $" + ticketPrice);
            cinemaHall[rowNum - 1][seatNum - 1] = 'B';
            occupency += 1;
            printCinemaHall();
        }
    }

    public static void showStatistics() {
        
        float percentage = (float)(occupency * 100) / (float)totalCapacity;
        
        System.out.println("Number of purchased tickets: " + occupency);
        System.out.printf("percentage: %.2f%%", percentage);
        System.out.println();
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalincome);

    }



    
}
