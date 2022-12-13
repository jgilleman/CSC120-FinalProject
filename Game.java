/**
 * ZONK Adventure Game: 
 *
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Game runs the main game
*/
import java.util.Scanner;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Class Game runs the game */
public class Game {

  /**
   * Method Main
   * 
   * @param String[] args
   */
  public static void main(String[] args) {
    Train train = new Train();
    Player player = new Player("LAIKA", 3, train);

    // making help function
    for (int i = 0; i < train.cars.length - 1; i++) {
      train.cars[i].methods.add("look around");
      train.cars[i].methods.add("inspect _");
      train.cars[i].methods.add("talk to _");
      train.cars[i].methods.add("pick up _");
      train.cars[i].methods.add("drop _");
      train.cars[i].methods.add("next car");
      train.cars[i].methods.add("check pockets");
      train.cars[i].methods.add("exit game");
      train.cars[i].methods.add("use _");
    } // adds all methods to all cars
    train.cars[1].methods.add("previous car");
    // **WARNING** if u add a new method to car0 or car1 list you must increment
    // this num by 1!!!
    train.cars[2].methods.add("previous car");
    train.cars[2].methods.remove(5); // remove next car method from car2
    train.cars[2].methods.add("exit train");
    train.cars[2].methods.add("submit");
    train.cars[3].methods.add("previous car");
    train.cars[3].methods.add("press button");

    boolean still_playing = true;
    Scanner userInput = new Scanner(System.in);
    String user_response = "";

    // populate cars with passengers
    train.cars[0].addPassenger("LINDA",
        "Linda has long flowy red hair and a few freckles, and is looking absently out the window.",
        "Hello young man; you look confused. Haha, aren't we all.\n I haven't seen you before, you must be from several cars down.\n"
            +
            "Why don't you go talk to my son Anton. He's about your age.");
    train.cars[0].addPassenger("WILLIAM", "William has courdouroy pants, a cotton t-shirt, and is smoking a pipe.",
        "My great grandmother told me of a beast that lurks these tracks. You don't believe in such things though, do you?\n"
            +
            "LAIKA: Your great grandmother was on this train?\n" +
            "WILLIAM: Well of course she was silly. We've all been on this train since as long as we can remember.\n" +
            "Everyone knows that the day this train stops is the day we all stop!");
    train.cars[0].addPassenger("ANTON", "Anton wears a cozy hoodie with headphones and is reading a book.",
        "Hey man, I know you want that keycard. Whatever you're up to, I get half, okay?");
    train.cars[2].addPassenger("CONDUCTOR",
        "You noticed the conductor is a frog, and a very stylish one at that.\n" +
            " He stands about 5 ft 10 in and wears warm colored overalls with a red cravat and green courdoroy jacket",
        "WE'RE ALL GOING TO DIE!!! THERE'S NO WAY TO DIVERT OUR PATH--THE HUMONGOUS BEAST IS COMPLETELY OBSTRUCTING\n" +
            "THE TRACKS AND I SWEAR I JUST SAW IT LICK ITS LIPS. I can't do anything and everyone is going to perish.\n"
            +
            "Unless someone jumps the train and baits it away...but nobody would do that--that's absurd.");
    // load items into the cars
    train.cars[0].addItem("KEYCARD", "A thin plastic card. The only parts you can read are \"Lionel...130 Piece\".");
    train.cars[3].addItem("LASER", "A big cylindrical item. There is a button on the side of it.");
    // load the player in with a pair of glasses
    player.givePlayer("GLASSES", "Large round spectacles. Carved on the inside are the letters \"LAIKA\".\n" +
        "You don't remember much about who you are or how you got here, but your fondness of these glasses is evident from their wear.");
    // Game Opening Text
    System.out
        .println("---------------------------------------------------------------------------------------------------");
    System.out
        .println("|                                 <<<<o>  WELCOME TO ZONK  <o>>>>                                 |");
    System.out
        .println("---------------------------------------------------------------------------------------------------");
    System.out.println(
        "ZONK INFO: help command is location based. Referencing it multiple times throughout the game will be helpful.\n");
    System.out.println(
        "All is dark. The ground rocks beneath you.\n" +
            " You open your eyes and awake to an old fashioned train full of strange looking passengers.\n" +
            " You remain unaware of where you are or how you got there.\n" +
            " In your haze, you see a frog in a conductor's outfit scan a keycard up to a door.\n" +
            " As he exits the car, the keycard slips from his pocket and falls under a seat.\n" +
            " \"Hmm maybe I should talk to some of these passengers and explore around a bit.\n" +
            " I really need to get my bearings\", you think to yourself.\n");
    System.out.println(">>TYPE HELP FOR OPTIONS OR ENTER COMMANDS BELOW: ");

    // Main Game Loop
    while (still_playing == true) {
      user_response = userInput.nextLine().toUpperCase();

      String words[] = user_response.split(" ");
      List<String> userResponseSplit = Arrays.asList(words);

      if (user_response.contains("EXIT GAME")
          || user_response.contains("END GAME")
          || user_response.contains("QUIT")
          || user_response.contains("LOOK AROUND")
          || user_response.contains("EXPLORE")
          || user_response.contains("TALK TO")
          || user_response.contains("PICK UP")
          || user_response.contains("DROP")
          || user_response.contains("INSPECT")
          || user_response.contains("NEXTCAR")
          || user_response.contains("NEXT CAR")
          || user_response.contains("FORWARD")
          || user_response.contains("OPEN DOOR")
          || user_response.contains("PREVIOUSCAR")
          || user_response.contains("PREVIOUS CAR")
          || user_response.contains("BACKWARD")
          || user_response.contains("CHECK POCKETS")
          || user_response.contains("EXIT TRAIN")
          || user_response.contains("LEAVE TRAIN")
          || user_response.contains("JUMP TRAIN")
          || user_response.contains("JUMP")
          || user_response.contains("HELP")
          || user_response.contains("USE")
          || user_response.contains("PRESS BUTTON")
          || user_response.contains("SUBMIT")) {
        if (user_response.contains("EXIT GAME") || user_response.contains("END GAME")
            || user_response.contains("QUIT")) {
          System.out.println("You've ended your game of ZONK, I hope you travel with us again!");
          still_playing = false;
        }
        if (user_response.contains("LOOK AROUND") || user_response.contains("EXPLORE")) {
          player.lookAround();
        }
        if (user_response.contains("TALK TO")) {
          if (userResponseSplit.size() != 2) {
            player.talkTo(user_response.split(" ")[2]); // name = break response into words, take third
          } else {
            System.out.println("Please enter passenger after [talk to].\n");
          }
        }
        if (user_response.contains("PICK UP")) {
          if (userResponseSplit.size() != 2) {
            player.pickUp(user_response.split(" ")[2]);
          } else {
            System.out.println("Please enter object after [pick up].\n");
          }
        }
        if (user_response.contains("DROP")) {
          if (userResponseSplit.size() == 2) {
            String name = user_response.split(" ")[1];
            player.drop(name);
          } else {
            System.out.println("Please enter object after [drop]\n");
          }
        }
        if (user_response.contains("INSPECT")) {
          if (userResponseSplit.size() == 2) {
            String name = user_response.split(" ")[1];
            player.inspect(name);
          } else {
            System.out.println("Please enter object after [inspect]\n");
          }
        }
        if (user_response.contains("NEXTCAR") || user_response.contains("NEXT CAR") || user_response.contains("FORWARD")
            || user_response.contains("OPEN DOOR")) {
          if (player.holding("KEYCARD") && player.metPassengers()) {
            player.nextCar();
          }
          if (!player.metPassengers()) {
            System.out.println(
                "The party is still young! Make sure you've fully mingled with the passengers!\n");
          }
        }
        if (user_response.contains("PREVIOUSCAR") || user_response.contains("PREVIOUS CAR")
            || user_response.contains("BACKWARD")) {
          if (player.holding("KEYCARD")) {
            player.previousCar();
          } else {
            System.out.println("You don't have the credentials to move to that car.\n");
          }
        }
        if (user_response.contains("CHECK POCKETS")) {
          player.checkPockets();
        }
        if (user_response.contains("EXIT TRAIN") || user_response.contains("LEAVE TRAIN")
            || user_response.contains("JUMP TRAIN")
            || user_response.contains("JUMP")) {
          player.exitTrain();
        }
        if (user_response.contains("HELP")) {
          player.help();
        }
        if (user_response.contains("USE")) {
          if (userResponseSplit.size() == 2) {
            String obj = user_response.split(" ")[1];
            if (player.inventory.containsKey(obj)) {
              player.use(obj);
            } else {
              System.out.println("You do not have object " + obj + "\n");
            }
          } else {
            System.out.println("Please enter object after [use]\n");
          }
        }
        if (user_response.contains("PRESS BUTTON")) {
          if (player.location == 3) {
            player.pickUp("LASER");
            player.use("LASER");
          } else {
            System.out.println("You cannot use that command here.\n");
          }
        }
        if (user_response.contains("SUBMIT")) {
          if (player.location == 2) {
            System.out.println(
                "In the face of CATrastrophy you let fear conquer your will to action and you remain onboard the train.\n"
                    +
                    "A few moments pass and the beast on the tracks seems to grow restless, its tail swishing back and forth.\n"
                    +
                    "Suddenly, its eyes lock to the train, and in an instance its monstrous body is bounding towards you.\n"
                    +
                    "It flashes its fangs as it swats at the car, sending you flying against the walls.\n" +
                    "Reality seems to glitch out. All at once the world is black and you feel your memories fade away,\n"
                    +
                    "your pockets empty, and a haze fades over you.\n\n" +
                    "**GAME OVER**");
            still_playing = false;
          } else {
            System.out.println("You cannot use that command here.\n");
          }
        }
      } else {
        System.out.println("I didn't recognize what you just said there...\n");
      }
      if (player.win_zonk) { // if player presses button and saves train this triggers
        still_playing = false;
      }
    } // end of the while(stillplaying==true) loop
    // Close out scanner
    userInput.close();
  }
}