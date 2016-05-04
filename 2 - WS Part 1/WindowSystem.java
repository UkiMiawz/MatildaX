/**
 * Created by asifmayilli on 4/27/16.
 */
import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;

public class WindowSystem extends GraphicsEventSystem{
    private int screenWidth;
    private int screenHeight;
    public  WindowSystem( int width, int height) {
        super(width,height);
        screenHeight = height;
        screenWidth = width;}





    public void drawLine(float xs,float ys,float xe,float ye){
        float xstart = xs*screenWidth;
        float ystart = ys*screenHeight;
        float xend = xe*screenWidth;
        float yend = ye*screenHeight;
        super.drawLine(xstart,ystart,xend,yend);

    }

    public void setColor(Color col){
        super.setColor(col);
    }


    public void handlePaint() {
        this.setColor(Color.RED);
        this.drawLine(0.4f, 0.4f, 0.2f, 0.2f);}

    public static void main(String[] args){WindowSystem windowsystem = new WindowSystem(500,500);
        windowsystem.handlePaint();



    }
}








