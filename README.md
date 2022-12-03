# CSC120-FinalProject
//Right now I'm using this doc as notes and reflection for us. Feel free to put whatever u want here.

Classes we need: Main Game, Passenger, Item, Player, Train, Car

Unofficial interfaces:
    Player Interface: 
        use(Object item) //use means different things for diff objects. still have to figure out how to code this
        move(String direction, int numSpaces) //move forward or backward and add or subtract given number of spaces
        talkTo(Passenger name) //intiate conversation w passenger
        lookAround() //based on location value. tells compiler which cart player is in and describes surroundings
        inspect(Object item) //tells you about item (overloaded)
        inspect(Passenger name) //describes the person (overloaded)

Credit: https://www.codersarts.com/post/java-sample-project-1-text-adventure-game

Maybe helpful resources: https://www.youtube.com/watch?v=j99EeUjvLVQ




Stuff to do:

    <<done>>- fill out description of cars in player lookAround() method. car 1 is populated with passengers, is kinda nice looking, car two is empty like for storage and kinda decrepid. Car three is   almost at the front of the train. Dont know what vibe it should be giving off. you should notice a door that leads outside in this car though.
    <<done>>lookAround should have a condition for if youre outside the cabin. maybe then location=3. might have to update next car also, idk yet.
    <<fixed>>-fix bug with lookAround() where the else statements always gets called in addition to the correct if statement

    <<done>>getPassenger doesnt work--prints out memory address<- its fine this is just for a separate command, not for game play>
    <<fixed>>-can call nextCar from the locomotive car...made exittrain its own thing so it doesnt get dealt with in next car
    <<done>>end condition. what you see as you are outside the cabin. cat and stuff.
    <<done>>-cant analyze anthing. install inspect()
    <<done>> leave train
    -when a passenger isnt in the same ar, it still says please enter valid passenger. do something about it or not?
    <<done>>-Drop item (into same car that ur in)
    -user laser
    <<done>>meet conductor
    -prompt with the end choice (go from there)
    -java doc
    -update command and help list

    Stretch goals:
    -if u remove cat passener dialogues update
    -general use function
    -more items/things to do
    -ASCII art train drawing in intro
    -breaking and jumping out the window ends game