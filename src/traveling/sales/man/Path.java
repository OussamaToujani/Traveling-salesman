package traveling.sales.man;

import java.util.ArrayList;
import java.util.Collections;

public class Path {
    private ArrayList<City> path = new ArrayList<>();
    private double fitness = 0;
    private int distance = 0;
    
    public Path(){
        for (int i = 0; i < ListOfCitiesToVisit.numberOfCitiesToVisit(); i++) {
            path.add(null);
        }
    }
    
    public Path(ArrayList<City> chemin){
        this.path = chemin;
    }
    
    public void generatepath() {
        for (int cityIndex = 0; cityIndex < ListOfCitiesToVisit.numberOfCitiesToVisit(); cityIndex++) {
          putCityInPath(cityIndex, ListOfCitiesToVisit.getCity(cityIndex));
        }
        Collections.shuffle(path);
    }
    
    public City getCity(int positionChemin) {
        return (City)path.get(positionChemin);
    }
    
    public void putCityInPath(int positionOnPath, City v) {
        path.set(positionOnPath, v);
        fitness = 0;
        distance = 0;
    }
    
    public int pathSize() {
        return path.size();
    }
    
    public int getDistance(){
        if (distance == 0) {
            int pathDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < pathSize(); cityIndex++) {
                // Get city we're traveling from
                City startingCity = getCity(cityIndex);
                // City we're traveling to
                City arrivingCity;
                // Check we're not on our tour's last city, if we are set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < pathSize()){
                	arrivingCity = getCity(cityIndex+1);
                }
                else{
                	arrivingCity = getCity(0);
                }
                // Get the distance between the two cities
                pathDistance += startingCity.distanceTo(arrivingCity);
            }
            distance = pathDistance;
        }
        return distance;
    }
    
    public double getFitness() {
        if (fitness == 0) {
        	fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    public boolean containsCity(City ville){
        return path.contains(ville);
    }
    
    @Override
    public String toString() {
        String stringGene = "|";
        for (int i = 0; i < pathSize(); i++) {
        	stringGene += getCity(i)+"|";
        }
        return stringGene;
    }
}
