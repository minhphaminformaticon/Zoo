public class Penguin extends Animal implements PreyAnimal, SeaAnimal {
    public Penguin(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
    }

    String wings = name + " uses the wings to swim underwater.";
    String beak = name + " uses the beak to consume fishes.";

    String animal = "penguin";

    @Override
    public void makeSound() {
        System.out.println(getName() + " makes chirping sounds.");
    }

    @Override
    public void action() {
        swim();
        eatFish();
    }

    @Override
    public void attributes() {
        System.out.println(wings);
        System.out.println(beak);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " swims in the cold waters.");
    }

    @Override
    public void eatFish() {
        System.out.println(getName() + " eats fish.");
    }

    @Override
    public void eatPlants() {
        System.out.println();
    }
    @Override
    public String getIcon() {
        icon = "✩\uD83D\uDC27✮";
        return super.getIcon();
    }

    @Override
    public String getAnimal() {
        return animal;
    }
}