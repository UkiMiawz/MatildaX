import java.util.UUID;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Line2D;

public class SimpleWindow{

    //index of window in the list, also determine which is on top, biggest index means window is on top
    private int indexValue;
    private int leftTopX;
    private int leftTopY;

    private int height;
    private int width;

    private UUID id;

    private List<Rectangle> rectangleComponents;
    private List<Line2D> lineComponents;

    private String title;

    //constructor
    public SimpleWindow(int leftTopX, int leftTopY, int width, int height, String title){

        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.height = height;
        this.width = width;
        this.title = title;

        this.id = UUID.randomUUID();

        //instantiate new list for rectangle and line
        rectangleComponents = new ArrayList<Rectangle>();
        lineComponents = new ArrayList<Line2D>();
    }

    //getter
    public int getIndex(){ return indexValue;}
    public int getLeftTopX(){ return leftTopX; }
    public int getLeftTopY(){ return leftTopY; }
    public int getRightBottomX(){ return leftTopX + width; }
    public int getRightBottomY(){ return leftTopY + height; }
    public int getHeight(){ return height; }
    public int getWidth(){ return width; }

    //setter
    public void setIndex(int value){ indexValue = value; }
    public void setLeftTopX(int value){ leftTopX = value; }
    public void setLeftTopY(int value){ leftTopY = value; }
    public void setHeight(int value){ height = value; }
    public void setWidth(int value){ width = value; }

    public UUID getId(){return id;}

    //setter getter for simple window components
    public void addNewComponent(Rectangle newComponent){ rectangleComponents.add(newComponent); }
    public void addNewComponent(Line2D newComponent){ lineComponents.add(newComponent); }
    public List<Rectangle> getRectangleComponents(){ return rectangleComponents; }
    public List<Line2D> getLineComponents(){ return lineComponents; }
}
