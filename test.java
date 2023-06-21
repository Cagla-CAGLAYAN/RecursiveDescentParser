import org.w3c.dom.ls.LSOutput;

public class test {
    private Parser object;

    public static void main(String[] args) {

        System.out.println(1 + Parser.lookup("topla") + 5);
        System.out.println( 2+ Parser.lookup("çarp") + 2);
        System.out.println(Parser.lookup("sol parantez") + 10 + Parser.lookup("sağ parantez" ));


    }
 }
