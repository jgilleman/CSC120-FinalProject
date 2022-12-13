/**
 * ZONK Adventure Game: 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Player. The user can call all these methods. That's how they play the game.
*/
import java.util.HashMap;

/** Class Player */
public class Player {
  HashMap<String, Item> inventory = new HashMap<String, Item>();
  Train train;
  int location;
  int n_convos; // how many times you've talked to a passenger
  boolean ultimate_car = false;
  boolean win_zonk = false;

  /**
   * Constructor for player object
   * 
   * @param name       String holds players name
   * @param numPockets Int holds number of inventory spaces of player
   * @param train      Instance of object Train
   */
  public Player(String name, int numPockets, Train train) {
    this.train = train;
    location = 0;
  }

  /**
   * Method for loading stuff into the players pockets at the start of the game
   * 
   * @param name        string name of object to give player
   * @param description string describing the object
   */
  public void givePlayer(String name, String description) {
    Item i = new Item(name, description); // i is the ever-new item
    inventory.put(i.name, i); // store i in the hashmap with its name as the key
  }

  /**
   * Boolean: If holding item, then return true
   * 
   * @param name String name of object
   * @return boolean - T/F if player is holding object
   */
  public boolean holding(String name) {
    if (inventory.containsKey(name)) {
      // System.out.println("\nYou are in possession of the " + name + ".\n");
      return true;
    } else {
      System.out.println("\nYou are NOT in possession of the " + name + ".");
      return false;
    }
  }

