package study.coco;
import java.util.ArrayList;



public class Game {

    //main method
    public static void main(String[] args) {
        System.out.println("description of the house in general, ladder, doorstep.\n " +
                "Focus on remnants of the aristocratic past of the house, and the present impoverment.\n " +
                "Intro about the inhabitants and the life incidents that brought her to lend here.\n " +
                "Foster a feeling of mystery and intelligent people of subtle spiritual organisation.\n");

        Room entranceHall = new Room("Entrance Hall", "add description for the entrance hall here.");
        Room corridor = new Room ("Corridor", "add description for the corridor here.");
        Room guestRoom = new Room ("Guest Room", "add description for the guest room here.");
        Room library = new Room ("Library", "add description for the library here.");

        entranceHall.connectRooms(corridor,null,null,null);
        corridor.connectRooms(null,guestRoom,null,null);
        guestRoom.connectRooms(null, null, corridor, library);
        library.connectRooms(guestRoom,null,null,null);

    }
}
