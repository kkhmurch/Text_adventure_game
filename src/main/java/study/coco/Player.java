package study.coco;

import java.util.ArrayList;

public class Player{
    private Room currentRoom;
    Room nextRoom;



    public Player(Room currentRoom) {
        this.currentRoom= currentRoom;


    }

    public void go(String direction){
       // nextRoom = null;

        switch(direction){
            case "n":
                nextRoom = currentRoom.getN();
                System.out.println(currentRoom.allItems);
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
                nextRoom =currentRoom.getN();
            case "examine":

            default:
                System.out.println("Invalid direction.");
                return;
        }

        if(nextRoom != null){
            currentRoom = nextRoom;
            System.out.println(" You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());



        }else{
            System.out.println("You cannot go that way.");
        }

    }
}
