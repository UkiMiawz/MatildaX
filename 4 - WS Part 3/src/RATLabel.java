import java.awt.Rectangle;
import java.awt.Color;

public class RATLabel extends Rectangle{
	
	private Color myColor;
	private Color stringColor;

	private String title = "";

	public int stringPaddingLeft;
	public int stringPaddingTop;

	public Color getColor(){ return myColor; }
	public Color getStringColor(){ return stringColor; }
	public String getString(){ return title; }

	public int getStringPaddingLeft(){ return stringPaddingLeft; }
	public int getStringPaddingTop(){ return stringPaddingTop; }

	public void setColor(Color value){ myColor = value; }
	public void setStringColor(Color value){ stringColor = value; }
	public void setString(String value){ title = value; }
	
	public void setStringPadding(int paddingLeft, int paddingTop){ 
		stringPaddingLeft = paddingLeft; 
		stringPaddingTop = paddingTop;
	}

	public RATLabel(int startX, int startY, int width, int height, Color myColor){
		super(startX, startY, width, height);
		this.myColor = myColor;
	}
}