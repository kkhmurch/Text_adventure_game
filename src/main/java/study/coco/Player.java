package study.coco;

import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    public Room nextRoom;
    ArrayList<Artefact> inventory= new ArrayList<>();


    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
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
            case "inventory":
                System.out.println(inventory);
                break;
            default:
                System.out.println("Invalid command.");
                return;
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println(" You are in " + currentRoom.getName());
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
                break;
            }
        }
        if(itemToTake!=null){
            currentRoom.allItems.remove(itemToTake);
            inventory.add(itemToTake);
            System.out.println("You have taken "+ itemToTake.getName() + ".");
        }else{
            System.out.println("No such object in the room. ");
        }
    }

}
