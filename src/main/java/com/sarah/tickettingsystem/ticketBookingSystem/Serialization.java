package com.sarah.tickettingsystem.ticketBookingSystem;
import java.io.*;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Serialization {

    private static final String CONFIG_FILE = "config.json";
    public static void saveDataToJson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();// creates an instance of GSON
        File file = new File(CONFIG_FILE);
        Configuration configuration = new Configuration(TicketPool.getMaximumNoOfTickets(),Vendor.getTicketReleaseRate(), Customer.getCustomerRetrievalRate(), Vendor.getTicketCount());
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error occurred while creating a new file. " + e.getMessage());
                return;
            }
        }
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            /*an instance of a file writer is being wrapped around a buffered class
            to prevent having to communicate with the file system for each character*/
            String toJson = gson.toJson(configuration);// this converts the configuration object to JSON format to write it to the file
            bufferedWriter.write(toJson);//writes the the Json formatted string to the file
            System.out.println("data has been added to the file");
        } catch(IOException e){
            System.out.println("an error occurred while saving the data to a json fail");
        }

    }

    public static void loadDataFromJson() {
        Gson gson = new Gson();
        File file = new File(CONFIG_FILE);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG_FILE))){
            String eachLine;
            while((eachLine = bufferedReader.readLine()) != null){
                System.out.println(eachLine + "\n");
            }
        } catch (IOException e){
            System.out.println("an error has occurred while attempting to load data from the JSON file: ");
            e.printStackTrace();
        }
    }
}
