import java.awt.Color;
/*
* Widget for Simple calculator
*/
public class TheGoogleplexStarThinker extends RATWidget {

	private String numberString = "0";
    private double savedCalculation = 0.0;
    private String lastOperator = "";
	
	private final Color labelColor = Color.BLACK;
	private final Color labelBackground = new Color(0,0,0,0);
	private final Color buttonColor = Color.GRAY;
	private final Color buttonStringColor = Color.WHITE;
	private final Color operatorButtonColor = Color.DARK_GRAY;
	private final Color operatorStringColor = Color.WHITE;

	private int buttonWidth = 50;
	private int buttonHeight = 50;
	private int labelHeight = 50;
	private int labelWidth = 250;
	private int buttonMargin = 10;
	private int startX = 20;
	private int startY = 10;
	private int buttonPerRow = 3;

    private double labelRatio = 0.8;

	private RATLabel numberLabel;
    private RATLabel operatorLabel;

	private String operators[] = {"/", "*", "-", "+"};
	private String specials[] = {"0", "."};

	public TheGoogleplexStarThinker(SimpleWindow parentWindow, WindowSystem windowSystem){
    	//super constructor
    	super(parentWindow, windowSystem);

    	//create new label
    	numberLabel = new RATLabel(startX, startY, (int)(labelWidth*labelRatio), labelHeight, labelBackground);
    	numberLabel.setString(numberString);
    	numberLabel.setStringPadding(10, labelHeight/2 - 5);
    	numberLabel.setStringColor(labelColor);
    	super.addNewLabel(numberLabel);

        //create operator label        
        operatorLabel = new RATLabel(startX + (int)(labelWidth*labelRatio), startY, (int)(labelWidth*(1-labelRatio)), labelHeight, labelBackground);
        operatorLabel.setStringPadding(10, labelHeight/2 - 5);
        operatorLabel.setStringColor(labelColor);
        super.addNewLabel(operatorLabel);


    	//add buttons for numbers
    	int lastY = startY + labelHeight;
    	int lastX = startX;
    	for(int i=1; i<=9; i++){
    		//draw button
    		RATButton button = new RATButton(lastX, lastY, buttonWidth, buttonHeight, buttonColor, Integer.toString(i));
	    	button.setString(Integer.toString(i));
    		button.setStringPadding(buttonHeight/2, buttonWidth/2 - 2);
    		button.setStringColor(buttonStringColor);
    		button.addlistener(new NumberClickListener());
    		super.addNewButton(button);
    		lastX += buttonWidth + buttonMargin;

    		//add button by 3 per row
    		if(i%buttonPerRow == 0)
    		{
    			lastX = startX;
    			lastY += buttonHeight + buttonMargin;
    		}
        }

        //add special characters
        for(String special:specials){
    		RATButton button = new RATButton(lastX, lastY, buttonWidth, buttonHeight, buttonColor, special);
	    	button.setString(special);
    		button.setStringPadding(buttonHeight/2 - 2, buttonWidth/2 - 2);
    		button.setStringColor(buttonStringColor);
    		button.addlistener(new NumberClickListener());
    		super.addNewButton(button);
    		lastX += buttonWidth + buttonMargin;
        }

        //add "=" operator
        RATButton equalButton = new RATButton(lastX, lastY, buttonWidth, buttonHeight, operatorButtonColor, "=");
    	equalButton.setString("=");
		equalButton.setStringPadding(buttonHeight/2 - 2, buttonWidth/2 - 2);
		equalButton.setStringColor(operatorStringColor);
		equalButton.addlistener(new OperatorClickListener());
		super.addNewButton(equalButton);

        //add other math operators
		lastX = buttonPerRow * (buttonWidth + buttonMargin) + startX;
		lastY = startY + labelHeight;
        for(String operator:operators){
        	//draw button
    		RATButton button = new RATButton(lastX, lastY, buttonWidth, buttonHeight, operatorButtonColor, operator);
	    	button.setString(operator);
    		button.setStringPadding(buttonHeight/2 - 2, buttonWidth/2 - 2);
    		button.setStringColor(operatorStringColor);
    		button.addlistener(new OperatorClickListener());
    		super.addNewButton(button);
    		lastY += buttonHeight + buttonMargin;
        }
    }

    /*
    * Listener for number buttons
    */
    private class NumberClickListener implements RATMouseListener{
      public void mouseClicked(RATButton e){
         String command = e.getValue();
         if(!numberString.equals("0"))
            numberString += command;
         else
            numberString = command;
        numberLabel.setString(numberString);
      }     
   }

   /*
   * Listener for operator buttons
   */
   private class OperatorClickListener implements RATMouseListener{
      public void mouseClicked(RATButton e){
        String command = e.getValue();
        operatorLabel.setString(command);
        numberString = doCalculation(lastOperator, savedCalculation, Double.parseDouble(numberString));
        numberLabel.setString(numberString);
        savedCalculation = Double.parseDouble(numberString);
        if(!command.equals("="))
            numberString = "0";
        lastOperator = command;
      }
   }

   /*
   * Do calculation for all operators
   */
   private String doCalculation(String operator, Double firstNumber, Double secondNumber){
        Double result;
        switch(operator){
            case "/":
                result = firstNumber / secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "=":
                result = firstNumber;
                break;
            default:
                result = secondNumber;
        }
        return Double.toString(result);
   }
}