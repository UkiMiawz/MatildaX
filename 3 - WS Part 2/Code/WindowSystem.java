import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WindowSystem extends GraphicsEventSystem{

    //window system width and height
    private int desktopWidth;
    private int desktopHeight;
    //list of Windows in current window system
    private static List<SimpleWindow> simpleWindows;

    /*
     * Constructor
     */
    public WindowSystem(int width, int height){
        //save window width and height
        super(width, height);
        desktopWidth = width;
        desktopHeight = height;
        //instantiate new list
        simpleWindows = new ArrayList<SimpleWindow>();
    }

    private int convertX (float coord) { return (int) (desktopWidth * coord); }
    private int convertY (float coord) { return (int) (desktopHeight * coord); }

    /*
     * Add new simple window to window system
     */
    public static void addNewWindow(int leftTopX ,int leftTopY,int rightBottomX, int rightBottomY){
        simpleWindows.add(new SimpleWindow(leftTopX ,leftTopY, rightBottomX,  rightBottomY));
    }
    /*
     * (non-Javadoc)
     * override handle paint in parent
     * Set color and draw line using parent methods
     */
    @Override
    protected void handlePaint(){

        //draw all windows in simple windows buffer
        for (SimpleWindow t:simpleWindows) {

            int leftTopX = t.getLeftTopX();
            int leftTopY = t.getLeftTopY();
            int rightBottomX = t.getRightBottomX();
            int rightBottomY = t.getRightBottomY();

            System.out.println("drawing window rectangle");
            System.out.println(t.getID());
            super.drawRect(leftTopX , leftTopY, rightBottomX, rightBottomY);
            System.out.println("filling window rectangle");
            super.setColor(Color.CYAN);
            super.fillRect(leftTopX , leftTopY, rightBottomX, rightBottomY);
        }
    }
}
