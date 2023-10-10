import java.util.ArrayList;
import java.util.List;

public class RunZoo {
    public ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void displayAnimals(){
        if (animals.isEmpty()) {
            System.out.println();
            System.out.println("There are no animals in the zoo!");
            System.out.println();
        }else {
            for (Animal animal : animals) {
                System.out.println();
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
}


