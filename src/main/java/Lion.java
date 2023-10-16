public class Lion extends Animal implements Predator {
    String mane  = name + " has majestic golden mane";
    public Lion(String name, int age, int strength, int health, int defense) {
        super(name, age, strength, health, defense);
    }
    String animal = "lion";

    int strength = 20;

    int defense = 10;





    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars!");
    }

    @Override
    public void hunt() {
        System.out.println(getName() + " hunts other animals.");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " eats other animals.");
    }

    @Override
    public String getIcon() {
        icon = "✩\uD83E\uDD81✮";
        return super.getIcon();
    }

    @Override
    public void action() {
        hunt();
        eatMeat();
    }

    @Override
    public void atributes() {
        System.out.println(mane);
    }

    @Override
    public String getAnimal() {
        return animal;
    }
}
