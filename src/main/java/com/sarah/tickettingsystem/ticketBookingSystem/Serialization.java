package com.sarah.tickettingsystem.ticketBookingSystem;
import java.io.*;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serialization {

    private static final String CONFIG_FILE = "config.json";
    public static void saveDataToJson(TicketPool ticketPool, Customer customer, Vendor vendor) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();// creates an instance of GSON
        File file = new File(CONFIG_FILE);
        Configuration configuration = new Configuration(TicketPool.getMaximumNoOfTickets(),Vendor.getTicketReleaseRate(), Customer.getCustomerRetrievalRate(), Vendor.getTicketCount());
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error occured while creating a new file. " + e.getMessage());
                return;
            }
        }
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            String toJson = gson.toJson(configuration);
            bufferedWriter.write(toJson);
            System.out.println("data has finaally been added to the user ine ata time");
        } catch(IOException e){
            System.out.println("an error occurred while saving the data to a json fail");
        }


    }
}
