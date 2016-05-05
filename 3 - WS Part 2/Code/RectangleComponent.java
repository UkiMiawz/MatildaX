import java.awt.Rectangle;
import java.awt.Color;

public class RectangleComponent extends Rectangle{
	private Color myColor;
	public Color getColor(){ return myColor; }
	public void setColor(Color value){ myColor = value; }

	public RectangleComponent(int startX, int startY, int width, int height, Color myColor){
		super(startX, startY, width, height);
		this.myColor = myColor;
	}
}