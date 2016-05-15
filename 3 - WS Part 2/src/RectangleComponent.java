import java.awt.Rectangle;
import java.awt.Color;


public class RectangleComponent extends Rectangle{
	
	private Color myColor;
	private String title;
	private Boolean isButton;
	private ButtonValue componentValue;

	public Color getColor(){ return myColor; }
	public String getString(){ return title; }
	public Boolean isButton(){ return isButton; }
	public ButtonValue getValue(){ return componentValue; }

	public void setColor(Color value){ myColor = value; }
	public void setString(String value){ title = value; }
	public void setIsButton(Boolean value){ isButton = value; }
	public void setValue(ButtonValue value){ componentValue = value; }

	public RectangleComponent(int startX, int startY, int width, int height, Color myColor){
		super(startX, startY, width, height);
		this.myColor = myColor;
	}
}