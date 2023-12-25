package study.coco;

import java.util.ArrayList;

public class Room{
    private String name;
    private String description;
    private Room n,s,w,e;
    public ArrayList<Artefact> allItems = new ArrayList<>();
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

    public String showLocationItems(){
        if (!allItems.isEmpty()){
            for (Artefact i : allItems){
               // System.out.println("are in front of you");
                System.out.println(i.getName());
            }
        }else{
            System.out.println("nothing. ");
        }
        return null;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Room getN() {
        return n;
    }
    public Room getS() {
        return s;
    }
    public Room getW() {
        return w;
    }
    public Room getE() {
        return e;
    }

}
