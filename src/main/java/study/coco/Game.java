package study.coco;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Attribute.ITALIC;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    //main method
    public static void main(String[] args) {
        Game game = new Game();

        //introduction
        System.out.println("""
                The game is set in 1930s Leningrad, within the Soviet Union.
                Your mission, as a law-abiding investigator, is to conduct a ransacking in the former palace of Count Sheremetev, now repurposed into a communal apartment building.
                During the search you will have to decide on the suspicious objects encounter, determining whether there is enough evidence to arrest the person and send them into
                prison for committing a crime against the state. In these years, the country is on the path to an ideal society where art serves the masses, and dissent is prosecuted.
                You are a guardian of order, and your work is aimed at maintaining public safety and identifying those who might disrupt the harmony of the new world. Considerable power
                rests in your arms; every day you make decisions that shape human destinies, a responsibility that is highly rewarding and praised by the people above you.
                In your position you are required to follow the state’s general course: """);
        System.out.println(Ansi.ansi().a(ITALIC).a("Be friends and help your comrade, report enemies and wrongdoers! ").reset());
        System.out.println("Go ahead and be considerable.");

        System.out.println("type " + Ansi.ansi().a(ITALIC).a("help ").reset() + "to take a look on the commands you can use.");

        System.out.println("type " + Ansi.ansi().a(ITALIC).a("enter ").reset() + "to enter the building.");

        //locations
        Room entranceHall = new Room("Entrance Hall", """
                A coat rack, umbrella stand, tall mirror – a typical setting for the entrance hall in the apartment of St. Petersburg intellectuals. The standout piece is a decorative 
                chest in the corner; its dark, wooden finish beautifully contrasts with the dusty green walls, the windows deftly absorb the last rays of the setting sun, leaving 
                a lingering haze in the room.
                """ + Ansi.ansi().a(ITALIC).a("examine ").reset() + "the room");
        Room corridor = new Room("Corridor", """
                The corridor, once a busy servant's passage, extends through the remnants of the grand house. Abandoned suitcases and overlooked items clutter the space, narrating stories 
                of political emigration and sudden painful goodbyes. Perhaps one of those suitcases was given to A. Akhmatova by a friend, hoping she would join him in the pursuit of a safer 
                life abroad. However, she made the decision to stay.\n""" + Ansi.ansi().a(ITALIC).a("examine ").reset() + "the room");
        Room guestRoom = new Room("Guest Room", """
                In the guest room, you find a writing desk covered in papers, a wooden closet full of books and artworks, and a velvet sofa. The stove is still warm after burning the photos 
                and documents the night before. The pile of papers on the desk draws your attention...\n""" + Ansi.ansi().a(ITALIC).a("examine ").reset() + "the room");
        Room annaRoom = new Room("the room of Anna Akhmatova", """
                In her simple and old room, there's a big bed with a red cover and an embroidered pillow. There's also a chair with no leg, but it stands steady with books underneath.\n""" +
                Ansi.ansi().a(ITALIC).a("examine ").reset() + "the room");
        Room doorstep = new Room("Doorstep", """
                You approach a dilapidated aristocratic house that lines the embankment of the Fontanka River. Stepping through the ornate iron fence with wide gates, you find 
                yourself in the depths of the courtyard. Upon entering the house, an admirable interior unfolds before you: the ceilings soar towards the heavens, but the paint 
                peels from the walls. A staircase, once used for welcoming guests in elaborate grand dresses, now stands decrepit. Taking the stairs leads you to a wide doorway 
                of a southwest wing, and after a while, you find yourself in front of the door of the repurposed communal 8-room apartment.
                Amidst the worn-out elegance, the remnants of a bygone era intermingle with the fear of a new reality. On the doorstep, you notice a small window from the corridor, 
                and a pair of scared yet curious children's eyes glancing at you. Rare is the parent who does not ask their child to check who is knocking, as a presequitor could appear 
                at any moment, accusing you or your relatives of a crime you had no hand in. You knock on the door, and after a few moments, it swings open. There is a chain on the door, 
                a symbol of resilience against uncertain times.
                A prominent Russian poet Anna Akhmatova stays on the doorstep. The Fountain House provided her with a place of refuge during this tumultuous period.\n""" +
                Ansi.ansi().a(ITALIC).a("Choose the direction to move forward. ").reset());
        Room street = new Room("Street", "........");

        //connections
        entranceHall.connectRooms(corridor, null, null, null);
        corridor.connectRooms(null, guestRoom, null, entranceHall);
        guestRoom.connectRooms(null, null, corridor, annaRoom);
        annaRoom.connectRooms(guestRoom, null, null, null);
        doorstep.connectRooms(entranceHall, null, null, null);
        street.connectRooms(doorstep, null, null, null);

        //artefacts and descriptions
        Artefact coat = new Artefact("coat", """
                The coat stands out with precise tailoring— sharp shoulders and a trim waist, unlike the usual mass-produced outerwear in the USSR. Its origin hints at ties with the West, 
                a potential concern for the state. The key question: Does this single piece of evidence warrant further action?""");
        Artefact book = new Artefact("book", """
                Lost among dusty suitcases, a worn book titled "The Theory of Relativity" lies forgotten. The book questions the anti-"cosmopolitan" norms; it is censored and can hardly 
                be found in the Soviet Union, even in private collections.""");
        Artefact poem = new Artefact("poem", Ansi.ansi().a(ITALIC).a("""
                "…Mountains fall before this grief,
                A mighty river stops its flow,
                But prison doors stay firmly bolted…"\n
                """).reset() + """ 
                This is a piece of poem written by Anna Akhmatova. The text reflects the suffering of the Russian people during the era of Joseph Stalin's Great Purge. It is a personal 
                response to the political repression, arrests, and executions that affected Akhmatova and her family.
                """);
        Artefact note = new Artefact("afterdeath note", Ansi.ansi().a(ITALIC).a("""
                Anja, forgive me. But it would have been worse further on. I am seriously ill—this is not really me. 
                I love you madly. Understand that I could no longer go on living. Convey to Dad and Ale, if you see them, 
                that I loved them until the last minute. And explain that I reached a dead end.\n
                """).reset() + """
                Marina Tsvetaeva, another prominent and persecuted author, escaped from prison abroad but later, upon the call of her heart, returned and committed suicide. Her relatives and 
                close associates were also behind bars due to their support of her creative work. Nobody knew about the relationship between Marina and Anna; the note proves that they were close.
                """);

        //adding artefacts to the appropriate rooms
        entranceHall.allItems.add(coat);
        corridor.allItems.add(book);
        guestRoom.allItems.add(note);
        annaRoom.allItems.add(poem);


        Scanner scanner = new Scanner(System.in);
        Player player = new Player(street, game);

        //default values to fill the hashMap of decisions
        int coatDecision = -1;
        int bookDecision = -1;
        int noteDecision = -1;
        int poemDecision = -1;

        //think logic according to the previous decisions about the items
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("examine")) {
                System.out.print("You have found ");
                try {
                    player.getNextRoom().showLocationItems();
                    for (Artefact item : player.getCurrentRoom().allItems) {
                        System.out.println(item.getaDescription());
                    }
                    if (!player.getCurrentRoom().allItems.isEmpty()) {

                        System.out.println(Ansi.ansi().a(ITALIC).a("Press enter to think about your sanity... ").reset());
                        String leerSpace = scanner.nextLine().toLowerCase();

                        if (player.decisionConsequence.isEmpty()) {
                            System.out.println(Thoughts.thought2);
                        } else if ((player.decisionConsequence.size() == 1 && coat.isDecisionTaken())) {
                            coatDecision = player.decisionConsequence.get("coat");
                            if (coatDecision == 1) {
                                System.out.println(Thoughts.thought1);
                            } else if (coatDecision == 0) {
                                System.out.println(Thoughts.thought5);
                            }
                        } else if (player.decisionConsequence.size() == 2 && book.isDecisionTaken() && coat.isDecisionTaken()) {
                            bookDecision = player.decisionConsequence.get("book");
                            if (coatDecision == 1) {
                                if (bookDecision == 1) {
                                    System.out.println(Thoughts.thought7);
                                } else if (bookDecision == 0) {
                                    System.out.println(Thoughts.thought7);
                                }
                            } else if (coatDecision == 0) {
                                if (bookDecision == 1) {
                                    System.out.println(Thoughts.thought7);
                                } else if (bookDecision == 0) {
                                    System.out.println(Thoughts.thought7);
                                }
                            }
                        } else if (player.decisionConsequence.size() == 3 && coat.isDecisionTaken() && book.isDecisionTaken() && note.isDecisionTaken()) {
                            noteDecision = player.decisionConsequence.get("afterdeath note");
                            if (noteDecision == 0) {
                                if (coatDecision == 1) {
                                    if (bookDecision == 1) {
                                        System.out.println(Thoughts.thought4);
                                    } else if (bookDecision == 0) {
                                        System.out.println(Thoughts.thought3);
                                    }
                                } else if (coatDecision == 0) {
                                    if (bookDecision == 1) {
                                        System.out.println(Thoughts.thought10);
                                    } else if (bookDecision == 0) {
                                        System.out.println(Thoughts.thought10);
                                    }

                                }
                            } else if (noteDecision == 1) {
                                if (coatDecision == 1) {
                                    if (bookDecision == 1) {
                                        System.out.println(Thoughts.thought3);
                                    } else if (bookDecision == 0) {
                                        System.out.println(Thoughts.thought10);
                                    }
                                } else if (coatDecision == 0) {
                                    if (bookDecision == 1) {
                                        System.out.println(Thoughts.thought3);
                                    } else if (bookDecision == 0) {
                                        System.out.println(Thoughts.thought3);
                                    }
                                }
                            }
                        } else {
                            System.out.println("get back to the room where you haven't taken a decision yet."); //TODO: take a decision firstly and then to move forward
                        }

                        }else {
                            System.out.println("Move forward. Choose the next direction.");
                        }

                    continue;
                } catch (NullPointerException e) {
                    System.out.println("get back to the room where you didn't decide on the item and make your mind.");
                }
            }
            if (input.startsWith("t " )) {
                String itemName = input.substring(2);
                player.take(itemName);
                if (player.getCurrentRoom().getName().equalsIgnoreCase("the room of Anna Akhmatova")) {
                    player.lastOutput();
                }
                continue;
            }

            if (input.startsWith("take " )) {
                String itemName = input.substring(5);
                player.take(itemName);
                if (player.getCurrentRoom().getName().equalsIgnoreCase("the room of Anna Akhmatova")) {
                    player.lastOutput();
                }
                continue;
            }

            if (input.startsWith("l ")) {
                String itemName = input.substring(2);
                player.leave(itemName);
                if (player.getCurrentRoom().getName().equalsIgnoreCase("the room of Anna Akhmatova")) {
                    player.lastOutput();
                }
                continue;
            }

            if (input.startsWith("leave ")) {
                String itemName = input.substring(6);
                player.leave(itemName);
                if (player.getCurrentRoom().getName().equalsIgnoreCase("the room of Anna Akhmatova")) {
                    player.lastOutput();
                }
                continue;
            }
            if (input.startsWith("drop ")) {
                String itemNameToDrop = input.substring(5);
                player.setLastAction("drop");

                // Find the item in the inventory
                Artefact itemToDrop = null;
                for (Artefact item : player.inventory) {
                    if (item.getName().equalsIgnoreCase(itemNameToDrop)) {
                        itemToDrop = item;
                        break;
                    }
                }

                if (itemToDrop != null) {
                    player.inventory.remove(itemToDrop);
                    player.decisionConsequence.put(itemNameToDrop, 0);
                    player.getCurrentRoom().allItems.add(itemToDrop);
                    System.out.println("You have dropped a " + itemToDrop.getName() + ". Move forward.");
                } else {
                    System.out.println("Item not found in your inventory.");
                }
                continue;
            }
            if (input.startsWith("d ")) {
                String itemNameToDrop = input.substring(2);
                player.setLastAction("drop");

                // Find the item in the inventory
                Artefact itemToDrop = null;
                for (Artefact item : player.inventory) {
                    if (item.getName().equalsIgnoreCase(itemNameToDrop)) {
                        itemToDrop = item;
                        break;
                    }
                }

                if (itemToDrop != null) {
                    player.inventory.remove(itemToDrop);
                    player.decisionConsequence.put(itemNameToDrop, 0);
                    player.getCurrentRoom().allItems.add(itemToDrop);
                    System.out.println("You have dropped a " + itemToDrop.getName() + ". Move forward.");
                } else {
                    System.out.println("Item not found in your inventory.");
                }
                continue;
            }

            if (input.startsWith("inventory")) {
                if (!player.inventory.isEmpty()) {
                    for (Artefact item : player.inventory) {
                        System.out.println(item.getName());
                    }
                } else {
                    System.out.println("Empty");
                }
                continue;
            }
            if (input.startsWith("i")) {
                if (!player.inventory.isEmpty()) {
                    for (Artefact item : player.inventory) {
                        System.out.println(item.getName());
                    }
                } else {
                    System.out.println("Empty");
                }
                continue;
            }

            if(input.startsWith("help")){
                System.out.println("""
                        [t] or [take] + full name of the object - if you decide to use that object against the wrongdoer
                        [l] or [leave] + full name of the object - if you decide that the evidence is not enough to arrest the wrongdoer
                        [d] or [drop] + full name of the object - if you have taken an object but changed your mind and now want to get rid of it from your inventory
                        [i] or [inventory] - show all the items you have taken
                        [help] - show the helping window with the commands
                        [n] - go to the north
                        [s] - go to the south
                        [w] - go to the west
                        [e] - go to the east
                        [enter] - used once to enter the building in the beginning of the game
                        [examine] - used every time after entering a room to get the info about the location and the possible evidence""");
                continue;
            }

            if (input.startsWith("hashMap")) {
                System.out.println(player.decisionConsequence);
                continue;
            }
            player.go(input);

        }

    }

}




