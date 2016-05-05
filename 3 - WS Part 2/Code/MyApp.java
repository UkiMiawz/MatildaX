public class MyApp{

    private static WindowSystem windowSystem;

    /*
     * Main class
     */
    public static void main(String[] args){
        windowSystem = new WindowSystem(800, 600);
        windowSystem.addNewWindow(0.2f, 0.2f, 300, 200);
        windowSystem.addNewWindow(0.5f, 0.4f, 300, 200);
        windowSystem.addNewWindow(0.1f, 0.1f, 300, 200);
    }
}
