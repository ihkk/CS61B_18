public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
            double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    };

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    };

    public double calcDistance(Planet that) {
        return Math.sqrt(Math.pow((this.xxPos - that.xxPos), 2) + Math.pow((this.yyPos - that.yyPos), 2));
    };

    public double calcForceExertedBy(Planet that) {
        double r = this.calcDistance(that);
        return G * this.mass * that.mass / r / r;
    };

    public double calcForceExertedByX(Planet that) {
        double dis = this.calcDistance(that);
        double ratio = (that.xxPos - this.xxPos) / dis;
        double f = calcForceExertedBy(that);
        return f * ratio;
    };

    public double calcForceExertedByY(Planet that) {
        double dis = this.calcDistance(that);
        double ratio = (that.yyPos - this.yyPos) / dis;
        double f = calcForceExertedBy(that);
        return f * ratio;
    };

    public double calcNetForceExertedByX(Planet[] planets) {
        double result = 0;
        for (Planet p : planets) {
            if (!p.equals(this)) {
                result += calcForceExertedByX(p);
            }
        }
        return result;
    };

    public double calcNetForceExertedByY(Planet[] planets) {
        double result = 0;
        for (Planet p : planets) {
            if (!p.equals(this)) {
                result += calcForceExertedByY(p);
            }
        }
        return result;
    };

    public void update(double dt, double xForce, double yForce) {
        double xAccelerate = xForce / this.mass;
        double yAccelerate = yForce / this.mass;
        this.xxVel += xAccelerate * dt;
        this.yyVel += yAccelerate * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    };
}
