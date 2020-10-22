import java.awt.*;  
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

/**
 * 
 * @author Nico Orthmann, u35249
 * 
 * @Version 1.1.0
 * 
 * Programm für Softwaretechnik
 * draws circles when you double click
 * after two circles empties Window
 * menubar with the possibility too change Backgroundcolor
 *
 */

    public class fenster extends Frame implements MouseListener, ActionListener{
    	public int x; //X-Coordinate
    	public int y; //Y-Coordinate
    	public int i = 0; //Counter of circle
    	
    	//Menubar
    	MenuBar mb=new MenuBar();  
        Menu menu=new Menu("Hintergrundfarbe");  
        MenuItem red = new MenuItem("Rot");  
        MenuItem yellow = new MenuItem("Gelb");  
        MenuItem green = new MenuItem("Grün");  
        MenuItem blue = new MenuItem("Blau");  
        MenuItem white = new MenuItem("Weiß");
    	 
        
        
    	public static void main(String[] args) {
    		 
            new fenster();
            //opens Window
        } 
    	
    	
        public fenster(){ 
        	//Window
        	setSize(500,500);  
            setLayout(null);  
            setVisible(true); 
        	
            
        	addMouseListener(this);
        	
        	//rest of menubar
        	menu.add(red);  
            menu.add(yellow);  
            menu.add(green);  
            menu.add(blue);  
            menu.add(white);    
            mb.add(menu);  
            setMenuBar(mb);
            
            //actionlistener for menubar
            red.addActionListener(this);
            yellow.addActionListener(this);
            green.addActionListener(this);
            blue.addActionListener(this);
            white.addActionListener(this);
        	
              
        } 
        
        //change of Backgroundcolor
        public void actionPerformed(ActionEvent a) {
            Object ob = a.getSource();
           
            if(ob == red) 
            	setBackground(Color.RED);
            
            if(ob == yellow) 
            	setBackground(Color.RED);
            
            if(ob == green) 
            	setBackground(Color.GREEN);
               
            if(ob == blue) 
            	setBackground(Color.BLUE);
            	
            if(ob == white) 
            	setBackground(Color.WHITE);
        }
       
        
        
        //draws circle
        public void paint(Graphics g) {
        	Ellipse2D ellipse2D;
        	
        	ellipse2D = new Ellipse2D.Float(x,y,10.0F,10.0F);
        	
        	Graphics2D gd2 = (Graphics2D)g;
        	gd2.draw(ellipse2D);
        }
        
        //reconizes double click
        public void mouseClicked(MouseEvent e) {
        	
        	//starts when double click
        	if (e.getClickCount() == 2) { 
        		
        		//draws when there are less than two circle
        		if(i<2) {
        			x = e.getX();
        			y = e.getY();
        			paint(getGraphics());
        			i++;
        			
        		}else {
        			i=0;
        			x=y=0;
        			//empties window
        			update(getGraphics());
        		} 
       }
      
       }  
       public void mouseEntered(MouseEvent e) {}  
       public void mouseExited(MouseEvent e) {}  
       public void mousePressed(MouseEvent e) {}  
       public void mouseReleased(MouseEvent e) {}  
             
}  
