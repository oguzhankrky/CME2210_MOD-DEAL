package userInterface;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
public class SplashScreen implements Runnable {
    private JFrame frame;//Creating object of JFrame
    private JLabel image=new JLabel(createImageIcon("SplashImage.png","Image can not be downloaded"));//Creating object of JLabel and adding image using the ImageIcon class
    private JLabel text=new JLabel("MOD DEALER");//Creating a JLabel object and adding text to it
    private JProgressBar progressBar=new JProgressBar();//Creating an object of JProgressBar
    private JLabel message=new JLabel();//Crating a JLabel for displaying the message
    private Thread mainThread;
    public SplashScreen()
    {
        start();
    }
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);//setting layout to null
        frame.setUndecorated(true);//Turning off Title bar
        frame.setSize(1800,1000);//Setting size
        frame.setLocationRelativeTo(null);//Setting location to the center of screen
        frame.getContentPane().setBackground(Color.DARK_GRAY);//setting background color
        frame.setVisible(true);//setting visibility

    }
    public void addImage(){
        image.setBounds(-30,10,1500,550);
        frame.add(image);//Adding image to the frame
    }
    public void addMessage()
    {
        message.setBounds(680,760,200,40);//Setting the size and location of the label
        message.setForeground(Color.black);//Setting foreground Color
        message.setFont(new Font("arial",Font.BOLD,25));//Setting font properties
        frame.add(message);//adding label to the frame
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,50));//Setting font size of text
        text.setBounds(580,640,600,40);//Setting size and location
        text.setForeground(Color.BLUE);//Setting foreground color
        frame.add(text);//adding text to the frame
    }
    public void addProgressBar(){
        progressBar.setBounds(540,720,400,50);//Setting Location and size
        progressBar.setBorderPainted(true);//Setting border painted property
        progressBar.setStringPainted(true);//Setting String painted property
        progressBar.setBackground(Color.WHITE);//setting background color
        progressBar.setForeground(Color.BLACK);//setting foreground color
        progressBar.setValue(0);//setting progress bar current value
        frame.add(progressBar);//adding progress bar to frame
    }
    public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0

        while( i<=100)
        {
            try{
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING ...");//Setting text of the message JLabel
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    }
    private void start(){
        if (mainThread==null)
            mainThread=new Thread(this);
        mainThread.start();
    }
    @Override
    public void run() {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
}
