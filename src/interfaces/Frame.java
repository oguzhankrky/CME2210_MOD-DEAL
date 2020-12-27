/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import person.Client;

public interface Frame  {

    public JFrame getOldFrame();

    public void setOldFrame(JFrame oldFrame);

    public Client getClient();

    public void setClient(Client client);
 
 
    
    
}
