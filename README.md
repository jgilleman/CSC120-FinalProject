# CSC120-FinalProject
This document functions as a working doc of issues we need to fix as well as reflection

Classes we need: Main Game, Passenger, Item, Player, Train, Car
Credit: https://www.codersarts.com/post/java-sample-project-1-text-adventure-game
Maybe helpful resources: https://www.youtube.com/watch?v=j99EeUjvLVQ

A list of some of the bugs and/additional features we've tackled
    <<done>>-fill out description of cars in player lookAround() method. car 1 is populated with passengers, is kinda nice looking, car two is empty like for storage and         kinda decrepid. Car three is   almost at the front of the train. Dont know what vibe it should be giving off. you should notice a door that leads outside in this car         though.
    <<fixed>>-lookAround should have a condition for if youre outside the cabin. maybe then location=3. might have to update next car also, idk yet.
    <<fixed>>-fix bug with lookAround() where the else statements always gets called in addition to the correct if statement
    <<thats fine its only for the compiler not the player>>-getPassenger doesnt work--prints out memory address
    <<fixed>>-can call nextCar from the locomotive car...made exittrain its own thing so it doesnt get dealt with in next car
    <<done>>-when picking somehting up remove from car's item list? checking if we need card to get previous cars--cuz if you drop it then it reverts location, that would         suck. then when drop, add to current car's list ALSO do we need to update look around to show relocated items??
    <<done>>-end condition. what you see as you are outside the cabin. cat and stuff.
    <<done>>-cant analyze anthing. install inspect()
    <<done>>-cant leave train
    ________-when a passenger isnt in the same car, it still says please enter valid passenger. do something about it or not?
    <<done>>-Drop item (into same car that ur in)
    <<done>>-user laser
    <<done>>-meet conductor
    <<done>>-prompt with the end choice (go from there)
    <<done>>-make help for when ultimate_car==true...reorg help? for just car2?
    <<done>>-java doc
    <<done>>check if this drop() and new pickUp() feature works (should remove from carItems and place in inventory and vice versa)
    <<fixed>>-Car class seems to have extra indentation
    <<done>>-The help list based on location doesn't seem to be working, and check pockets doesn't show up for some reason? 
    <<done>>-Add use (and more) to help
    <<done>>-when no space between command words, dropkeycard error thrown and stops the game. I think I should make an if for if the user input doesnt have a next in the         split
    <<done>>-Inspect always returns "please eneter object after [inspect]"
    <<done>>-right now u have to pocket the giant laser to use it. maybe we make a custom function for it and instead use the use() method for other items we put around the       train. they could either be fun easter eggs or we could make winning the game harder by adding more tasks. like maybe there's some obstacle in the second car

Stretch goals:
  -if u remove cat passenger dialogues update
  <<done>>general use function
  -more items/things to do
  -ASCII art train drawing in intro

Feedback from people who have tested the game:
  <<done>>-need to tell player that help is location based
  <<fixed>>-crash game by inspecting nothing
  <<done>>-use keycard should do nextCar
  <<fixed>>-use keycard lets u into the next car even if u havent met all the passengers

# Reflection
  Our team started by coming up with a plot to what we knew was going to be a text-based adventure game. After deciding on our current plot and world-building bits, we divided the world, it's inhabitants, and its items into different classes. We decided we needed a class for the Game itself, the Player, the Train, the Cars, the Passengers, and the Items. We thought it best that Passenger be a class because we knew we would need to create many instances of a passenger, each with a name, dialogue, and description. A similar logic was followed for Item and Car. At the same time, we were mapping out the desired relationship between these objects. It made sense to us for the Game to "have" a Train, which was "composed of" three Cars where each Car "had" Passengers and Items. The Player, then, sort of existed parallel to these things, although the Player had to "belong to" to Game so that the actual player of ZONK could control the Player through Game. In addition, the fact that the Player has "pockets" (inventory spaces), means that they can hold items, so that is another "has" (aggregation) relationship.
  After deciding on our architecture, which had a few small adjustments as we went (of which we can't really remember the exact details), and making basic stubs for all our components, we set to work filling out the methods of Player, starting with talkTo(), lookAround(), pickUp(), and checkPockets(). Only after we had crafted most of the most crucial methods of the game, did we start to work on creating specific passengers, a train, cars, and items in the main method of the Game class itself. Scanner was then implemented to allow the player of ZONK to perform the commands we had been testing by hardcoding prior. At this point most of the work left to do was just a long series of adding small but crucial details: error messages and conditions, building resilency, and filling out the end condition of the game. We gave it to our friends to test, made improvements, and that's how we got here!
  If we were to rebuild this game, I believe we would stick to the same architecture, although the Game class could be tidied up with a setup() function, maybe coming from the Train class. We tried using switch cases to make Game neater, but concluded that it wouldn't work for our particular application since they would have to be checking that the scanner contains() some string (which to our knowledge isn't really within the capabilities of a switch). 
  Another architectural option is to have more of a linear approach where Player both contains all the workings of setting up the game, and controlling the player at the same time (that's kind of a lot for one class to do though). In that case, the Player could "have" a train, which "has" cars. The game could also directly "have" passengers and items, but we feel it's more convenient for these objects to be location based, since that's how the game functions anyways. Passengers in our game don't move between cars, but even if they did, it's always important to keep track of where they are located since it relates to the player's ability to interact with them. Although, if one were going down that route, they could work around that by making location an attribute of passenger, so passengers "have" cars instead of cars "having" passengers. As we've learned in this course, there are many ways to get to the same goal in Java and OOP in general.