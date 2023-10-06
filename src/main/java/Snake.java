public class Snake extends Animal implements Predator {
    public Snake(String name, int age) {
        super(name, age);
    }

    String scale = name + " uses the scale to shed its skin";

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
    public void atributes() {
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
        System.out.println("\uD83D\uDC0D");
        return super.getIcon();
    }
}