package traveling.sales.man;

import java.awt.Graphics;

import javax.swing.JPanel;

public class CityMap extends JPanel {

	Population pop;
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CityMap(Population pop) {
		this.pop=pop;
	}

	protected void paintComponent(Graphics graphics) {
         super.paintComponent(graphics);
         for(int i=0;i < ListOfCitiesToVisit.numberOfCitiesToVisit();i++) {
               graphics.fillOval( ListOfCitiesToVisit.getCity(i).getX()-3, ListOfCitiesToVisit.getCity(i).getY()-3, 6, 6);
               graphics.drawString(ListOfCitiesToVisit.getCity(i).name, ListOfCitiesToVisit.getCity(i).getX()-3, ListOfCitiesToVisit.getCity(i).getY()+20);
         }
               
             if(pop!=null) {
            	 int x1,y1,x2=0,y2=0,x3=0,y3=0;
        	 Path c = pop.getBestPath();
        	 x1=c.getCity(0).getX();
        	 y1=c.getCity(0).getY();
        	 x3=x1;
        	 y3=y1;
        	 for(int i=1;i < c.pathSize();i++) {
        		 x2=c.getCity(i).getX();
            	 y2=c.getCity(i).getY();
        		 graphics.drawLine(x1,y1,x2,y2);
        		 x1=x2;
        		 y1=y2;
        	 }
        	 graphics.drawLine(x3,y3,x2,y2);
             }
          
    }
 
 
}