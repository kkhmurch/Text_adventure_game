package study.coco;

//common properties for Artefacts and Rooms
public class Item {
    private  String name;
    private  String aDescription;

    public Item(String name, String aDescription){
        this.name = name;
        this.aDescription = aDescription;
    }

    public String getName() {
        return name;
    }
    public String getaDescription() {
        return aDescription;
    }
}
