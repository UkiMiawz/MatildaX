public class MyApp{

    private static WindowSystem windowSystem;
    private static WindowManager windowManager;

    /*
     * Main class
     */
    public static void main(String[] args){
        
        //instantiate window system
        windowSystem = new WindowSystem(800, 600);
        windowSystem.addNewWindow(0.2f, 0.2f, 300, 200, "Winter");
        windowSystem.addNewWindow(0.5f, 0.4f, 300, 200, "is");
        windowSystem.addNewWindow(0.1f, 0.1f, 300, 200, "Coming");

        windowManager = new WindowManager(windowSystem);
    }
}
