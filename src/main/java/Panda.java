public class Panda extends Animal implements PreyAnimal{

    public Panda(String name, int age) {
        super(name, age);
    }
    String cuteEyes = getName() + " has super cute eyes.";

    String animal = "panda";

    @Override
    public void makeSound() {
        System.out.println(getName() + " growls!" );
    }

    @Override
    public void action() {
        eatPlants();
    }

    @Override
    public void atributes() {
        System.out.println(cuteEyes);
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " eats bamboos everyday.");
    }

    @Override
    public String getIcon() {
        icon = "✩\uD83D\uDC3C✮";
        return super.getIcon();
    }

    @Override
    public String getAnimal() {
        return animal;
    }
}
