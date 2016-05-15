import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/*
* Base class for all widgets
*/
public abstract class RATWidget {

    private UUID id;
	//RAT components list
    private List<RATButton> ratButtons;
    private List<RATLabel> ratLabels;

    protected SimpleWindow parentWindow;
    protected WindowSystem windowSystem;

    public RATWidget(SimpleWindow parentWindow, WindowSystem windowSystem){
    	//list initialization
    	ratButtons = new ArrayList<RATButton>();
    	ratLabels = new ArrayList<RATLabel>();
        this.parentWindow = parentWindow;
        this.windowSystem = windowSystem;
        this.id = UUID.randomUUID();
    }

    //getter
    public List<RATButton> getRatButtons(){ return ratButtons; }
    public List<RATLabel> getRatLabels(){ return ratLabels; }
    public UUID getId(){ return id; }

    /*
    * The x and y parameters here are relative to parent window position
    */
    public void addNewButton(RATButton ratButton){
        ratButtons.add(ratButton);
    }

    public void addNewLabel(RATLabel ratLabel){
        ratLabels.add(ratLabel);
    }

    /*
    * Handle parent window movement
    * Move all components together with widget
    */
    public void moveWidget(int xDifference, int yDifference){
        //move all buttons in widget
        for(RATButton component:ratButtons){
            component.setLocation((int)component.getX() + xDifference, (int)component.getY() + yDifference);
        }

        //move all labels in widget
        for(RATLabel component:ratLabels){
            component.setLocation((int)component.getX() + xDifference, (int)component.getY() + yDifference);
        }
    }

}