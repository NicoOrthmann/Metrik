import java.awt.*;  
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

/**
 * 
 * @author Nico Orthmann, u35249
 * 
 * @Version 1.0
 * 
 * Programm für Softwaretechnik
 * Fenster in dem durch Doppelklick ein kreis gezeichnet wird
 * und bei dritten Doppelklick das Fenster geleert wird
 *
 */

    public class fenster extends Frame implements MouseListener{
    	public int x; //X-Koordinate beim Klicken
    	public int y; //Y-Koordinate beim Klicken
    	public int i = 0; //Counter der Kreise
    	
    	public static void main(String[] args) {  
            new fenster(); //Fenster wird geöffnet 
        } 
    	
    	
        fenster(){  
            addMouseListener(this);  
              
            setSize(500,500);  
            setLayout(null);  
            setVisible(true);  
        } 
        
        
        //Methode zum zeichnen der Kreise
        public void paint(Graphics g) {
        	Ellipse2D ellipse2D;
        	
        	ellipse2D = new Ellipse2D.Float(x,y,10.0F,10.0F);
        	
        	Graphics2D gd2 = (Graphics2D)g;
        	gd2.draw(ellipse2D);
        }
        
        //Methode die das Klicken erkennz
        public void mouseClicked(MouseEvent e) {
        	
        	//startet wenn Doppelgeklicket wird
        	if (e.getClickCount() == 2) { 
        		
        		//wenn weniger als zwei Kreise da sind wird ein neuer gezeichnet
        		if(i<2) {
        			x = e.getX();
        			y = e.getY();
        			paint(getGraphics());
        			i++;
        			
        		}else {
        			i=0;
        			x=y=0;
        			//leeren der Fensters
        			update(getGraphics());
        		} 
       }
      
       }  
       public void mouseEntered(MouseEvent e) {}  
       public void mouseExited(MouseEvent e) {}  
       public void mousePressed(MouseEvent e) {}  
       public void mouseReleased(MouseEvent e) {}  
             
}  