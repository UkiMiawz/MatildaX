public class ExpertApp{

    private static WindowSystem windowSystem;

    /*
     * Main class
     */
    public static void main(String[] args){
        
        //instantiate window system
        windowSystem = new WindowSystem(1024, 768);

        //create new simple window & set widget
        SimpleWindow newWindow = new SimpleWindow(0.2f, 0.1f, 270, 310, "The Googleplex Star Thinker");
        TheGoogleplexStarThinker widget = new TheGoogleplexStarThinker(newWindow, windowSystem);
        newWindow.setWidget(widget);
        windowSystem.addNewWindow(newWindow);
    }
}
