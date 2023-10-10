public class Giraffe extends Animal implements PreyAnimal{

    public Giraffe(String name, int age) {
        super(name, age);
    }
    String animal = "giraffe";

    String longNeck = getName() + " has a long neck";
    @Override
    public void makeSound() {
        System.out.println("it doesnt make any sounds.");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void atributes() {
        System.out.println(longNeck);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants-");
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
