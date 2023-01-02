public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV,
            double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    };

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    };

    public double calcDistance(Body that) {
        return Math.sqrt(Math.pow((this.xxPos - that.xxPos), 2) + Math.pow((this.yyPos - that.yyPos), 2));
    };

    public double calcForceExertedBy(Body that) {
        return 1.334 * Math.pow(10, -9) * this.mass * that.mass / this.calcDistance(that);
    };

}
