import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.event.MouseMotionAdapter;

public class ExtraCreditApp {
	
	private static int windowHeight = 200;
    private static int windowWidth = 400;
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Extra Credit App");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new MyPanel(windowWidth, windowHeight));
        f.setSize(windowWidth, windowHeight);
        f.setVisible(true);
    } 

}

class MyPanel extends JPanel {

    HorizontalLine horizontalLine;
    private int windowHeight;
    private int windowWidth;
    private int maxWidth;

    public MyPanel(int windowWidth, int windowHeight) {

    	this.windowHeight = windowHeight;
    	this.windowWidth = windowWidth;
    	maxWidth = this.windowWidth - 50;
    	
    	horizontalLine = new HorizontalLine(maxWidth);
    	
        setBorder(BorderFactory.createLineBorder(Color.RED));

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
            	resizeLine(e.getY());
            }
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
            	resizeLine(e.getY());
            }
        });

    }

    private void resizeLine(int y){
    	
    	System.out.println("Mouse y detected " + y);
    	
    	final int x1 = (int)horizontalLine.getX1();
    	if(y < x1) y = x1;
    	else if(y > maxWidth) y = maxWidth;
    	
    	System.out.println("Y value now " + y);

        // Current square state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X2 = horizontalLine.getX2();
        final int CURR_Y = horizontalLine.getY1();

        if ((CURR_X2!=y)) {

            // The square is moving, repaint background 
            // over the old square location.
            repaint(CURR_X2-1,CURR_Y-1,2,2);

            // Update coordinates.
            horizontalLine.setX2(y);

            // Repaint the square at the new location.
            repaint(horizontalLine.getX2(),horizontalLine.getY1(),1,1);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(windowWidth, windowHeight);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        horizontalLine.paintLine(g);
    }  
}

class HorizontalLine{
	
	public HorizontalLine(int maxX2){
		x2 = maxX2;
		System.out.println("x2 value now " + x2);
	}

    private int x1 = 40;
    private int y1 = 40;
    private int x2;
    private int y2 = 40;
    
    public int getY1(){
    	return y1;
    }
    
    public int getX1(){
    	return x1;
    }

    public void setX2(int x2){ 
        this.x2 = x2;
    }

    public int getX2(){
        return x2;
    }

    public void paintLine(Graphics g){
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1, y1, x2, y2);
    }
}