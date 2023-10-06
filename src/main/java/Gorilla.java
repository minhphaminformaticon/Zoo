public class Gorilla extends Animal implements PreyAnimal {
    public Gorilla(String name, int age) {
        super(name, age);
    }

    String bigArms = name + "has big enourmous arms to climb trees.";

    @Override
    public void makeSound() {
        System.out.println(getName() + " beats its chest!");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void atributes() {
        System.out.println(bigArms);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants.");
    }

    @Override
    public String getIcon() {
        System.out.println("\uD83E\uDD8D");
        return super.getIcon();
    }
}