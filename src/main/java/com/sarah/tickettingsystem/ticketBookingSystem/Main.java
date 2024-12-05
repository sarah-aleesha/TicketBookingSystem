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
        while(true) {
            System.out.println("Welcome to the ticketing system!");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Enter the Maximum ticket pool capacity(Enter a number more than 0) : ");//message given to the user to get the maximum amount of tickets
            // that can be available in the ticket pool
            tempInput = getAValidNumber();//gets a valid number using the getAValidNumber() method that is declared below the main method
            TicketPool.setMaximumNoOfTickets(tempInput);
            System.out.println("Enter the number of tickets to be added by the vendor(Enter a number more than 0) : ");
            tempInput = getAValidNumber();
            Vendor.setNoOfTicketsToAdd(tempInput);
            System.out.println("Enter the rate of releasing tickets (Enter a number more than 0) : ");
            tempInput = getAValidNumber();
            Vendor.setTicketReleaseRate(tempInput);
            //Customer parameters
            System.out.println("Enter the buying rate of the customer(Enter a number more than 0) : ");
            tempInput = getAValidNumber();
            Customer.setCustomerRetrievalRate(tempInput);
            System.out.println("Enter the number of tickets to be bought by the vendor(Enter a number more than 0) : ");
            tempInput = getAValidNumber();
            Customer.setTicketsBought(tempInput);
            System.out.println("enter the number of customers");
            int noOfCustomers = getAValidNumber();
            //starting the process from here onwards
            System.out.println("starting the process...");
            System.out.println("--------------------------------------------------------------------------------");

            TicketPool ticketPool = new TicketPool(TicketPool.getMaximumNoOfTickets());
            int totalTicketsCreated = 0;
            //for loop to create the required amount of threads for vendors
            while (!wishToEnd()) {
                totalTicketsCreated += 1;
                Vendor singleVendor = new Vendor(totalTicketsCreated, ticketPool, Vendor.getTicketReleaseRate(), Vendor.getNoOfTicketsToAdd());
                Thread vendor = new Thread(singleVendor, "single " + totalTicketsCreated);// creates a vendor named thread and the value of i
                vendor.start();// calls the run method of the vendor class
                Customer singleCustomer = new Customer( Customer.getTicketsBought(), Customer.getCustomerRetrievalRate(), ticketPool);
                Thread customer = new Thread(singleCustomer, "customer " + totalTicketsCreated);
                customer.start();// calls the run method of the customer class
            }
            if (wishToEnd()) {
                System.out.println("process Ended");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("A total of " + totalTicketsCreated + " tickets were created throughout the process.");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("System closing...");
                break;
            }
        }
    }

    static public boolean wishToEnd(){
        Scanner input = new Scanner(System.in);
        boolean wishesToEnd = false;
        System.out.println("enter end if you wish to end");
        String userChoice = input.next();
        if(userChoice.trim().equalsIgnoreCase("end")){
            wishesToEnd = true;
        }
        return wishesToEnd;
    }

    static int getAValidNumber(){
        Scanner scanner = new Scanner(System.in);
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
