public class MyApp{

    private static WindowSystem windowSystem;

    /*
     * Main class
     */
    public static void main(String[] args){
        
        //instantiate window system
        windowSystem = new WindowSystem(1024, 768);

        //add plain boring windows
        SimpleWindow window1 = new SimpleWindow(0.1f, 0.1f, 300, 200, "Window 1 - The answer");
        SimpleWindow window2 = new SimpleWindow(0.3f, 0.3f, 300, 200, "Window 2 - to life the universe");
        SimpleWindow window3 = new SimpleWindow(0.5f, 0.5f, 300, 200, "Window 3 - and everything else");
        
        windowSystem.addNewWindow(window1);
        windowSystem.addNewWindow(window2);
        windowSystem.addNewWindow(window3);

        //create new simple window & set widget
        SimpleWindow babelFishWindow = new SimpleWindow(0.2f, 0.1f, 330, 310, "Hello world and don't panic");
        RatHelloWorld babelFish = new RatHelloWorld(babelFishWindow, windowSystem);
        babelFishWindow.setWidget(babelFish);
        windowSystem.addNewWindow(babelFishWindow);

        SimpleWindow calculatorWindow = new SimpleWindow(0.2f, 0.1f, 270, 310, "The Googleplex Star Thinker");
        Ratulator ratulator = new Ratulator(calculatorWindow, windowSystem);
        calculatorWindow.setWidget(ratulator);
        windowSystem.addNewWindow(calculatorWindow);
    }
}
