import java.io.Console;

public class HelloWorldConsole{
    public static void main(String[] args) {



        Console cnsl = System.console();
        String name = null;
        Boolean running = true;
        while (running) {
            // instruction list
            System.out.println("Select one of the following:");
            System.out.println("[D]eutsch");
            System.out.println("[E]nglish");
            System.out.println("[F]rancais");
            System.out.println("[Q]uit");

            try {

                if (cnsl != null){
                    //console input
                    name = cnsl.readLine().toLowerCase();

                    //checking which language is chosen
                    if (name.equals("d") ) {System.out.println("Guten Tag!");}
                    else if(name.equals("e")) {System.out.println("Good day!");}
                    else if(name.equals("f")) {System.out.println("bonne journée!");}
                    else if(name.equals("q")){running = false; System.out.println("Quitting...");}
                    else {System.out.println("Please use correct input. Use either D or E or F or Q (it is case insensitive)");}


                }
            } catch (Exception ex) {
                ex.printStackTrace();



            }

        }
    }
}
