public class MyApp{

    private static WindowSystem windowSystem;

    /*
     * Main class
     */
    public static void main(String[] args){
        windowSystem = new WindowSystem(1024, 768);
        //for (Rectangle temp:rectBuffer) {
        System.out.println("adding mock windows");
        windowSystem.addNewWindow(5,5,50,50);
        windowSystem.addNewWindow(300,300,600,600);
        windowSystem.addNewWindow(200,200,400,400);
    }
}
