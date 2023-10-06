public class Lion extends Animal implements Predator {
    String mane  = name + " has majestic golden mane";
    public Lion(String name, int age) {
        super(name, age);
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
        icon = "\uD83E\uDD81";
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
}
