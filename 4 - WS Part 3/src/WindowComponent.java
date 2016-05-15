import java.awt.Color;

/*
* Base class for all components that is part of a SimpleWindow
*/
public class WindowComponent extends RATLabel{
	
	private Boolean isButton;
	private ButtonValue componentValue;

	public Boolean isButton(){ return isButton; }
	public ButtonValue getValue(){ return componentValue; }

	public void setIsButton(Boolean value){ isButton = value; }
	public void setValue(ButtonValue value){ componentValue = value; }

	public WindowComponent(int startX, int startY, int width, int height, Color myColor){
		super(startX, startY, width, height, myColor);
	}
}