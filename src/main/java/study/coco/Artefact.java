package study.coco;

import java.util.ArrayList;

public class Artefact {
   private String name;
   private String aDescription;
   private boolean decisionTaken = false;
    public Artefact(String name, String aDescription){
        this.name = name;
        this.aDescription = aDescription;
    }
    public String getName() {
        return name;
    }
    public String getaDescription() {
        return aDescription;
    }
    public void setDecisionTaken(boolean decisionTaken) {
        this.decisionTaken = decisionTaken;
    }
    public boolean isDecisionTaken() {
        return decisionTaken;
    }

}


