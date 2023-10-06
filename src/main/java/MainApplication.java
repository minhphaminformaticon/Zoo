import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RunZoo zoo = new RunZoo();

        System.out.println("W E L C O M E  T O  Z O O");
        System.out.println("      /\";;:;;\"\\");
        System.out.println("    (:;/\\,-,/\\;;");
        System.out.println("   (:;{  d b  }:;)");
        System.out.println("    (:;\\__Y__/;;)-----------,,_");
        System.out.println("     ,..\\  ,..\\      ___/___)__`\\");
        System.out.println("    (,,,)~(,,,)`-._##____________)");

        while (true) {
            System.out.println("1. Add an animal to the zoo");
            System.out.println("2. Display animals in the zoo");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAnimalToZoo(scanner, zoo);
                case 2 -> zoo.displayAnimals();
                case 3 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addAnimalToZoo(Scanner scanner, RunZoo zoo) {
        System.out.print("Enter the name of the animal: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age of the animal: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select the animal type:");
        System.out.println("1. Lion");
        System.out.println("2. Elephant");
        System.out.println("3. Shark");
        System.out.println("4. Gorilla");
        System.out.println("5. Snake");
        System.out.println("6. Penguin");
        int animalChoice = scanner.nextInt();
        scanner.nextLine();
        Animal animal;

        switch (animalChoice) {
            case 1 -> animal = new Lion(name, age);
            case 2 -> animal = new Elephant(name, age);
            case 3 -> animal = new Shark(name, age);
            case 4 -> animal = new Gorilla(name, age);
            case 5 -> animal = new Snake(name, age);
            case 6 -> animal = new Penguin(name, age);
            default -> {
                System.out.println("Invalid choice. Animal not added to the zoo.");
                return;
            }
        }

        zoo.addAnimal(animal);
        System.out.println(name + " has been added to the zoo as a " + animal.getClass());
    }
}
