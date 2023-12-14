package study.coco;
import java.util.ArrayList;
import java.util.Scanner;



public class Game {

    //main method
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println( "The game is set in 1930s Leningrad, within the Soviet Union. \n " +
                "Your mission, as a law-abiding investigator, is to conduct a ransacking in the former palace of Count Sheremetev, now repurposed into a communal apartment building. \n " +
                "During the search you will have to decide on the suspicious objects encounter, determining whether there is enough evidence to arrest the person and send them into prison for committing a crime against the state.\n"+
                "In these years, the country is on the path to an ideal society where art serves the masses, and dissent is prosecuted.\n " +
                "You are a guardian of order, and your work is aimed at maintaining public safety and identifying those who might disrupt the harmony of the new world.\n " +
                "Considerable power rests in your arms; every day you make decisions that shape human destinies, a responsibility that is highly rewarding and praised by the people above you.\n" +
                "In your position you are required to follow the state’s general course: \n" +
                "Be friends and help your comrade, report enemies and wrongdoers!." +
                "type enter to enter the building");


        Room entranceHall = new Room("Entrance Hall", "add description for the entrance hall here.");
        Room corridor = new Room ("Corridor", "add description for the corridor here.");
        Room guestRoom = new Room ("Guest Room", "add description for the guest room here.");
        Room library = new Room ("Library", "add description for the library here.");
        Room doorstep = new Room("Doorstep", "Description of the house in general, ladder, doorstep.\n " +
                "Focus on remnants of the aristocratic past of the house, and the present impoverment.\n " +
                "Intro about the inhabitants and the life incidents that brought her to lend here.\n " +
                "Foster a feeling of mystery and intelligent people of subtle spiritual organisation.\n" +
                "You are at the street. Go to the north to enter the building.");
        Room street = new Room ("Street", "........");

        entranceHall.connectRooms(corridor,null,null,null);
        corridor.connectRooms(null,guestRoom,null,null);
        guestRoom.connectRooms(null, null, corridor, library);
        library.connectRooms(guestRoom,null,null,null);
        doorstep.connectRooms(entranceHall,null,null,null);
        street.connectRooms(doorstep,null,null,null);

        Artefact coat = new Artefact("coat");
        Artefact book = new Artefact("book");
        Artefact poem = new Artefact("poem");
        Artefact note = new Artefact("afterdeath note");

        entranceHall.allItems.add(coat);
        corridor.allItems.add(book);
        guestRoom.allItems.add(note);
        library.allItems.add(poem);


        ArrayList<Artefact> foundItems = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(street);


        while (true) {
            String input = scanner.nextLine();

            if(input.equals("examine")) {
                System.out.println("you have found: ");
                player.nextRoom.showLocationItems();
                if (!player.currentRoom.allItems.isEmpty()) {
                    System.out.println("Press enter to think about your sanity... ");
                    String leerSpace = scanner.nextLine().toLowerCase();
                    System.out.println(Thoughts.thought1); // TODO: add gradation of thoughts according to the amount of picked items
                } else {
                    System.out.println("move forward.");
                }
                continue;
            }if(input.startsWith("take ")){
                String itemName = input.substring(5);
                player.take(itemName);
                continue;
//            }if (input.startsWith("drop ")){
//                String itemName = input.substring(5);
//                player.inventory.remove(itemName);
//                continue;
            }

        player.go(input);
        }


    }
}
