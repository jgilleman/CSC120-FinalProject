/** ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Car manages and keeps track of passengers in each car with a hashmap called carPassengers.
*/
import java.util.HashMap;
import java.util.*;

/** Class Car */
public class Car {
  //each car has it's own hashmap which stores all passengers in the car. key=name, value=passenger object
  HashMap<String, Passenger> carPassengers = new HashMap<String, Passenger>();
  HashMap<String, Item> carItems = new HashMap<String, Item>();
  ArrayList<String> methods = new ArrayList<String>();
  public boolean door_open = false;
  public String car_items_string;
  
  /** Constructor makes an instance of a Car */
  public Car(){}
  /** Method getter for accessing information about any passenger by name
  * @param name String holds name of passenger  
  * @return Object Passenger
  */
  public Passenger getPassenger(String name) {
    Passenger p = carPassengers.get(name);
    return p;
  }
  /** Method adds passengers to the hashmap
  * @param name String of name of passenger
  * @param description String that describes the person
  * @param dialogue String of dialogue for passenger
  */
  public void addPassenger(String name, String description, String dialogue) {
    Passenger p = new Passenger(name, description, dialogue); //make a new passenger and temporarily label it passenger "p"
    carPassengers.put(p.name, p); //add the new passenger to the hashmap. from here-on-out it will be labelled by its name, not p, since the hashmap key=name
  }
  /** Method adds item to specified car
  * @param name String of item name
  * @param description String describing item
  */
  public void addItem(String name, String description){
    Item i = new Item(name, description);
    carItems.put(i.name, i);
  }
  /** Method prints the items in the car
  * @return car_items_string String of items located in that car
  */
  public String printItems() {
    if (carItems.size() == 0) {
      //System.out.println("No items in this car.");
      return "No items in this car.";
    }
    if (carItems.size() == 1) {
      car_items_string = "The item in this car is: " + carItems.keySet();
      return car_items_string;
    } else { // (carItems.size() > 1) {
      car_items_string = "The items in this car are: " + carItems.keySet();
      return car_items_string;
    }
  }
}