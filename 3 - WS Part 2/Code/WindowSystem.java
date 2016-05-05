import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class WindowSystem extends GraphicsEventSystem{

    //window system width and height
    private int desktopWidth;
    private int desktopHeight;
    //list of Windows in current window system
    private List<SimpleWindow> simpleWindows;

    /*
     * Constructor
     */
    public WindowSystem(int width, int height){

        //save window width and height
        super(width, height);
        super.setBackground(Color.CYAN);
        desktopWidth = width;
        desktopHeight = height;

        //instantiate new list
        simpleWindows = new ArrayList<SimpleWindow>();
    }

    /*
    * Function for turning vector into coordinates
    */
    private int convertX (float coord) { return (int) (desktopWidth * coord); }
    private int convertY (float coord) { return (int) (desktopHeight * coord); }

    /*
     * Add new window to simple windows
     */
    public void addNewWindow(float startX, float startY, int width, int height){

        System.out.println("Draw rect for new window with startx: " + startX + " starty: " + startY + 
                " width: " + width + " height " + height);

        //calculate in coordinates
        int intStartX = convertX(startX);
        int intStartY = convertY(startY);

        System.out.println("Add new window with startx: " + intStartX + " starty: " + intStartY + 
                " width: " + width + " height " + height);

        simpleWindows.add(new SimpleWindow(intStartX, intStartY, width,  height));
        System.out.println("Windows list count now " + simpleWindows.size());
    }

    /*
     * (non-Javadoc)
     * override handle paint in parent
     * Set color and draw line using parent methods
     */
    @Override
    protected void handlePaint(){

        try {
            Thread.sleep(500);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Handle paint with list count " + simpleWindows.size());

        //draw all windows in simple windows buffer
        for (SimpleWindow t:simpleWindows) {

            int leftTopX = t.getLeftTopX();
            int leftTopY = t.getLeftTopY();
            int rightBottomX = t.getRightBottomX();
            int rightBottomY = t.getRightBottomY();

            System.out.println("drawing window rectangle");
            super.setColor(Color.LIGHT_GRAY);
            super.fillRect(leftTopX , leftTopY, rightBottomX, rightBottomY);
            super.setColor(Color.BLUE);
            super.drawRect(leftTopX , leftTopY, rightBottomX, rightBottomY);
        }
    }
}
