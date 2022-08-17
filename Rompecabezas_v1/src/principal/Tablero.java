/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author @mado
 */
public class Tablero extends JFrame implements ActionListener{
    ArrayList<Fragmento> listaFragmento;
            //arreglo dinamicos
    Fragmento pieza,frag;//
//    opciones nuevas para el desarrollo
    private int click1 = -1, click2 = -1, contador=1, cantidad;
    private boolean completado=false;
    private Tablero miTablero;
    private JButton botonsalir,botonjugar;
    JLabel etiqueta1;
    
    
    public Tablero(int cantidadPieza)
    {
        listaFragmento = new ArrayList();
        this.setBounds(0,0,1000,900);// es el tamaño de JFRAME
        this.setLayout(null);
        this.setResizable(false);//para establer un tamaño que el usuario ya no pueda cambiar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rompecabezas");
        this.getContentPane().setBackground(Color.BLACK);         
        
        
        
       botonsalir= new JButton ("Salir");
       botonsalir.setBounds(850,300,100,50);
       add(botonsalir);
       botonsalir.addActionListener(this);
       botonsalir.addActionListener(new ActionListener (){
           public void actionPerformed(ActionEvent e)
       {
           int exit = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el juego?", "",
           JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(exit == JOptionPane.YES_OPTION || exit==JOptionPane.CLOSED_OPTION){
              JOptionPane.showMessageDialog(null, "Saliendo del juego\n Hasta Luego");
              System.exit(0);
            }
       }
             
       });
       
       
       
       
       
       
       
       botonjugar=new JButton("Revolver");
        botonjugar.setBounds(850,200,100,50);
        add(botonjugar);
        botonjugar.addActionListener(this);
        botonjugar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
           Collections.shuffle(listaFragmento);
           
           int x,y;
         x=y=200;
         
          for(int i = 0; i<listaFragmento.size(); i++)
        {
            listaFragmento.get(i).setBounds(x,y,200,200);  
            x+=200; 
           if(i==2){
              y+=200; 
              x=200;
           }
           if(i==5){
              y+=200; 
              x=200;
           }

 
           }
        }}); 
        
        
        
        for(int i=0; i<cantidadPieza;i++)
        {
            pieza =new Fragmento(i);
           
            pieza.setIcon(new ImageIcon("src\\imagenes\\"+i+".jpg"));//mandamos a llamar las imagenes
            pieza.addActionListener(this);
            listaFragmento.add(pieza);
        }

        //Collections.shuffle(listaFragmento); puede llevar o no la opcion para desordenar antes la imagen
         
   
        int x,y;
         x=y=200;

         
        for(int i = 0; i<listaFragmento.size(); i++)
        {
            listaFragmento.get(i).setBounds(x,y,200,200);  //creamos los contenedores con sus medidas
            x+=200; 
           if(i==2){
              y+=200; 
              x=200;
           }
           if(i==5){
              y+=200; 
              x=200;
           }

 this.add(listaFragmento.get(i));
  
        }
    }
    

    
    
    public static void main(String args[])
    {
        Tablero miTablero = new Tablero(9);
        miTablero.setVisible(true);
    }

    @Override 
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        frag = new Fragmento(0);
        int auxId;
        int confirmar=0;
        int indiceBoton=0;
           
        for(int i=0;i<listaFragmento.size();i++)
        {
            if(e.getSource()==listaFragmento.get(i))
            {
                if(contador==1)
                {
                    click1 = i;
                    contador=-1;   
                }

                else if(contador==-1)
                        {
                            click2=i;

                            if(click1 !=click2)
                            {
                                frag.setIcon(listaFragmento.get(click1).getIcon());
                                listaFragmento.get(click1).setIcon(listaFragmento.get(click2).getIcon());
                                listaFragmento.get(click2).setIcon(frag.getIcon());

                                auxId=listaFragmento.get(click1).getId();
                                listaFragmento.get(click1).setId(listaFragmento.get(click2).getId());
                                listaFragmento.get(click2).setId(auxId);

                                contador=1;
                                click1=-1;
                                click2=-1;

                                    for(int j=0;j<listaFragmento.size();j++)
                                    {
                                        if(listaFragmento.get(j).getId()==j)
                                        {
                                            confirmar++;

                                            if(confirmar==listaFragmento.size())
                                            {
                                                completado=true;
                                        JOptionPane.showMessageDialog(null, " Felicidades \n\n Lo Lograstes");
                                        JOptionPane.showMessageDialog(null, " Presiona el boton *Revolver* \n\n para jugar de nuevo");
                                            // JOptionPane.showMessageDialog(null, "Saliendo del programa :)");
                                             // System.exit(0);
                                            }
                                        }
                                    }
                            }
                          
                        }
            }
        }            
    }

}


