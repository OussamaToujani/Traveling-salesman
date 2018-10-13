package traveling.sales.man;

public class City {
int x,y;
String name ="";

public City(int x, int y){
	
	this.x=x;
	this.y=y;
}
public int getX(){
    return this.x;
}

public int getY(){
    return this.y;
}

public double distanceTo(City v){
    int xDistance = Math.abs(getX() - v.getX());
    int yDistance = Math.abs(getY() - v.getY());
    double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
    
    return distance;
}

@Override
public String toString(){
    return "abscissa: "+getX()+", ordinate: "+getY();
}
}
