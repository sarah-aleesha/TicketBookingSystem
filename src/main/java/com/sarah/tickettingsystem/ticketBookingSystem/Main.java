package com.sarah.tickettingsystem.ticketBookingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//this object enables us to receive user input
        int tempInput = 0;
        //gathering the necessary information from the user and setting those values to the corresponding variables
        //declared in various classes

        System.out.println("Welcome to the ticketing system!");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Enter the Maximum ticket pool capacity(Enter a number more than 0) : ");//message given to the user to get the maximum amount of tickets
        // that can be available in the ticket pool

        tempInput = getAValidNumber(scanner);//gets a valid number using the getAValidNumber() method that is declared below the main method
        TicketPool.setMaximumNoOfTickets(tempInput);
        System.out.println("Enter the rate of releasing tickets (Enter a number more than 0) : ");
        tempInput = getAValidNumber(scanner);
        Vendor.setTicketReleaseRate(tempInput);
        //Customer parameters

        System.out.println("Enter the buying rate of the customer(Enter a number more than 0) : ");
        tempInput = getAValidNumber(scanner);
        Customer.setCustomerRetrievalRate(tempInput);
        System.out.println("Do you wish to save the process to a JSON file (yes/no) ? ");
        String tempChoice = yesOrNo(scanner);
        if (tempChoice.equalsIgnoreCase("yes")){
            Serialization.saveDataToJson();
        }

        //the user gets to decide if the data should be stored in the json file or not
        System.out.println("enter 'start' to start the system");
        tempChoice = scanner.nextLine();
        while(!(tempChoice.trim().equalsIgnoreCase("start"))){
            System.out.println("invalid input! enter 'start' to start the system");
            tempChoice = scanner.nextLine();
        }

        //starting the process from here onwards
        System.out.println("starting the process...");
        System.out.println("--------------------------------------------------------------------------------");

        TicketPool ticketPool = new TicketPool(TicketPool.getMaximumNoOfTickets());
        //for loop to create the required amount of threads for vendors
        while (true) {
            Vendor singleVendor = new Vendor(Vendor.getTicketCount(), ticketPool, Vendor.getTicketReleaseRate());
            Thread vendor = new Thread(singleVendor, "vendor ");// creates a vendor named thread and the value of i
            vendor.start();// calls the run method of the vendor class
            Customer singleCustomer = new Customer(Customer.getTicketsBought(), Customer.getCustomerRetrievalRate(), ticketPool);
            Thread customer = new Thread(singleCustomer, "customer ");
            customer.start();// calls the run method of the customer class
            System.out.println("enter end if you wish to end");

            if (wishToEnd(scanner)) {
                System.out.println("process Ended");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("A total of " + Vendor.getTicketCount() + " tickets were created throughout the process.");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("System closing...");
                break;
            }
        }
        scanner.close();
    }

    static String yesOrNo(Scanner scanner){
        String choice = scanner.nextLine();
        while(!(choice.trim().equalsIgnoreCase("yes")|| choice.trim().equalsIgnoreCase("no"))){
            System.out.println("enter a valid choice (yes/no)");
            choice = scanner.nextLine();
        }
        return choice.trim();
    }

    static public boolean wishToEnd(Scanner scanner){
        boolean wishesToEnd = false;
        String userChoice = scanner.nextLine();
        if(userChoice.trim().equalsIgnoreCase("end")){
            wishesToEnd = true;
        }
        return wishesToEnd;
    }

    static int getAValidNumber(Scanner scanner){
        boolean isValid = false;
        int input = 0;
        do{
            try{
                input = scanner.nextInt();
                if(input < 1){
                    System.out.println("please enter a value more than 0");
                } else isValid = true;
            } catch (InputMismatchException e){
                System.out.println("please enter a number");
                scanner.next();
            }
        } while(!isValid);
        return input;

    }

}
