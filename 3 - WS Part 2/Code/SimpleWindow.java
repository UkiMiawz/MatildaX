import java.util.UUID;
public class SimpleWindow{

    //index of window in the list, also determine which is on top, biggest index means window is on top
    private int indexValue;
    private int leftTopX;
    private int leftTopY;
    private int rightBottomX;
    private int rightBottomY;
    private UUID id;

    public SimpleWindow(int leftTopX, int leftTopY, int rightBottomX, int rightBottomY){
        this.leftTopX = leftTopX;
        this.leftTopY = leftTopY;
        this.rightBottomX = rightBottomX;
        this.rightBottomY = rightBottomY;
        this.id = UUID.randomUUID();
    }

    public int getIndex(){ return indexValue;}
    public int getLeftTopX(){ return leftTopX; }
    public int getLeftTopY(){ return leftTopY; }
    public int getRightBottomX(){ return rightBottomX; }
    public int getRightBottomY(){ return rightBottomY; }
    public UUID getID(){return id;}
}
