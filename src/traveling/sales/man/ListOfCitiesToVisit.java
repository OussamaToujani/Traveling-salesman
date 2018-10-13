/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveling.sales.man;

import java.util.ArrayList;

/**
 *
 * @author oussama
 */
public class ListOfCitiesToVisit {

    private static ArrayList<City> listOfCitiesToVisit = new ArrayList<City>();

    public static void addCity(City v) {
    listOfCitiesToVisit.add(v);
}

    public static City getCity(int indice){
    return (City)listOfCitiesToVisit.get(indice);
}

    public static int numberOfCitiesToVisit(){
    return listOfCitiesToVisit.size();
}


}
