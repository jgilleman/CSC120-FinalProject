/**
 * ZONK Adventure Game:
 * 
 * @Author Janna Gilleman, Ryan Emerson, Chelsea Fowler
 * @Date Fall 22
 * Class Passenger simply creates passengers which each have a name,
 * description, and one peice of dialogue
 */
public class Passenger {
  String name;
  String description;
  String dialogue;

  /**
   * Constructor makes an instance of a Passenger
   * 
   * @param name        A string; stores the name of the passenger
   * @param description A string; stores description of passenger
   * @param dialogue    A string; stores the dialogue of passenger
   */
  public Passenger(String name, String description, String dialogue) {
    this.name = name;
    this.description = description;
    this.dialogue = dialogue;
  }
}
