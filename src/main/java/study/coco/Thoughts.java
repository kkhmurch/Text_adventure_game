package study.coco;
import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Attribute.ITALIC;

public class Thoughts {
    public final static String thought1 = """
            I have a responsibility to my country and comrades. The ransacking a difficult task, but it's for the greater good. The state has entrusted me with 
            ensuring the security of our socialist ideals. Should I take the evidence with me, though? """
            + Ansi.ansi().a(ITALIC).a("(take/leave + full name of the item)").reset();
    public final static String thought2 = """
            I have to be obedient and execute an order. But is it enough to take a person behind the bars? """
            + Ansi.ansi().a(ITALIC).a("(take/leave + full name of the item)").reset();;
    public final static String thought3 = """
            This is an absolute evidence of the dissidence. This person committed a crime in the eyes of the state and will not get away with it. 
            But that is more than just a thing - this is a piece of someone s soul. Am I indeed eligible to accuse her for that?\n """
            + Ansi.ansi().a(ITALIC).a("(take/leave + full name of the item)").reset();
    public final static String thought4 = "STOP! This is a human history!"+ Ansi.ansi().a(ITALIC).a("(take/leave item)").reset();
    public final static  String thought5 = """
            I'm forced to act within the general course and take the antagonists of the prosperous future. If I didn't denounce political criminals, 
            I become a suspect in the eyes of the people above me."""
            + Ansi.ansi().a(ITALIC).a("(take/leave + full name of the item)").reset();
    public final static  String thought6 = """
            The Party knows best. If someone is under investigation, they must have deviated from the path of socialism. Our leaders are protecting us from enemies within."""
            + Ansi.ansi().a(ITALIC).a("(take/leave + full name of the item)").reset();

    public final static  String thought7 = """
            I must suppress these emotions. Personal feelings cannot interfere with the greater mission of preserving the socialist state."""
            + Ansi.ansi().a(ITALIC).a("(take/leave+ full name of the item)").reset();

    public final static  String thought8 = """
           I must be vigilant. Even those who seem loyal might hide counter-revolutionary tendencies. It's crucial to uncover any potential threats before they can do harm."""
            + Ansi.ansi().a(ITALIC).a("(take/leave+ full name of the item)").reset();

    public final static  String thought9 = """
          If I do not carry out these orders, I will be seen as disloyal. I must protect myself and my family from any suspicion. 
          I have to comply and not question the Party's decisions. """
            + Ansi.ansi().a(ITALIC).a("(take/leave+ full name of the item)").reset();

    public final static  String thought10 = """
            This unmistakably reveals a clear disagreement. The person has broken the law in the view of the authorities and will face repercussions. """
            + Ansi.ansi().a(ITALIC).a("(take/leave+ full name of the item)").reset();

}
