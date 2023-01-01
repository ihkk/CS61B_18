
public class Dog {
    // Instance variable
    public int weightInPounds;
    public static String company = "ABC";

    // One integer Constructor for dogs.
    public Dog(int w) {
        weightInPounds = w;
    }

    // None-static method, a.k.a. Instance Method
    // If the function is going to be invoked by an instance
    // of the class (like "weightInPounds"), then it
    // should be non-static
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("Yip!");
        } else if (weightInPounds < 30) {
            System.out.println("Bark.");
        } else {
            System.out.println("Woolf!");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }

    public Dog maxDog(Dog d2) {
        if (this.weightInPounds > d2.weightInPounds) {
            return this;
        }
        return d2;
    }
}
