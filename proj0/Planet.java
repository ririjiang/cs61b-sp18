public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet (double xP, double yP, double xV, double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	};
	public Planet (Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	};

	public double calcDistance(Planet a){
		double yDistanceDiff=a.yyPos-this.yyPos;
		double xDistanceDiff=a.xxPos-this.xxPos;

		return java.lang.Math.sqrt(yDistanceDiff*yDistanceDiff+xDistanceDiff*xDistanceDiff);
	}

	public double calcForceExertedBy(Planet b){
		double distance = this.calcDistance(b);
		return (6.67e-11)*(this.mass*b.mass)/(distance*distance);

	}

	public double calcForceExertedByX(Planet c){
		return this.calcForceExertedBy(c)*(c.xxPos-this.xxPos)/this.calcDistance(c);
	}
	public double calcForceExertedByY(Planet d){
		return this.calcForceExertedBy(d)*(d.yyPos-this.yyPos)/this.calcDistance(d);
	}

	public double calcNetForceExertedByX(Planet[] e){
		int i = 0;
		double sumForceX=0;
		while (i<e.length){
			if(this.calcDistance(e[i])==0){
				sumForceX=sumForceX+0;
			}
			else {
				double currentForceX=this.calcForceExertedByX(e[i]);
				sumForceX=sumForceX+currentForceX;
		}
			i=i+1;
		}
		return sumForceX;
	}	

		public double calcNetForceExertedByY(Planet[] f){
		int i = 0;
		double sumForceY=0;
		while (i<f.length){
			if(this.calcDistance(f[i])==0){
				sumForceY=sumForceY+0;
			}
			else { 
				double currentForceY=this.calcForceExertedByY(f[i]);
				sumForceY=sumForceY+currentForceY;
		}
			i=i+1;
		}
		return sumForceY;
	}

	public void update(double time, double xForce, double yForce){
		double xAcc=xForce/this.mass;
		double yAcc=yForce/this.mass;
		this.xxVel=this.xxVel+xAcc*time;
		this.yyVel=this.yyVel+yAcc*time;
		this.xxPos=this.xxPos+time*this.xxVel;
		this.yyPos=this.yyPos+time*this.yyVel;
	}

}