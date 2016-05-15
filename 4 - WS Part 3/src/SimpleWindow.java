import java.util.UUID;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class SimpleWindow{

    //index of window in the list, also determine which is on top, biggest index means window is on top
    private UUID id;
    private int indexValue;
    
    private float relativeLeftTopX;
    private float relativeLeftTopY;

    private int leftTopX;
    private int leftTopY;

    private int height;
    private int width;

    //window title
    private String title;
    private Color fillColorWindow = Color.ORANGE;
    private Color frameColorWindow = Color.BLACK;

    //one window can only have one widget
    private RATWidget widget;

    //components list
    private List<WindowComponent> rectangleComponents;

    public SimpleWindow(float relativeLeftTopX, float relativeLeftTopY, int width, int height, String title){
        
        this.relativeLeftTopX = relativeLeftTopX;
        this.relativeLeftTopY = relativeLeftTopY;
        this.height = height;
        this.width = width;
        this.title = title;

        this.id = UUID.randomUUID();

        //instantiate component list
        rectangleComponents = new ArrayList<WindowComponent>();
    }

    //getter
    public int getIndex(){ return indexValue; }
    public UUID getId(){ return id; }
    public String getTitle(){ return title; }
    public Color getFillColorWindow(){ return fillColorWindow; }
    public Color getFrameColorWindow() {return frameColorWindow; }

    public float getRelativeLetfTopX(){ return relativeLeftTopX; }
    public float getRelativeLetfTopY(){ return relativeLeftTopY; }

    public int getLeftTopX(){ return leftTopX; }
    public int getLeftTopY(){ return leftTopY; }
    public int getRightBottomX(){ return leftTopX + width; }
    public int getRightBottomY(){ return leftTopY + height; }
    public int getHeight(){ return height; }
    public int getWidth(){ return width; }

    //setter
    public void setIndex(int value){ indexValue = value; }
    public void setFillColorWindowColor(Color value){ fillColorWindow = value; }
    public void setFrameColorWindow(Color value) {frameColorWindow = value;}

    public void setLeftTopX(int value){ leftTopX = value; }
    public void setLeftTopY(int value){ leftTopY = value; }
    public void setHeight(int value){ height = value; }
    public void setWidth(int value){ width = value; }

    //setter getter for simple window components
    public void addNewComponent(WindowComponent newComponent){ rectangleComponents.add(newComponent); }
    public List<WindowComponent> getRectangleComponents(){ return rectangleComponents; }
    public void resetComponents(){ rectangleComponents = new ArrayList<WindowComponent>(); }

    public void setWidget(RATWidget value){ widget = value; }
    public RATWidget getWidget(){ return widget; }

    /*
    * Handle this window movement
    * Move all components together with window
    */
    public void moveWindow(int xDifference, int yDifference){
        //move window position
        leftTopY += yDifference;
        leftTopX += xDifference;
        //move all components in window position
        for(WindowComponent component:rectangleComponents){
            component.setLocation((int)component.getX() + xDifference, (int)component.getY() + yDifference);
        }

        //move widget if there's any
        if(widget != null)
            widget.moveWidget(xDifference, yDifference);
    }
}
