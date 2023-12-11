package study.coco;

import java.util.ArrayList;
import java.util.List;

public class Room{
    private String name;
    private String description;
    private Room n,s,w,e; //of the same type to be consistent and be able to access currentRoom.north maybe then
    private Room currentRoom;
    private Room nextRoom;
    private ArrayList<Room> map= new ArrayList<>(); // TODO: add locations to the map
    public List<Artefact> locationItems = new ArrayList<>();
    public Room(String name, String aDescription) {
        this.name = name;
        this.description=aDescription;
    }

    public void connectRooms(Room n, Room w, Room e, Room s){ // method to use for further navigation
        this.n =n;
        this.w=w;
        this.e= e;
        this.s = s;
    }
//    public void displayRoomItems(){
//        if (!locationItems.isEmpty()){
//            System.out.println("Items in the room: ");
//            for(Artefact item : locationItems){
//                System.out.println(item.name);
//            }
//        }else {
//            System.out.println("empty room.");
//        }
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getN() {
        return n;
    }

    public void setN(Room n) {
        this.n = n;
    }

    public Room getS() {
        return s;
    }

    public void setS(Room s) {
        this.s = s;
    }

    public Room getW() {
        return w;
    }

    public void setW(Room w) {
        this.w = w;
    }

    public Room getE() {
        return e;
    }

    public void setE(Room e) {
        this.e = e;
    }

    public ArrayList<Room> getMap() {
        return map;
    }

    public void setMap(ArrayList<Room> map) {
        this.map = map;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getNextRoom() {
        return nextRoom;

    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

}
