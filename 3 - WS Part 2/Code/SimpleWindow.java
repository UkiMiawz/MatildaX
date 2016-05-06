import java.util.UUID;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class SimpleWindow{

    //index of window in the list, also determine which is on top, biggest index means window is on top
    private UUID id;
    private int indexValue;
    
    private int leftTopX;
    private int leftTopY;

    private int height;
    private int width;

    //window title
    private String title;
    private Color myColor = Color.WHITE;
    private Color borderColor = Color.YELLOW;

    //components list
    private List<RectangleComponent> rectangleComponents;
    private List<StringComponent> stringComponents;

    public SimpleWindow(int leftTopX, int leftTopY, int width, int height, String title){
        
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.height = height;
        this.width = width;
        this.title = title;

        this.id = UUID.randomUUID();

        //instantiate component list
        rectangleComponents = new ArrayList<RectangleComponent>();
        stringComponents = new ArrayList<StringComponent>();
    }

    //getter
    public int getIndex(){ return indexValue; }
    public UUID getId(){ return id; }
    public String getTitle(){ return title; }
    public Color getColor(){ return myColor; }
    public Color getBorderColor(){ return borderColor; }

    public int getLeftTopX(){ return leftTopX; }
    public int getLeftTopY(){ return leftTopY; }
    public int getRightBottomX(){ return leftTopX + width; }
    public int getRightBottomY(){ return leftTopY + height; }
    public int getHeight(){ return height; }
    public int getWidth(){ return width; }

    //setter
    public void setIndex(int value){ indexValue = value; }
    public void setColor(Color value){ myColor = value; }
    public void setBorderColor(Color value){ borderColor = value; }

    public void setLeftTopX(int value){ leftTopX = value; }
    public void setLeftTopY(int value){ leftTopY = value; }
    public void setHeight(int value){ height = value; }
    public void setWidth(int value){ width = value; }

    //setter getter for simple window components
    public void addNewComponent(RectangleComponent newComponent){ rectangleComponents.add(newComponent); }
    public List<RectangleComponent> getRectangleComponents(){ return rectangleComponents; }

    public void addNewComponent(StringComponent newComponent){ stringComponents.add(newComponent); }
    public List<StringComponent> getStringComponents(){ return stringComponents; }
}
