import com.redfin.dto.FoodTruck;
import com.redfin.service.FoodTruckService;

import java.util.*;

/*
FoodTruckFinder contains application starter method that returns
list of food trucks open at time when application invoked
 */
public class FoodTruckFinder {
    public static void main(String[] args) {
        try {
            //Invoking food service to get foodTrucks
            Map<String, FoodTruck> foodTrucks = FoodTruckService.getFoodTrucks();
            //getTrucksOpenList return all open FoodTrucks
            List<FoodTruck> openFoodTruckList = Util.getTrucksOpenList(foodTrucks);
            int currentIndex;
            currentIndex = Util.printTen(openFoodTruckList,0);
            Scanner sc = new Scanner(System.in);
            /*Logic to return only 10 products everytime user press Enter
            when all food trucks are returned program exits
             */
            while (currentIndex < openFoodTruckList.size() && sc.nextLine().equals("")) {
                currentIndex = Util.printTen(openFoodTruckList, currentIndex);
            }
        }
        //catch Exceptions if occured any
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
