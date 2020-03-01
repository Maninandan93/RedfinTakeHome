package com.redfin.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.redfin.dto.FoodTruck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/*
Service to get Food Truck info from the Socrata Api
 */
public class FoodTruckService {
    /**
     *
     * @return Treemap with list of FoodTrucks sorted in alphabetical order
     */
    public static Map<String, FoodTruck> getFoodTrucks(){
        Calendar now = Calendar.getInstance();
        /*foodTrucks Map used to store FoodTrucks in alphabetical order
            key = Applicant Name + FoodTruck Permit
            value = FoodTruck
          */
        Map<String, FoodTruck> foodTrucks = new TreeMap<>();
        try {
            StringBuilder result = new StringBuilder();
            //dayOrder contains current DAYORDER of week, eg: Sun-0, Mon-1, ..
            int dayOrder = now.get(Calendar.DAY_OF_WEEK) - 1;
            //Request url to retrieve open FoodTrucks data filtering on dayorder
            String urlString = "https://data.sfgov.org/resource/jjew-r69b.json?dayorder="+dayOrder;
            URL url = new URL(urlString);
            //Open Get request Http Connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            //Read the response using Inputstreamreader and bufferedReader
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            // append Response to StringBuilder object : result
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            //close reader and httpConnections
            rd.close();
            conn.disconnect();
            Gson gson = new Gson();
            //Convert the list of FoodTrucks response into JsonArray
            JsonArray foodTruckArray = new JsonParser().parse(result.toString()).getAsJsonArray();
            FoodTruck foodTruck;
            String key;
            //Create FoodTruck object for each Element in Json Foodtruck Array using gson Libraries
            for(JsonElement foodTruckJson : foodTruckArray){
                try {
                    foodTruck = gson.fromJson(foodTruckJson, FoodTruck.class);
                    //key = Applicant Name + FoodTruck Permit
                    key = foodTruck.getApplicant()+foodTruck.getPermit();
                    //Insert key and values in foodTrucks map
                    foodTrucks.put(key,foodTruck);
                }
                //catch Exceptions if occured any during parsing FoodTruck object
                catch (Exception e){
                    System.out.println("Exception occured ::"+e.getMessage());
                }
            }
        }
        //catch Exceptions if occured any
        catch (Exception e) {
            System.out.println("exception occured ::"+e.getMessage());
        }

        return foodTrucks;
    }

}
