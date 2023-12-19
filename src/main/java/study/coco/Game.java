package study.coco;
import java.util.ArrayList;
import java.util.Scanner;



public class Game {

    //main method
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("The game is set in 1930s Leningrad, within the Soviet Union. \n " +
                "Your mission, as a law-abiding investigator, is to conduct a ransacking in the former palace of Count Sheremetev, now repurposed into a communal apartment building. \n " +
                "During the search you will have to decide on the suspicious objects encounter, determining whether there is enough evidence to arrest the person and send them into prison for committing a crime against the state.\n" +
                "In these years, the country is on the path to an ideal society where art serves the masses, and dissent is prosecuted.\n " +
                "You are a guardian of order, and your work is aimed at maintaining public safety and identifying those who might disrupt the harmony of the new world.\n " +
                "Considerable power rests in your arms; every day you make decisions that shape human destinies, a responsibility that is highly rewarding and praised by the people above you.\n" +
                "In your position you are required to follow the state’s general course: \n" +
                "Be friends and help your comrade, report enemies and wrongdoers! Go ahead and be conciderate.");

        System.out.println("type enter to enter the building");


        Room entranceHall = new Room("Entrance Hall", "add description for the entrance hall here." + "examine the room");
        Room corridor = new Room("Corridor", "add description for the corridor here." + "examine the room");
        Room guestRoom = new Room("Guest Room", "add description for the guest room here." + "examine the room");
        Room library = new Room("Library", "add description for the library here." + "examine the room");
        Room doorstep = new Room("Doorstep", "Description of the house in general, ladder, doorstep.\n " +
                "Focus on remnants of the aristocratic past of the house, and the present impoverment.\n " +
                "Intro about the inhabitants and the life incidents that brought her to lend here.\n " +
                "Foster a feeling of mystery and intelligent people of subtle spiritual organisation.\n " +
                "hint: after entering every room you have to examine it. type examine");
        Room street = new Room("Street", "........");

        entranceHall.connectRooms(corridor, null, null, null);
        corridor.connectRooms(null, guestRoom, null, null);
        guestRoom.connectRooms(null, null, corridor, library);
        library.connectRooms(guestRoom, null, null, null);
        doorstep.connectRooms(entranceHall, null, null, null);
        street.connectRooms(doorstep, null, null, null);

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

            if (input.equals("examine")) {
                System.out.print("You have found ");
                player.nextRoom.showLocationItems();
                if (!player.currentRoom.allItems.isEmpty()) {
                    System.out.println("Press enter to think about your sanity... ");
                    String leerSpace = scanner.nextLine().toLowerCase();
                    if(player.inventory.isEmpty() & player.lastAction == null){
                        System.out.println(Thoughts.thought1);
                    } else if (player.inventory.isEmpty() & player.lastAction.equals( "take")) {
                        System.out.println(Thoughts.thought1);
                    } else if (player.inventory.isEmpty() && player.lastAction.equals("leave")) {
                        System.out.println(Thoughts.thought5);
                    } else if (player.inventory.isEmpty() && player.lastAction.equals("drop")) {
                        System.out.println(Thoughts.thought5);
                    } else if (player.inventory.size() == 1) {
                        if (player.lastAction.equals("leave")){
                            System.out.println(Thoughts.thought5);
                        } else if (player.lastAction.equals("take")){
                            System.out.println(Thoughts.thought2);
                        }
                    } else if (player.inventory.size() == 2) {
                        System.out.println(Thoughts.thought3);
                    } else if (player.inventory.size() == 3) {
                        System.out.println(Thoughts.thought4);
                    }
                } else {
                    System.out.println("Move forward. Choose the next direction.");

                }
                continue;

            }
            if (input.startsWith("take ")) {
                String itemName = input.substring(5);
                player.take(itemName);
                continue;
            }
            if (input.startsWith("leave ")){
                String itemName = input.substring(6);
                player.leave(itemName);
                continue;
            }
            if (input.startsWith("drop ")) {
                String itemNameToDrop = input.substring(5);
                player.lastAction = "drop";
                for (Artefact item : player.inventory) {
                    if (item.getName().equalsIgnoreCase(itemNameToDrop)) {
                        player.inventory.remove(item);
                        System.out.print("You have dropped a " + item.getName());
                        System.out.println(" Move forward.");
                        break;
                    }
                }
                continue;
            }

                if (input.startsWith("inventory")) {
                    for (Artefact item : player.inventory) {
                        System.out.print(item.getName());
                    }
                    continue;
                }

                player.go(input);
            }
        }
    }

