import com.redfin.dto.FoodTruck;

import java.util.*;

public class Util {

    /**
     * method to prints 10 trucks
     * @param trucksList : List of open Food Trucks
     * @param startIndex : index from where next 10 trucks are printed
     * @return startIndex for the next set of 10
     */
    public static int printTen(List<FoodTruck> trucksList, int startIndex){
        int ctr = 0;
        FoodTruck foodTruck;
        for (;startIndex<trucksList.size()&&ctr<10; startIndex++,ctr++){
            foodTruck = trucksList.get(startIndex);
            //print open Food Truck Name, Location and Permit Number
            System.out.println(foodTruck.getApplicant()+" "+ foodTruck.getLocation()+" "+ foodTruck.getPermit());
        }
        if(startIndex!= trucksList.size())
            System.out.print("Press enter to display next 10");
        return startIndex;
    }

    /**
     * Method to retrieve List of open trucks at current date and time
     * @param truckMap : Map with key as truck applicant, permit and value as trucks
     * @return List of openTrucks
     */
    public static List<FoodTruck> getTrucksOpenList(Map<String, FoodTruck> truckMap){
        List<FoodTruck> openFoodTruckList = new ArrayList<>();
        int start;
        int end;
        FoodTruck foodTruck;
        for (String key:truckMap.keySet()){
            foodTruck = truckMap.get(key);
            start = Integer.parseInt(foodTruck.getStart24().split(":")[0]);
            end = Integer.parseInt(foodTruck.getEnd24().split(":")[0]);
            if(checkIfOpen(start,end)){
                openFoodTruckList.add(foodTruck);
            }
        }
        return openFoodTruckList;
    }

    /**
     * checks if truck is open or close at current date and time
     * @param openTime : startTime(24hrs) of Truck
     * @param closeTime : endTime(24hrs) of Truck
     * @return true or false
     */
    public static boolean checkIfOpen(int openTime, int closeTime){
        Calendar now = Calendar.getInstance();
        int currentHour = now.get(Calendar.HOUR_OF_DAY);
        if(currentHour>=openTime && currentHour<closeTime){
            return true;
        }
        return false;
    }
}
