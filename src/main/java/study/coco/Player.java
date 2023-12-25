package study.coco;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Player {
    public Room currentRoom;
    public Room nextRoom;
    public String lastAction;
    ArrayList<Artefact> inventory= new ArrayList<>();
    Map<String, Integer> decisionConsequence = new LinkedHashMap<>();
    Game game;


    public Player(Room currentRoom, Game game) {
        this.currentRoom = currentRoom;
        this.game = game;
    }



    public void go(String direction) {

        // nextRoom = null;

        switch (direction) {
            case "n":
                nextRoom = currentRoom.getN();
                break;
            case "w":
                nextRoom = currentRoom.getW();
                break;
            case "s":
                nextRoom = currentRoom.getS();
                break;
            case "e":
                nextRoom = currentRoom.getE();
                break;
            case "enter":
                nextRoom = currentRoom.getN();
                break;
            default:
                System.out.println("Invalid command.");
                return;
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You are in " + currentRoom.getName() + ".");
            System.out.println(currentRoom.getDescription());



        } else {
            System.out.println("You cannot go that way.");
        }
    }

    public void take(String itemName){
        Room currentRoom= this.currentRoom;

        Artefact itemToTake = null;

        for (Artefact item : currentRoom.allItems){
            if (item.getName().equalsIgnoreCase(itemName)){
                itemToTake=item;
                lastAction = "take";
                break;
            }
        }
        if(itemToTake!=null){
            currentRoom.allItems.remove(itemToTake);
            inventory.add(itemToTake);
            decisionConsequence.put(itemToTake.getName(), 1);
            itemToTake.setDecisionTaken(true);
            System.out.println("You have taken "+ itemToTake.getName() + "." + " Move to the next room. ");
        }else{
            System.out.println("No such object in the room. ");
        }
    }
    public void leave(String itemName) {
        Room currentRoom = this.currentRoom;
        Artefact itemToLeave = null;

        for (Artefact item : currentRoom.allItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToLeave = item;
                itemToLeave.setDecisionTaken(true);
                System.out.println("Attention. It might be dangerous. With every left item your personal arrest is getting closer. " + "Move forward, choose the next direction. ");
                lastAction = "leave";
                decisionConsequence.put(itemToLeave.getName(),0);
            }
        }
        if(itemToLeave == null){
            System.out.println("If you don't want to take the item, drop it and move forward.");

        }
    }
    public boolean decideOnInventory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have reached the last room. Before leaving the apartment, you have to decide whether you want to keep or leave all the items you have taken during the rummage.");
        System.out.println("Do you want to drop everything? Type yes/no");

        String decision = scanner.nextLine().toLowerCase();
        return decision.equals("yes");
    }
    public void lastOutput() {

            boolean dropEverything = decideOnInventory();

            if (dropEverything) {
                // Clear the inventory
                inventory.clear();
                System.out.println("You decided to drop everything. Congratulations! You have won the game.");
            } else {
                System.out.println("You decided to keep the items. Game over. You have lost.");
            }

    }

}
