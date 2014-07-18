/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Main;

import View.Main.Login;
import View.Main.MainView;
import View.Main.setGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DANG.TH
 */
public class Main {
     public static void main(String[] args) {
	  setGUI.LaF();
	  try {
	       new Login().setVisible(true);
	  } catch (IOException ex) {      
	       Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	  }
     }
}
