package study.coco;

import java.util.ArrayList;

public class Artefact {
   private String name;
   private String aDescription;
    public Artefact(String name, String aDescription){
        this.name = name;
        this.aDescription = aDescription;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getaDescription() {
        return aDescription;
    }

    public void setaDescription(String aDescription) {
        this.aDescription = aDescription;
    }
}


