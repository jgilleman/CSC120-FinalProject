/*ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Player. The user can call all these methods. That's how they play the game.
*/
import java.util.HashMap;
import java.util.*;

public class Player {
  HashMap<String, Item> inventory = new HashMap<String, Item>();
  ArrayList<String> methods = new ArrayList<String>();
  Train train;
  int location;
  int k; // how many times you've talked to a passenger
  
  public Player(String name, int numPockets, Train train) {
    this.train = train;
    location = 0;
    System.out.println(
        "A new player has been built. Their name is " + name + ". They have " + numPockets + "inventory spaces.");
  }

  // for loading stuff into the players pockets at the start of the game
  public void givePlayer(String name, String description) {
    Item i = new Item(name, description); // i is the ever-new item
    inventory.put(i.name, i); // store i in the hashmap with its name as the key
  }

  // Boolean: If holding item, then return true
  public boolean holding(String name) {
    if (inventory.containsKey(name)) {
      System.out.println("You are in possession of the " + name + ".");
      return true;
    } else {
      System.out.println("You are NOT in possession of the " + name + ".");
      return false;
    }
  }

  public boolean metPassengers() {
    if (k >= train.cars[location].carPassengers.size()) {
      return true;
    } else {
      return false;
    }
  }

  // For simplicity, I'm making it so every car is one space long. Also,
  // location=0 is the furthest back car (where the player starts). The front-most
  // car is car 2.
  public void nextCar() {
    if (location <= 1) {
      location++;
      if (location < 2) {
        System.out.println("You are now in the next car");
      }
      if (location == 2) {
        System.out.println("You are immediately surprised by the conductor, who grabs your shoulders and shakes you...");
        talkTo("CONDUCTOR");
      }
    } else {
      System.out.println("You are in the front-most car. You cannot move forward within the train.");
    }
  }

  public void previousCar() {
    if (location > 0) {
      location--;
      System.out.println("You have moved back a car.");
    } else {
      System.out.println("You are in the furthest back car. You cannot move backwards.");
    }
  }

  public void exitTrain() { 
    location++;
    System.out.println("You are now outside of the train");
  }

  public void talkTo(String name) {
    if (train.cars[location].carPassengers.containsKey(name)) {
      Passenger p = train.cars[location].getPassenger(name);
      System.out.println(name + ": \"" + p.dialogue + "\"\n");
      this.k++;
    } else {
      System.out.println(name + " is not in this car.\n");
    }
  }

  public void lookAround() {
    if (location >= 0 && location <= 3) {
      if (location == 0) { //description of car 0
        System.out.println(
            "You are in the main cabin of the train. The seats are upholstered with a comfortable velvet purple fabric, and there is a calm air about. "
                + "Around you there are people seated:" + train.cars[location].carPassengers.keySet() + ". "
                + "There is a key card on the ground where the conductor dropped it, and in your lap there is a pair of glasses.");
      }
      if (location == 1) { //description of car 1
        System.out.println(
            "Your eyes have had to adjust since the previous car, and you see around you a shell of the first car--just a hollow tin box, tremendous noise from the train's chugging along, the ground vibrating your whole body, causing all your bones to rattle about inside you.");
      }
      if (location == 2) { //description of car 2
        System.out.println(
            "You are standing in the locomotive--the engine room of the train. It is extremely loud, and coal is glowing red and billowing smoke from out of the furnace. There is a door to exit the train, and the conductor, in great distress, is standing at the window. Through the window you see a great furry beast completely obstructing the tracks, and strange wooden poles reaching from the ground up past where you can see.");
      }
      if (location == 3) { //description of outside
        System.out.println(
            "You are on the ground, which is cold and hard. You look up and see that the wooden poles connect to a seat which you recognize as a giant chair. You slowly realize that the chair is actually proportional to everything else in the room: a giant clock, a giant table, a giant door, etc. You see a large cylindrical object with a button on it.");
      }
    } else {
      System.out.println("You are in the void. Restart game or try to fix your location.");
      System.out.println("Your location is: " + location);
    }
  }

  public void pickUp(String itemName) {
    if (train.cars[this.location].carItems.containsKey(itemName)) {
      Item i = train.cars[this.location].carItems.get(itemName);
      inventory.put(itemName, i);
      System.out.println("You pocket the " + itemName + ".");
    } else {
      System.out.println("Item not found.");
    }
  }

  public void checkPockets() {
    System.out.println(this.inventory.keySet());
  }

  public void help() {
    System.out.println(methods);
  }
}
