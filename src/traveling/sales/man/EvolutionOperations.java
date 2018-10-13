package traveling.sales.man;

public class EvolutionOperations {
	private static double mutationRate = 0.015;
    private static int candidateNumber = 5;

    // Evolves a population over one generation
    public static Population evolverPopulation(Population population) {
        Population newPopulation = new Population(population.populationSize(), false);

        // Crossover population
        // Loop over the new population's size and create individuals from
        // Current population
        
        for (int i = 0; i < newPopulation.populationSize(); i++) {
            // Select parents
            Path firstParent = selection(population);
            Path secondParent = selection(population);
            // Crossover parents
            Path fils = crossing(firstParent, secondParent);
            // Add child to new population
            newPopulation.addPath(i, fils);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = 0; i < newPopulation.populationSize(); i++) {
            mutation(newPopulation.getPath(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Path crossing(Path firstParent, Path secondParent) {
        // Create new child tour
    	Path child = new Path();

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * firstParent.pathSize());
        int endPos = (int) (Math.random() * firstParent.pathSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < child.pathSize(); i++) {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) {
            	child.putCityInPath(i, firstParent.getCity(i));
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                	child.putCityInPath(i, firstParent.getCity(i));
                }
            }
        }

        // Loop through parent2's city tour
        for (int i = 0; i < secondParent.pathSize(); i++) {
            // If child doesn't have the city add it
            if (!child.containsCity(secondParent.getCity(i))) {
                // Loop to find a spare position in the child's tour
                for (int j = 0; j < child.pathSize(); j++) {
                    // Spare position found, add city
                    if (child.getCity(j) == null) {
                    	child.putCityInPath(j, secondParent.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }
    
    

    // Mutate a tour using swap mutation
    private static void mutation(Path path) {
        // Loop through tour cities
        for(int posPath1=0; posPath1 < path.pathSize(); posPath1++){
            // Apply mutation rate
            if(Math.random() < mutationRate){
                // Get a second random position in the tour
                int posPath2 = (int) (path.pathSize() * Math.random());

                // Get the cities at target position in tour
                City city1 = path.getCity(posPath1);
                City city2 = path.getCity(posPath2);

                // Swap them around
                path.putCityInPath(posPath2, city1);
                path.putCityInPath(posPath1, city2);
            }
        }
    }

    
    private static Path selection(Population population) {
        // Create a tournament population
        Population candidates = new Population(candidateNumber, false);
        // For each place in the tournament get a random candidate tour and
        // add it
        for (int i = 0; i < candidateNumber; i++) {
            int indiceAuHazard = (int) (Math.random() * population.populationSize());
            candidates.addPath(i, population.getPath(indiceAuHazard));
        }
        
        return candidates.getBestPath();
    }
}



