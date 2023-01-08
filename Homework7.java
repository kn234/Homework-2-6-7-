import java.util.Random;

public class Homework7 {
    public static void main(String[] args) {
        Random random = new Random();

        String[] catsNames = {
                "Barsik",
                "Murzik",
                "Sharik",
                "Vasya",
                "Ryjhiy",
        };

        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat(catsNames[0], random.nextInt(30)),
                new Cat(catsNames[1], random.nextInt(23)),
                new Cat(catsNames[2], random.nextInt(33)),
                new Cat(catsNames[3], random.nextInt(26)),
                new Cat(catsNames[4], random.nextInt(21)),
        };

        Plate plate = new Plate(100);

        for (Cat cat: cats) {
            cat.eat(plate);
            cat.printInfo();
            plate.getInfo();
        }
    }
    static class Plate {
        private int food;

        public Plate(int food) {
            this.food = food;
        }

        public boolean decreaseFood(int n) {
            if (this.food < n) return false;
            this.food -= n;
            return true;
        }

        public void increaseFood(int n) {
            this.food += n;
        }

        public void getInfo() {
            System.out.println("Plate: " + this.food);
        }
    }

    static class Cat {
        private String name;
        private int satiety;
        private boolean full;

        public Cat(String name, int satiety) {
            this.name = name;
            this.satiety = satiety;
            this.full = false;
        }

        public void eat(Plate plate) {
            full = plate.decreaseFood(satiety);
        }

        public boolean isFull() {
            return full;
        }

        public void printInfo(){
            System.out.println("Nickname: " + name);
            System.out.println(satiety);

            if (full) {
                System.out.println("Kitty is fed");
                return;
            }

            System.out.println("Kitty is not fed");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSatiety() {
            return satiety;
        }

        public void setSatiety(int satiety) {
            this.satiety = satiety;
        }

        public void setFull(boolean full) {
            this.full = full;
        }
    }

}
