import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Animal animal1Or2;
    private Animal animal1or2;

    int maxHealth;
    int maxHealth2;
    public boolean mainFunction;




    Random countR = new Random();
    public Game(){
        mainFunction = true;
    }

    public void newIncreaseCounterForSmokesScreen(Animal animal1Or2){
        animal1Or2.counter++;
    }

    public void executeSmokesBasedOnPercentage(Animal attacker, Animal defender){
        int percentage = calculatePercentage(defender);

        if (countR.nextInt(100) < percentage) {
            defender.counter = 0;
            dodge();
        }else {
            attack(attacker, defender);
        }
    }

    public void dodge(){
        System.out.println("attack dodged!");
    }

    public int calculatePercentage(Animal animal1Or2){
        return Math.min(animal1Or2.counter * 25, 100);
    }

    public boolean startGame(List<Animal> zooAnimals) {
        if (zooAnimals.isEmpty() || zooAnimals.size() < 2) {
            System.out.println();
            System.out.println("The following condition needs to be fulfilled.");
            System.out.println("You can try again.");
            return true;
        }
        Random random = new Random();

        int index1 = random.nextInt(zooAnimals.size());
        int index2;
        do {
            index2 = random.nextInt(zooAnimals.size());
        } while (index2 == index1);

        animal1Or2 = zooAnimals.get(index1);
        animal1or2 = zooAnimals.get(index2);

        Animal[] selectedAnimals = new Animal[]{animal1Or2, animal1or2};
        System.out.println("Battle: " + selectedAnimals[0].getName() + " vs " + selectedAnimals[1].getName());

        fight(selectedAnimals[0], selectedAnimals[1]);
        return false;
    }
    public void attack(Animal attacker, Animal defender){

        int pDamage = attacker.strength;
        int opDefense = defender.defense;

        int dmgTaken= opDefense - pDamage;
        int dmgOutput = 0;

        if (dmgTaken < 0) {
            defender.health += dmgTaken;
            dmgOutput = Math.abs(dmgTaken);
        }
        System.out.println(attacker.name + " inflicts " + dmgOutput + " dmg to " + defender.name);
        System.out.println("health: " + defender.health);
    }
    public void newheal(Animal animal1Or2){

        System.out.println(maxHealth);
        System.out.println(animal1Or2.health);
        int heal = 20;
        if(maxHealth <= animal1Or2.health){
            System.out.println("You can't heal because your health has already reached its max!");
            return;
        }else {
            int newHealth = Math.min(maxHealth, animal1Or2.health + heal);
            int actualHeal = newHealth - animal1Or2.health;
            animal1Or2.health = newHealth;
            System.out.println(animal1Or2.name + " healed for " + actualHeal + " health.");
            System.out.println(animal1Or2.health);
        }
    }

    public void newPowerUp(Animal animal1Or2){
        System.out.println("the previous strength: " + animal1Or2.strength);
        System.out.println();

        double strengthMultiplier = 1.2;
        int currentStrength = animal1Or2.strength;
        double strengthMutiplied = currentStrength * strengthMultiplier;

        currentStrength = (int) strengthMutiplied;
        animal1Or2.strength = currentStrength;

        System.out.println(animal1Or2.name + " has its strength increased to " + currentStrength);
    }

    public void endGame(Animal animal1, Animal animal2) {
        System.out.println();
        System.out.println("Game Over!");
        if (animal1.health <= 0 && animal2.health <= 0) {
            System.out.println("It's a draw! Both animals have fainted.");
        } else if (animal1.health <= 0) {
            System.out.println(animal2.getName() + " wins!");
        } else {
            System.out.println(animal1.getName() + " wins!");
        }
    }
    public void battleAction(Animal attacker, Animal defender){
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println(attacker.name + " stats: ");
        System.out.println("Max HP: " + maxHealth);
        System.out.println("Current HP: " + attacker.health);
        System.out.println("Strength: " + attacker.strength);
        System.out.println("Defense: " + attacker.defense);
        System.out.println("Counter for smokes: " + attacker.counter);
        System.out.println();
        System.out.println(defender.name + " stats: ");
        System.out.println("Max HP: " + maxHealth);
        System.out.println("Current HP: " + defender.health);
        System.out.println("Strength: " + defender.strength);
        System.out.println("Defense: " + defender.defense);
        System.out.println("Counter for smokes: " + defender.counter);
        System.out.println();
    }
    public void fightInput(Animal attacker, Animal defender){
        System.out.println("choose 1 option for " + attacker.name);
        System.out.println("1. attack");
        System.out.println("2. heal");
        System.out.println("3. power up");
        System.out.println("4. set smokes");
        System.out.println();
        Scanner inputGame = new Scanner(System.in);
        int actionGame;
        actionGame = Integer.parseInt(inputGame.nextLine());
        switch (actionGame) {
            case 1 -> executeSmokesBasedOnPercentage(attacker, defender);
            case 2 -> newheal(attacker);
            case 3 -> newPowerUp(attacker);
            case 4 -> newIncreaseCounterForSmokesScreen(attacker);
            default -> System.out.println("Invalid choice. Please try again.");
        }

    }
    public void fight(Animal animal1, Animal animal2) {
        boolean isTurnAnimal1 = true;
            if (animal1 == null || animal2 == null) {
                return;
            } else {
                maxHealth = animal1.getHealth();
                maxHealth2 = animal2.getHealth();
                while (animal1.health > 0 || animal2.health > 0) {
                    if (isTurnAnimal1) {
                        battleAction(animal1, animal2);
                        fightInput(animal1, animal2);
                        isTurnAnimal1 = false;
                    } else {
                        battleAction(animal2, animal1);
                        fightInput(animal2, animal1);
                        isTurnAnimal1 = true;
                    }
                    if (animal1.health <= 0 || animal2.health <= 0) {
                        endGame(animal1, animal2);
                        return;
                    }
                }
            }
    }
}