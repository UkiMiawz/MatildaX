import java.awt.Rectangle;
import java.awt.Color;

public class RectangleComponent extends Rectangle{
	
	private Color myColor;
	private Boolean isTransparent;

	public Color getColor(){ return myColor; }
	public Boolean isTransparent(){ return isTransparent; }

	public void setColor(Color value){ myColor = value; }
	public void setIsTransparent(Boolean value){ isTransparent = value; }

	public RectangleComponent(int startX, int startY, int width, int height, Color myColor, Boolean isTransparent){
		super(startX, startY, width, height);
		this.isTransparent = isTransparent;
		this.myColor = myColor;
	}
}