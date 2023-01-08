import java.util.Random;

public class Homework6 {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        Dog[] dogs = new Dog[5];

        for (int i = 0; i < 5; i++){
            cats[i] = new Cat();
            dogs[i] = new Dog();
        }

        for (Cat cat: cats) {
            cat.printAnimalInfo();
            System.out.println(cat.jump(3.25));
            System.out.println(cat.swim(1));
        }

        for (Dog dog: dogs) {
            dog.printAnimalInfo();
            System.out.println(dog.jump(3));
            System.out.println(dog.swim(10));
        }
    }

    static class Animal {
        Random random = new Random();
        protected double jumpLimit;
        protected double runLimit;
        protected double swimLimit;

        public Animal(double jumpLimit, double runLimit, double swimLimit) {
            this.jumpLimit = jumpLimit;
            this.runLimit = runLimit;
            this.swimLimit = swimLimit;
        }

        public Animal() {
            this.jumpLimit = 3;
            this.runLimit = 350;
            this.swimLimit = 10;
        }

        public void printAnimalInfo() {
            System.out.println("Jump Limit: " + this.jumpLimit);
            System.out.println("Run Limit: " + this.runLimit);
            System.out.println("Swim Limit: " + this.swimLimit);
        }

        public boolean jump(double jumpHeight) {
            return jumpHeight <= this.jumpLimit;
        }

        public boolean run(double runLength) {
            return runLength <= this.runLimit;
        }

        public boolean swim(double swimLength) {
            return swimLength <= this.swimLimit;
        }
    }

    static class Dog extends Animal{
        public Dog(double jumpLimit, double runLimit, double swimLimit) {
            super(jumpLimit, runLimit, swimLimit);
        }

        public Dog() {
            super();
            this.jumpLimit = this.random.nextDouble(1.5, 3.25);
            this.runLimit = this.random.nextDouble(525.25, 645.5);
            this.swimLimit = this.random.nextDouble(15.5, 35.5);
        }
    }

    static class Cat extends Animal {
        public Cat(double jumpLimit, double runLimit, double swimLimit) {
            super(jumpLimit, runLimit, swimLimit);
        }

        public Cat() {
            super();
            this.jumpLimit = this.random.nextDouble(1, 5);
            this.runLimit = this.random.nextDouble(200, 400);
            this.swimLimit = 0;
        }
    }
}
