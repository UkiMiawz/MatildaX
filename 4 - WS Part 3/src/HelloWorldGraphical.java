public class HelloWorldGraphical{

    private static WindowSystem windowSystem;

    /*
     * Main class
     */
    public static void main(String[] args){
        
        //instantiate window system
        windowSystem = new WindowSystem(1024, 768);

        //create new simple window & set widget
        SimpleWindow newWindow = new SimpleWindow(0.2f, 0.1f, 330, 310, "Hello world and don't panic");
        RatHelloWorld widget = new RatHelloWorld(newWindow, windowSystem);
        newWindow.setWidget(widget);
        windowSystem.addNewWindow(newWindow);
    }
}
