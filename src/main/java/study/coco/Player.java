package study.coco;

public class Player{
    Room currentRoom;
    Room nextRoom;


    public Player(Room currentRoom) {
        this.currentRoom= currentRoom;

    }

    public void go(String direction){
        nextRoom = null;

        switch(direction){
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
            default:
                System.out.println("Invalid direction.");
                return;
        }

        if(nextRoom != null){
            System.out.println(" You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
            currentRoom = nextRoom;
        }else{
            System.out.println("You cannot go that way.");
        }
    }
}
