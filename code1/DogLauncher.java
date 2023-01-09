// the method DogLauncher calls the makeNoise method in DOG

public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(50);
        Dog d2 = new Dog(10);
        d.makeNoise();
        Dog bigger = Dog.maxDog(d, d2);
        bigger.makeNoise();
        Dog bigger2 = d.maxDog(d2);
        bigger2.makeNoise();
        System.out.println(Dog.company);
    }
}
