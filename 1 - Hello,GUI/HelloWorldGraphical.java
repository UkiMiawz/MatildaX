import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HelloWorldGraphical {

   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel goodDayLabel;
   private JPanel languagePanel;
   private JPanel footerPanel;

   private JButton endButton;

   //constructor
   public HelloWorldGraphical(){
      prepareGUI();
      prepareEvents();
   }

   public static void main(String[] args){
      HelloWorldGraphical helloWorldGraphical = new HelloWorldGraphical();     
   }
   
   //build GUI parts
   private void prepareGUI(){
      mainFrame = new JFrame("Hello World GUI");
      mainFrame.setSize(400,500);
      mainFrame.setLayout(new GridLayout(4, 1));
      mainFrame.setMinimumSize(new Dimension(400, 500));

      headerLabel = new JLabel("",JLabel.CENTER );
      goodDayLabel = new JLabel("",JLabel.CENTER);        

      goodDayLabel.setSize(350,100);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           System.exit(0);
         }        
      });    
      languagePanel = new JPanel();
      languagePanel.setLayout(new GridLayout(3, 1));
      languagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

      footerPanel = new JPanel();
      footerPanel.setLayout(new GridLayout(3, 1));
      footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

      mainFrame.add(headerLabel);
      mainFrame.add(languagePanel);
      mainFrame.add(goodDayLabel);
      mainFrame.add(footerPanel);
      mainFrame.setVisible(true); 
      centreWindow(mainFrame); 
   }

   private void prepareEvents(){
      headerLabel.setText("Choose wisely (not like anything would happen anyway)"); 
      goodDayLabel.setText("Hari yang Indah!");

      JButton deutschButton = new JButton("Deutsch");
      JButton englishButton = new JButton("English");
      JButton francaisButton = new JButton("Francais");
      
      endButton = new JButton("End");

      deutschButton.setActionCommand("Deutsch");
      englishButton.setActionCommand("English");
      francaisButton.setActionCommand("Francais");

      deutschButton.addActionListener(new LanguageClickListener()); 
      englishButton.addActionListener(new LanguageClickListener()); 
      francaisButton.addActionListener(new LanguageClickListener()); 
      endButton.addActionListener(new ExitClickListener());

      languagePanel.add(deutschButton);
      languagePanel.add(englishButton);
      languagePanel.add(francaisButton);
      footerPanel.add(endButton);     

      mainFrame.setVisible(true);  
   }

   private class LanguageClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         if( command.equals( "Deutsch" ))  {
            goodDayLabel.setText("Guten Tag!");
            endButton.setText("Beenden");
         }
         else if( command.equals( "English" ) )  {
            goodDayLabel.setText("Good Day!");
            endButton.setText("End");
         }else if( command.equals( "Francais" ) )  {
            goodDayLabel.setText("Bonne journée!");
            endButton.setText("Terminé");
         }
         else  {
            goodDayLabel.setText("Invalid input");
            endButton.setText("Invalid input");
         }     
      }     
   }

   private class ExitClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         System.exit(0);
      }
   }

   public static void centreWindow(Window frame) {
       Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
       int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
       frame.setLocation(x, y);
   }
}
