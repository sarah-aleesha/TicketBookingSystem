package com.sarah.tickettingsystem.ticketBookingSystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Serialization {
    public static void saveDataToJson(TicketPool ticketPool, Customer customer, Vendor vendor) throws IOException {
        File file = new File("data.json");
        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file, true));//this wraps around a filewriter object
                                                                                                // and enables appending using "true" as the second argument
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error occured while creating a new file. " + e.getMessage());
                return;
            }
        }
        bufferedwriter.write("Ticket Pool details\n" + ticketPool.toString());
        bufferedwriter.newLine();//adds a new line after each log
        //similarly for the rest of the classes...
        bufferedwriter.write("Vendor details\n" + vendor.toString());
        bufferedwriter.newLine();//adds a new line after each log

        bufferedwriter.write("Customer details\n" + customer.toString());
        bufferedwriter.newLine();//adds a new line after each log
        //after completing operations using the BufferedWriter, it is essential to close the object to prevent leaks;

        bufferedwriter.close();

    }
}
