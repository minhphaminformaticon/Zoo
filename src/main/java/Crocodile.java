public class Crocodile extends Animal implements Predator{
    public Crocodile(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
    }
    String claws = "With its sharp claws on all fours, it stalks its prey underwater.";

    String scale = getName() + " uses its scales to protect itself.";

    String animal = "crocodile";
    @Override
    public void makeSound() {
        System.out.println(getName() + " has a deep growl.");
    }

    @Override
    public void action() {
        System.out.println( getName() + ", the crocodile, a stealthy reptile with massive jaws.");
    }

    @Override
    public void attributes() {
        System.out.println(scale);
        System.out.println(claws);
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts its prey.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + "eats meat");
    }

    @Override
    public String getIcon() {
        icon = "✩\uD83E\uDD92✮";
        return icon;
    }

    @Override
    public String getAnimal() {
        return animal;
    }
}
