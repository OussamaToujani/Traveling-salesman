package traveling.sales.man;

public class Population {
Path[] path;

public int populationSize() {
    return path.length;
}

public void addPath(int index, Path path) {
	this.path[index] = path;
}

public Path getPath(int index) {
    return path[index];
}

public Population(int populationSize, boolean initializer){
	path = new Path[populationSize];
	if (initializer){
		for (int i = 0; i < populationSize(); i++) {
            Path newPath = new Path();
            newPath.generatepath();
            addPath(i, newPath);
	}
}
}

public Path getBestPath() {
    Path mostFitPath = path[0];
    
    for (int i = 1; i < populationSize(); i++) {
        if (mostFitPath.getFitness() <= getPath(i).getFitness()) {
        	mostFitPath = getPath(i);
        }
    }
    return mostFitPath;
}



}
