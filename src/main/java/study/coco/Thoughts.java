package study.coco;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Attribute.ITALIC;

public class Thoughts {
    public static String thought1 = """
    I have a responsibility to my country and comrades. This is a difficult task, but it's for the greater good. The state has entrusted me with 
    ensuring the security of our socialist ideals. Should I take the evidence with me, though?"""
            + Ansi.ansi().a(ITALIC).a("(take/leave item)").reset();
    public static String thought2 = "i have to be obedient and execute an order. But is it enough to take a person behind the bars? (take/leave item)";
    public static String thought3 = "This is an absolute evidence of the dissidence. This person committed a crime in the eyes of " +
            "the state and will not get away with it. But that is more than just a thing this is a piece of someone s soul. Am I indeed eligible to accuse her for that? (take/leave item)";
    public static String thought4 = "STOP! This is a human history! (take/leave item)";
    public static  String thought5 = """
     I'm forced to act within the general course and take the antagonists of the prosperous future. If I didn't denounce political criminals, 
     I become a suspect in the eyes of the people above me."""
            + Ansi.ansi().a(ITALIC).a("(take/leave item)").reset();
}
