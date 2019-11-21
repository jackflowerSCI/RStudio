/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rstudio;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import java.sql.Connection;

public class Application {
    private static Connection _databaseConnection;
    private static LoginWindow _loginWindow;
    
    public static Connection getDatabaseConnection() { return _databaseConnection; }
    public static void setDatabaseConnection(Connection conn) { _databaseConnection = conn; }
    
    public static void main(String args[]) {
        runSplashScreen(2000);
        
        _loginWindow = new LoginWindow();
        _loginWindow.setVisible(true);
    }
    
    private static boolean runSplashScreen(long millis) {
        final var width = 640;
        final var height = 480;
            
        try {
            var picture = ImageIO.read(new File("splash.jpg"));
            var label = new JLabel(new ImageIcon(picture.getScaledInstance(width, height, Image.SCALE_FAST)));
            
            var window = new JWindow();
            window.setSize(width, height);
            window.add(label);
            window.setVisible(true);
            
            Thread.sleep(millis, 0);
            
            window.setVisible(false);
            return true;
        } catch (IOException ex) {
            return false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
