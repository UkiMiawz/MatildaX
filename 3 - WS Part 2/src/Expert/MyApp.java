public class MyApp{

    private static WindowSystem windowSystem;
    private static WindowManager windowManager;

    /*
     * Main class
     */
    public static void main(String[] args){
        
        //instantiate window system
        windowSystem = new WindowSystem(1024, 768);

        //add windows
        windowSystem.addNewWindow(0.5f, 0.4f, 300, 200, "Window 2 - to life the universe");
        windowSystem.addNewWindow(0.2f, 0.2f, 300, 200, "Window 1 - The answer");
        windowSystem.addNewWindow(0.1f, 0.1f, 300, 200, "Window 3 - and everything else");
    }
}
