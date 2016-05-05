import java.awt.Color;

public class StringComponent{

	private String stringObject;
	private int xPosition;
	private int yPosition;
	private Color myColor;

	public void setString(String value){ stringObject = value; }
	public void setX(int value){ xPosition = value; }
	public void setY(int value){ yPosition = value; }
	public void setColor(Color value){ myColor = value; }

	public int getX(){ return xPosition; }
	public int getY(){ return yPosition; }
	public String getString(){ return stringObject; }
	public Color getColor(){ return myColor; }

	public StringComponent(String stringObject, int xPosition, int yPosition, Color myColor){
		this.stringObject = stringObject;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.myColor = myColor;
	}
}