  /**
   * Boolean Checks if player has the necessary number of conversations
   * 
   * @return boolean T/F if player has conversed enough
   */
  public boolean metPassengers() {
    if (n_convos >= train.cars[location].carPassengers.size()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method adds 1 to players location if conditions are met.
   * Each car is one space. player starts at location=0
   */
  public void nextCar() {
    if (location <= 1) {
      location++;
      if (location < 2) {
        System.out.println("\n" + "You are now in the next car.");
        lookAround();
      }
      if (location == 2) {
        ultimate_car = true;
        drop("KEYCARD");
        System.out.println("As you step through the door, you drop the keycard between cars. No going back now.");
        lookAround();
        System.out.println(
            "\n" + "You are immediately surprised by the conductor, who grabs your shoulders and shakes you...");
        talkTo("CONDUCTOR");
        System.out.println("You can no longer explore the train, for now you have a choice.\n" +
            "You must either `jump` from the train, or `submit` to whatever fate awaits the train and its passengers.\n");
      }
    }
  }

  /** Method subtracts one from players location */
  public void previousCar() {
    if (location == 0) {
      System.out.println("You are in the back-most car. You cannot go back.");
    }
    if (location > 0 && location < 2) {
      location--;
      System.out.println("\n" + "You have moved back a car.");
      lookAround();
    }
    if (location == 2) {
      System.out.println("It is time for the ultimatium.\n" +
          "You must either `jump` the train or `submit` to what's left of your lifetime spent on the train, before it ends in a furry crash.\n");
    }
    if (location == 3) {
      System.out.println("You have left the train, you cannot get back on");
    }
  }

  /** Method changes the location to 3 if allowed */
  public void exitTrain() {
    if (location < 2) {
      System.out.println("You cannot exit the train from this car");
    }
    if (location == 2) {
      location++;
      System.out.println("\n" + "You are now outside of the train. ");
      lookAround();
    } else {
      System.out.println("You're already outside of the train");
    }
  }

  /**
   * Method prints out dialogue of person player is trying to talk to or says if
   * they are not in the car
   * 
   * @param name String holds name of person to talk to
   */
  public void talkTo(String name) {
    if (train.cars[location].carPassengers.containsKey(name)) {
      Passenger p = train.cars[location].getPassenger(name);
      System.out.println("\n" + name + ": \"" + p.dialogue + "\"\n");
      this.n_convos++;
    } else {
      System.out.println(name + " is not in this car.\n");
    }
  }

  /** Method prints out description of location */
  public void lookAround() {
    if (location >= 0 && location <= 3) {
      if (location == 0) { // description of car 0
        System.out.println("\n" +
            "You are in the main cabin of the train.\n It smells of coffee and the seats are upholstered with a comfortable purple velvet.\n"
            +
            " There is a calm air about. Around you there are people seated: "
            + train.cars[location].carPassengers.keySet() +
            ". "
            +
            train.cars[location].printItems() + "\n");
      }
      if (location == 1) { // description of car 1
        System.out.println("\n" +
            "Your eyes have had to adjust since the previous car, but you see around you a shell of the first car.\n" +
            " Stands of hay litter the floor and the walls are coated in a green/brown petina from what looks like decades of water damage.\n"
            +
            " The car is essentially just a hollow tin box, and tremendous noise clatters from the train chugging along.\n"
            +
            " The floor vibrates your whole body, causing all your bones to shake about inside you.\n");
      }
      if (location == 2) { // description of car 2
        System.out.println("\n" +
            "You are in the locomotive--the engine room of the train.\n" +
            " It is extremely loud, and coal is glowing red and billowing smoke from out of the furnace.\n" +
            " There is a door to exit the train, and the conductor, in great distress, is standing at the window.\n" +
            " Through the window you see a great furry beast completely obstructing the tracks,\n" +
            " and strange wooden poles reaching from the ground up past where you can see.\n");
      }
      if (location == 3) { // description of outside
        System.out.println("\n" +
            "You are on the ground, which is cold and hard.\n" +
            " You look up and see that the wooden poles connect to a seat which you recognize as a giant chair.\n" +
            " You slowly realize that the chair is actually proportional to everything else in the room:\n" +
            " a giant clock, a giant table, a giant door, etc.\n You see a large cylindrical object with a button on it that says 'Laser'.\n"
            +
            " Looking to your right, the beast grows visibly restless, eyes snapping to the train and its inhabitants.\n"
            +
            " Whatever you do, you know you must do it quickly.\n");
      }
    } else {
      System.out.println("You are in the void. Exit game or try to fix your location.");
      System.out.println("Your location is: " + location + "\n");
    }
  }

  /**
   * Method adds object to inventory or returns an error statement
   * 
   * @param item_name String name of object player is trying to pick up
   */
  public void pickUp(String item_name) {
    if (train.cars[this.location].carItems.containsKey(item_name)) {
      Item i = train.cars[this.location].carItems.get(item_name);
      inventory.put(item_name, i); // place into player inventory
      train.cars[this.location].carItems.remove(item_name); // remove from carItems
      System.out.println("\n" + "You pocket the " + item_name + ".\n");
    } else {
      if (inventory.containsKey(item_name)) {
        System.out.println("That item is already in your pocket.\n");
      } else {
        System.out.println("Please enter valid item name.\n");
      }
    }
  }

  /**
   * Method removes item from inventory or prints error statement
   * 
   * @param item_name string name of item to be dropped
   */
  public void drop(String item_name) {
    if (this.inventory.containsKey(item_name)) {
      Item i = inventory.get(item_name); // RYAN: does this happen in the right order? or is it necessary?
      this.inventory.remove(item_name); // remove from inventory
      train.cars[this.location].carItems.put(item_name, i); // place back in car
      System.out.println("\n" + "You have dropped the " + item_name + ".\n");
    } else {
      System.out.println("Please enter valid item name.\n");
    }
  }

  /**
   * Method Prints description of object
   * 
   * @param name string with name of object to inspect
   */
  public void inspect(String name) {
    // if item/person exists in game
    if (train.cars[this.location].carItems.containsKey(name) || inventory.containsKey(name)
        || train.cars[this.location].carPassengers.containsKey(name)) {
      if (train.cars[this.location].carItems.containsKey(name)) { // exists: if item in current car
        Item i = train.cars[this.location].carItems.get(name);
        System.out.println("\n" + i.description + "\n");
      }
      if (inventory.containsKey(name)) { // exists: if item in inventory
        Item i = inventory.get(name);
        System.out.println("\n" + i.description + "\n");
      }
      if (train.cars[location].carPassengers.containsKey(name)) { // exists: if person in carPassengers
        Passenger p = train.cars[this.location].carPassengers.get(name);
        System.out.println("\n" + p.description + "\n");
      }
    } else { // doesn't exist
      System.out.println("There is no item/passenger called " + name + " here.\n");
    }
  }

  /** Method prints inventory */
  public void checkPockets() {
    System.out.println("\nYou find: " + this.inventory.keySet() + "\n");
  }

  /** Method prints out all possible commands at that moment */
  public void help() {
    System.out.println(
        "\nYou transcend your bodily form and connect to the great beings of the realm: Janna, Ryan, & Chelsea.\n" +
            "They bestow upon you the wisdom of available action.");
    System.out.println(train.cars[location].methods + "\n");
  }

  /**
   * Method performs different actions based on which object is being used
   * 
   * @param object string containing object to be used
   */
  public void use(String object) {
    if (object.equals("LASER")) {
      if (location == 3) {
        System.out.println(
            "Fearlessly, you grab the laser pointer and use all of your weight to press the large button on it's side.\n"
                + "A strong red beam shoots from one end, casting a bright red dot which you notice immediately captures the beast's attention.\n"
                + "Using the force of your sheer strength and adrenaline you slowly shift the front of the laser to move the dot's location away from the tracks.\n"
                + "The beast eagerly follows the dot, swatting and pouncing with it's massive dangerous paws.\n"
                + "You've done it! You've saved the train!\n\n"
                + "The passengers will forever remember you for your heroic and brave choice to leave the train.\n"
                + "YOU HAVE WON ZONK\n");
        win_zonk = true;
      } else {
        System.out.println("There is no laser around to use");
      }
    } else if (object.equals("KEYCARD") && inventory.containsKey("KEYCARD")) {
      if (holding("KEYCARD") && metPassengers()) {
        nextCar();
      } else if (!metPassengers()) {
        System.out.println("The party is still young! Make sure you've fully mingled with the passengers!\n");
      }
    } else {
      System.out.println("This object cannot be used.");
    }
  }
}
