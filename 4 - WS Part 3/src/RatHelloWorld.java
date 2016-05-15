import java.awt.Color;
/*
* Widget for "Good Day" in different languages
*/
public class RatHelloWorld extends RATWidget {

	private String greetingString = "Good Day";
	private final Color labelColor = Color.BLACK;
	private final Color labelBackground = new Color(0,0,0,0);
	private final Color buttonColor = Color.GRAY;
	private final Color buttonStringColor = Color.WHITE;
	private int buttonWidth = 310;
	private int buttonHeight = 30;

	private RATButton closeButton;
	private RATLabel greetingLabel;

	private String languages[] = {"Deutsch", "English", "Francais"};

	public RatHelloWorld(SimpleWindow parentWindow, WindowSystem windowSystem){
    	//super constructor
    	super(parentWindow, windowSystem);

    	//create new label
    	greetingLabel = new RATLabel(10, 10, 400, 50, labelBackground);
    	greetingLabel.setString(greetingString);
    	greetingLabel.setStringPadding(130, 25);
    	greetingLabel.setStringColor(labelColor);
    	super.addNewLabel(greetingLabel);

    	//add 3 buttons Deutsch English Francais
    	int lastY = 30;
    	for(String language:languages){
    		lastY += 50;
    		RATButton languageButton = new RATButton(10, lastY, buttonWidth, buttonHeight, buttonColor, language);
	    	languageButton.setString("Greeting in " + language);
    		languageButton.setStringPadding(100, 20);
    		languageButton.setStringColor(buttonStringColor);
    		languageButton.addlistener(new LanguageClickListener());
    		super.addNewButton(languageButton);
    	}

    	//add close button
    	closeButton = new RATButton(10, lastY + 70, buttonWidth, buttonHeight, Color.RED, "close");
    	closeButton.setString("Close this window");
    	closeButton.setStringPadding(100, 20);
    	closeButton.setStringColor(buttonStringColor);
    	closeButton.addlistener(new ExitClickListener());
    	super.addNewButton(closeButton);
    }

    private class LanguageClickListener implements RATMouseListener{
      public void mouseClicked(RATButton e){
        String command = e.getValue();  
        //change label and button text according to language selected
        if(command.equals("Deutsch"))  {
           greetingLabel.setString("Guten Tag!");
           closeButton.setString("Beenden");
        }
        else if(command.equals("English") ){
           greetingLabel.setString("Good Day!");
           closeButton.setString("End");
        }else if(command.equals("Francais") )  {
           greetingLabel.setString("Bonne journée!");
           closeButton.setString("Terminé");
        }
        else{
           greetingLabel.setString("Invalid input");
           closeButton.setString("Invalid input");
        }
      }     
   }

   private class ExitClickListener implements RATMouseListener{
      public void mouseClicked(RATButton e){
        //remove window from window system
        windowSystem.getListWindows().remove(parentWindow);
      }
   }
}