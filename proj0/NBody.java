public class NBody {
	public static double readRadius(String file) {
		In in = new In(file);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	};

	public static Planet[] readPlanets(String file) {
		In in = new In(file);
		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[N];
		for (int i = 0; i < N; i++) {
			double xp = in.readDouble();
			double yp = in.readDouble();
			double vx = in.readDouble();
			double vy = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xp, yp, vx, vy, m, img);
		}
		return planets;

	};

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-r, r);
		StdDraw.clear();

		double time = 0;
		int num = planets.length;

		while (time < T) {
			double[] xForces = new double[num];
			double[] yForces = new double[num];
			for (int i = 0; i < num; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < num; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");

			for (Planet p : planets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;

		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}

	};

}