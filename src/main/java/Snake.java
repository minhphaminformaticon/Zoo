public class Snake extends Animal implements Predator {
    public Snake(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
    }

    String scale = name + " uses the scale to shed its skin";

    String animal = "snake";
    @Override
    public String getAnimal() {
        return animal;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " hisses!");
    }

    @Override
    public void action() {
        hunt();
        eatMeat();
    }

    @Override
    public void attributes() {
        System.out.println(scale);

    }

    @Override
    public void hunt() {
        System.out.println(getName() + " slithers and hunts for prey.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats meat.");
    }

    @Override
    public String getIcon() {
        System.out.println("✩\uD83D\uDC0D✮");
        return super.getIcon();
    }
}