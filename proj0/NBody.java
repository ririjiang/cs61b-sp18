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
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double planetRadius = NBody.readRadius(filename);
		Planet[] allPlanets = NBody.readPlanets(filename);

		/*draw background stargield.jpg*/
		StdDraw.setScale(-planetRadius,planetRadius);
		StdDraw.clear();
		StdDraw.picture( 0, 0, "starfield.jpg");

		/*draw planet*/
		for (Planet pl: allPlanets) {
            pl.draw();
        }
		StdDraw.pause(0);
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
		timevariable = timevariable + dt;
	}
	StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n",planetRadius );
        for (int i = 0; i < allPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                            allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }


}

}