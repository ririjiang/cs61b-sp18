public class NBody{
		
	
	public static double readRadius(String filename){
		In in = new In(filename);
		int numPlanet = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename1){
		
		In in = new In(filename1);
		int numPlanet = in.readInt();
		Planet[] planetinFile = new Planet[numPlanet];
		double readRadius = in.readDouble();
		int i = 0;
		while(i < numPlanet) {
			planetinFile[i] = new Planet(0, 0,0,0, 0,"2");
			planetinFile[i].xxPos = in.readDouble();
			planetinFile[i].yyPos = in.readDouble();
			planetinFile[i].xxVel = in.readDouble();
			planetinFile[i].yyVel = in.readDouble();
			planetinFile[i].mass = in.readDouble();
			planetinFile[i].imgFileName = in.readString();
			i++;
			
		}
		return planetinFile;
	}




	public static void main(String[] args) {
		double dt = Double.parseDouble(args[0]);
		double T = Double.parseDouble(args[1]);
		String filename = args[2];
		double planetRadius = NBody.readRadius(filename);
		Planet[] arrayPlanets = NBody.readPlanets(filename);

		/*draw background stargield.jpg*/
		StdDraw.setScale(planetRadius,(-1)*planetRadius);
		StdDraw.clear();
		StdDraw.picture( 0, 0, "starfield.jpg");
		StdDraw.show();


		/*draw planet*/
		Planet[] allPlanets = NBody.readPlanets(filename);
		int i = 0 ;
		while(i < allPlanets.length){
			allPlanets[i].draw();
			i++;
		}
		
		StdDraw.enableDoubleBuffering();
		double timevariable = 0;
		while(timevariable < T){
			double[] xForces = new double[allPlanets.length];
			double[] yForces = new double[allPlanets.length];
			for(int j =0; j < allPlanets.length;j++){
				xForces[j] = allPlanets[j].calcNetForceExertedByX(allPlanets);
				yForces[j] = allPlanets[j].calcNetForceExertedByY(allPlanets);
			}
			for(int j =0; j < allPlanets.length;j++){
				allPlanets[j].update(dt, xForces[j],yForces[j]);
			}
			StdDraw.picture( 0, 0, "starfield.jpg");
			for(int k =0;k < allPlanets.length;k++){
				allPlanets[k].draw();		
		}
		StdDraw.show();
		StdDraw.pause(10);
		timevariable = timevariable+ dt;
	}


}

}