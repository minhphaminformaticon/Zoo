import java.util.ArrayList;

public class RunZoo {
    private  ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void displayAnimals(){

        for (Animal animal : animals){
            System.out.println("--------------------------------------");
            System.out.println("Name: " + animal.getName());
            System.out.println("Age: " + animal.getAge());
            System.out.println(animal.getIcon());
            animal.makeSound();
            animal.action();
            animal.atributes();
            System.out.println("--------------------------------------");
        }
    }
}
