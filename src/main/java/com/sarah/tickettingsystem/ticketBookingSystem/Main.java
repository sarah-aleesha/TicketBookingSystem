package com.sarah.tickettingsystem.ticketBookingSystem;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    private static int input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//this object enables us to receive user input
        int tempInput = 0;

        System.out.println("Welcome to the ticketing system!");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Enter the Maximum ticket pool capacity(Enter a number more than 0) : ");
        tempInput = getAValidNumber();
        TicketPool.setMaximumNoOfTickets(tempInput);
        System.out.println("Enter the number of tickets to be added by the vendor(Enter a number more than 0) : ");
        tempInput =  getAValidNumber();
        Vendor.setNoOfTicketsToAdd(tempInput);
        System.out.println("Enter the rate of releasing tickets (Enter a number more than 0) : ");
        tempInput =  getAValidNumber();
        Vendor.setTicketReleaseRate(tempInput);
        System.out.println("Enter the buying rate of the customer(Enter a number more than 0) : ");
        tempInput =  getAValidNumber();
        Customer.setCustomerRetrievalRate(tempInput);
        System.out.println("Enter the number of tickets to be bought by the vendor(Enter a number more than 0) : ");
        tempInput =  getAValidNumber();
        Customer.setTicketsBought(tempInput);

    }
    static int getAValidNumber(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int input = 0;
        do{
            try{
                input = scanner.nextInt();
                if(input < 1){
                    System.out.println("please enter a value more than 0");
                } else valid = true;
            } catch (InputMismatchException e){
                System.out.println("please enter a number");
            }
        } while(!valid);
        return input;

    }

}
