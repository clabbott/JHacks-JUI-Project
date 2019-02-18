import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Driver extends Frame implements WindowListener,ActionListener {
        Button loginButton;
        Button newUserButton;
        Server storedInfo = new Server();
        
        public static void main(String[] args) {
                Driver myWindow = new Driver();
                myWindow.setSize(700,500);
                myWindow.setVisible(true);
        }

        public ArrayList<User> getServer(){
        	return storedInfo.users;
        }
        
        public Driver() {
                setLayout(new FlowLayout());
                addWindowListener(this);
                
                loginButton = new Button("Login");
                add(loginButton);
                loginButton.addActionListener(this);
                
                newUserButton = new Button("Create new user");
                add(newUserButton);
                newUserButton.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
        	if(e.getSource() == loginButton) {
        		 LoginWindow nw = new LoginWindow();
        	}
        	if(e.getSource() == newUserButton) {
        		MakeNew win = new MakeNew();
        	}
        }

        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }
        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}