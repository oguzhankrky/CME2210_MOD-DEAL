import userInterface.MainScreen;
import userInterface.SplashScreen;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        SplashScreen screen=new SplashScreen();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainScreen mainScreen=new MainScreen();
        mainScreen.setVisible(true);
    }
}
