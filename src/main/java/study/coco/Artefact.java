package study.coco;

import java.util.ArrayList;

public class Artefact extends Item{

   private boolean decisionTaken = false;

    public Artefact(String name, String aDescription) {
        super(name, aDescription);
    }


    public void setDecisionTaken(boolean decisionTaken) {
        this.decisionTaken = decisionTaken;
    }
    public boolean isDecisionTaken() {
        return decisionTaken;
    }

}


