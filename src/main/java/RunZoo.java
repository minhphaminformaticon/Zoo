import java.util.ArrayList;
import java.util.List;

public class RunZoo {
    private List<Animal> animals;
    private List<Cage> cages;

    public RunZoo() {
        this.animals = new ArrayList<>();
        this.cages = new ArrayList<>();
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);
        for (Cage cage : cages) {
            if (cage.getAnimalType().equals(animal.getAnimal())) {
                cage.addAnimal(animal);
                return;
            }
        }
        Cage newCage = new Cage(animal.getAnimal());
        newCage.addAnimal(animal);
        cages.add(newCage);
    }


    public void displayAnimals(){
        if (animals.isEmpty()) {
            System.out.println();
            System.out.println("There are no animals in the zoo!");
            System.out.println();
        }else {
            for (Cage cage : cages) {
                cage.displayCageInfo();

            }
            for (Animal animal : animals) {
                System.out.println("--------------------------------------");
                System.out.println(animal.getIcon());
                System.out.println("Name: " + animal.getName());
                System.out.println("Age (Level): " + animal.getAge());
                System.out.println("✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮");
                animal.makeSound();
                animal.action();
                animal.atributes();
                System.out.println("✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮✮");
                System.out.println("--------------------------------------");
            }
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}


