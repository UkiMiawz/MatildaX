public class SimpleWindow{

	//index of window in the list, also determine which is on top, biggest index means window is on top
	private int indexValue;
	//window x and y start position in coordinates
	private int yMin;
	private int xMin;
	//window x and y end position in coordinates
	private int yMax;
	private int xMax;

	public SimpleWindow(){
		
	}

	public int getIndex(){ return indexValue;} 
	public int getXMin(){ return xMin; }
	public int getYMin(){ return yMin; }
	public int getYMax(){ return yMax; }
	public int getXMax(){ return xMax; }
}
