import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/*
* Base class for widget's buttons
* Extends RATLabel, add mouse listeners handler
*/
public class RATButton extends RATLabel {

	private String value;
	public String getValue(){ return value; }
	public List<RATMouseListener> mouseListeners;

	public RATButton(int startX, int startY, int width, int height, Color myColor, String buttonValue){
		super(startX, startY, width, height, myColor);
		value = buttonValue;
		mouseListeners = new ArrayList<RATMouseListener>();
	}

	public void addlistener(RATMouseListener mouseListener){
		this.mouseListeners.add(mouseListener); 
	}

	public void triggerListener(){
		for(RATMouseListener mouseListener:mouseListeners){
			mouseListener.mouseClicked(this);
		}
	}

}