public class Zebra extends Animal implements PreyAnimal{
    public Zebra(String name, int age) {
        super(name, age);
    }
    String stripedFur = getName() + " has striped black white fur.";

    String animal = "zebra";
    @Override
    public void makeSound() {
        System.out.println(getName() + " brays");
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void atributes() {
        System.out.println(stripedFur);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats plants");
    }

    @Override
    public String getIcon() {
        icon = "✩\uD83E\uDD93✮";
        return icon;
    }

    @Override
    public String getAnimal() {
        return animal;
    }
}
