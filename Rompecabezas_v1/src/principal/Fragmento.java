/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author @mado
 */
public class Fragmento extends JButton{
    private int id;
    
    public Fragmento(int id)
    {
        this.id=id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
