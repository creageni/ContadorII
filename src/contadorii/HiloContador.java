/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contadorii;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HiloContador extends Thread{

    int cont;
    boolean band1,band2;
    ContadorII ventana;
    
    
    public HiloContador(ContadorII ventana){
        cont=0;
        band1=true;
        band2=true;
        this.ventana=ventana;
    }
    
    @Override
    public void run() {
       
       while(band1){
           try {
               Thread.sleep(1000);
               
               if(band2){
                   cont++;
                   ventana.getResultado().setText(""+cont);
               }
          } catch (InterruptedException ex) {
               Logger.getLogger(HiloContador.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       } 
        
    }
    
    public void stopThread(){
        band1=false;
    }
    
    public void pauseThread(){
        band2=false;
    }
    
    public void restartThread(){
        band2=true;
    }
    
    
    
    
    
        
}
