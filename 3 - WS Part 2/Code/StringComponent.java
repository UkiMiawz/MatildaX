//String 2D object for drawing string
public class StringComponent{

	private String stringObject;
	private int xPosition;
	private int yPosition;

	public void setString(String value){ stringObject = value; }
	public void setX(int value){ xPosition = value; }
	public void setY(int value){ yPosition = value; }

	public int getX(){ return xPosition; }
	public int getY(){ return yPosition; }
	public String getString(){ return stringObject; }

	public StringComponent(String stringObject, int xPosition, int yPosition){
		this.stringObject = stringObject;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
}