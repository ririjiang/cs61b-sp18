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

		args = new String[3];
		args[0] =  "dt";
		args[1] = "T";
		args[2] = "filename";
		double dt = Double.parseDouble(args[0]);
		double T = Double.parseDouble(args[1]);
		String filename = args[2];
		double planetradius = NBody.readRadius(filename);
		Planet[] arrayPlanets = NBody.readPlanets(filename);

 
	}


}