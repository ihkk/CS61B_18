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

}
