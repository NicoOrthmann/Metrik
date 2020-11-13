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

    public class fenster extends Frame implements MouseListener, ActionListener, WindowListener{
    	public int x; //X-Coordinate
    	public int y; //Y-Coordinate
    	public int i = 0; //Counter of circle
    	public boolean f = true;
    	
    	//Menubar
    	MenuBar mb=new MenuBar();  
        Menu menu=new Menu("Hintergrundfarbe");  
        MenuItem red = new MenuItem("Rot");  
        MenuItem yellow = new MenuItem("Gelb");  
        MenuItem green = new MenuItem("Grün");  
        MenuItem blue = new MenuItem("Blau");  
        MenuItem white = new MenuItem("Weiß");
    	 
        Menu form=new Menu("Form");
        MenuItem quadrat = new MenuItem("Quadrat");
        MenuItem kreis = new MenuItem("Kreis");
        
        
        
    	public static void main(String[] args) {
    		 
            new fenster();
            //opens Window
        } 
    	
    	
        public fenster(){ 
        	//Window
        	setSize(500,500);  
            setLayout(null);  
            setVisible(true); 
        	
            addWindowListener(this);
        	addMouseListener(this);
        	
        	//rest of menubar
        	menu.add(red);  
            menu.add(yellow);  
            menu.add(green);  
            menu.add(blue);  
            menu.add(white);    
            mb.add(menu);  
            
            form.add(kreis);
            form.add(quadrat);
            mb.add(form);
            
            setMenuBar(mb);
            
            //actionlistener for menubar
            red.addActionListener(this);
            yellow.addActionListener(this);
            green.addActionListener(this);
            blue.addActionListener(this);
            white.addActionListener(this);
            kreis.addActionListener(this);
            quadrat.addActionListener(this);
        	
              
        } 
        
        //change of Backgroundcolor
        public void actionPerformed(ActionEvent a) {
            Object ob = a.getSource();
           
            if(ob == red) 
            	setBackground(Color.RED);
            
            if(ob == yellow) 
            	setBackground(Color.YELLOW);
            
            if(ob == green) 
            	setBackground(Color.GREEN);
               
            if(ob == blue) 
            	setBackground(Color.BLUE);
            	
            if(ob == white) 
            	setBackground(Color.WHITE);
            
            if(ob == kreis) 
            	f = true;
            if(ob == red) 
            	f = false;
        }
       
        
        
        //draws circle
        public void paint(Graphics g) {
        	Ellipse2D ellipse2D;
        	Graphics2D gd2 = (Graphics2D)g;
        	
        	if (f) {
        		ellipse2D = new Ellipse2D.Float(x,y,10.0F,10.0F);
        		gd2.draw(ellipse2D);
        		gd2.drawString("x: "+x+" y: "+ y,x-5,y-5);
        	}else {
        		
        	}
        	
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


	@Override
	public void windowActivated(WindowEvent arg0) {
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		dispose();
        System.exit(0);	}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}  
             
}  
