package com.informaticon.java.tutorial.zoo.miph;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private int team1ActionChoice = 0;
    private int team2ActionChoice = 0;
    public boolean mainFunction;
    Random countR = new Random();

    public Game() {
        mainFunction = true;
    }

    public void newIncreaseCounterForSmokesScreen(Animal animal1Or2) {
        animal1Or2.setCounter(animal1Or2.getCounter() + 1);
    }

    public void executeSmokesBasedOnPercentage(Animal attacker, Animal defender) {
        int percentage = calculatePercentage(defender);

        if (countR.nextInt(100) < percentage) {
            defender.setCounter(0);
            dodge();
        } else {
            attack(attacker, defender);
        }
    }

    public void dodge() {
        System.out.println("attack dodged!");
    }

    public int calculatePercentage(Animal animal1Or2) {
        return Math.min(animal1Or2.getCounter() * 25, 100);
    }

    /**
     * This method initializes and starts the game with 4 animals.
     *
     * @param zooAnimals list of all animals in the zoo
     * @return false
     */
    public boolean startGame(List<Animal> zooAnimals) {
        if (zooAnimals.isEmpty() || zooAnimals.size() < 4) {
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
        int index3;
        do {
            index3 = random.nextInt(zooAnimals.size());
        } while (index3 == index2 || index3 == index1);
        int index4;
        do {
            index4 = random.nextInt(zooAnimals.size());
        } while (index4 == index1 || index4 == index2 || index4 == index3);

        Animal animal1Or2 = zooAnimals.get(index1);
        Animal animal1or2 = zooAnimals.get(index2);
        Animal benchedAnimals = zooAnimals.get(index3);
        Animal benchedAnimals2 = zooAnimals.get(index4);

        Animal[] selectedAnimals = new Animal[]{animal1Or2, animal1or2, benchedAnimals, benchedAnimals2};
        System.out.println("Battle: " + ANSI_BLUE + selectedAnimals[0].getName() + " and " + selectedAnimals[2].getName()
                + ANSI_RESET + " vs " + ANSI_RED + selectedAnimals[1].getName() + " and " + selectedAnimals[3].getName()
                + ANSI_RESET);

        fight(selectedAnimals[0], selectedAnimals[1], selectedAnimals[2], selectedAnimals[3]);
        return true;
    }

    public void attack(Animal attacker, Animal defender) {

        int pDamage = attacker.getStrength();
        int opDefense = defender.getDefense();

        int dmgTaken = opDefense - pDamage;
        int dmgOutput = 0;

        if (dmgTaken < 0) {
            defender.setHealth(defender.getHealth() + dmgTaken);
            dmgOutput = Math.abs(dmgTaken);
        }
        System.out.println(attacker.getName() + " inflicts " + dmgOutput + " dmg to " + defender.getName());
        System.out.println("health: " + defender.getHealth());
    }

    public void newheal(Animal animal1Or2) {
        System.out.println(animal1Or2.getMaxHealth());
        System.out.println(animal1Or2.getHealth());
        int heal = 20;
        if (animal1Or2.getMaxHealth() <= animal1Or2.getHealth()) {
            System.out.println("You can't heal because your health has already reached its max!");
            return;
        } else {
            int newHealth = Math.min(animal1Or2.getMaxHealth(), animal1Or2.getHealth() + heal);
            int actualHeal = newHealth - animal1Or2.getHealth();
            animal1Or2.setHealth(newHealth);
            System.out.println(ANSI_GREEN + animal1Or2.getName() + " healed for " + actualHeal + " health." + ANSI_RESET);
            System.out.println(animal1Or2.getHealth());
        }
    }

    public void newPowerUp(Animal animal1Or2) {
        System.out.println("the previous strength: " + animal1Or2.getStrength());
        System.out.println();

        int currentStrength = animal1Or2.getStrength();
        double strengthMultiplier = currentStrength * 0.2;
        double strengthMutiplied = currentStrength + strengthMultiplier;

        currentStrength = (int) strengthMutiplied;
        animal1Or2.setStrength(currentStrength);

        System.out.println(ANSI_YELLOW + animal1Or2.getName() + " has its strength increased to " + currentStrength + ANSI_RESET);
    }

    public Animal[] switchAnimal(Animal oldAnimal, Animal newAnimal) {

        Animal[] switchedAnimalsArray = new Animal[2];
        switchedAnimalsArray[0] = newAnimal;
        switchedAnimalsArray[1] = oldAnimal;

        return switchedAnimalsArray;
//
//        int switchedStrength = oldAnimal.getStrength();
//        int switchedHealth = oldAnimal.getHealth();
//        int switchedDefense = oldAnimal.getDefense();
//        String switchedName = oldAnimal.getName();
//        String switchedIcon = oldAnimal.getIcon();
//
//        oldAnimal.setStrength(newAnimal.getStrength());
//        oldAnimal.setHealth(newAnimal.getHealth());
//        oldAnimal.setDefense(newAnimal.getDefense());
//        oldAnimal.setIcon(newAnimal.getIcon());
//
//        newAnimal.setStrength(switchedStrength);
//        newAnimal.setHealth(switchedHealth);
//        newAnimal.setDefense(switchedDefense);
//        newAnimal.setIcon(switchedIcon);
//
//        System.out.println(ANSI_CYAN + oldAnimal.getName() + " has been switched with " + newAnimal.getName() + ANSI_RESET);
//
//        oldAnimal.setName(newAnimal.getName());
//        newAnimal.setName(switchedName);
//
//        int switchedMaxHealth = oldAnimal.getMaxHealth();
//        oldAnimal.setMaxHealth(newAnimal.getMaxHealth());
//        newAnimal.setMaxHealth(switchedMaxHealth);


    }


    public void endGame(Animal animal1, Animal animal2, Animal animal3, Animal animal4) {
        System.out.println();
        System.out.println("Game Over!");
        if (animal1.getHealth() <= 0 && animal3.getHealth() <= 0) {
            System.out.println(animal2.getName() + " and " + animal4.getName() + " win!");
        } else {
            System.out.println(animal1.getName() + " and " + animal3.getName() + " win!");
        }
    }

    public void drawHealthBar(Animal animal) {
        int barLength = 20;
        double healthBarFill = ((double) animal.getHealth() / animal.getMaxHealth()) * barLength;

        System.out.print("Health: [");

        for (int i = 0; i < barLength; i++) {
            if (i < healthBarFill) {
                System.out.print("\uD83D\uDFE9");
            } else {
                System.out.print("\uD83D\uDFE5");
            }
        }

        System.out.print("] " + animal.getHealth() + "/" + animal.getMaxHealth());
    }

    public Animal[] animalFainted(Animal animalFainted, Animal benchedAnimal) {
        System.out.println();
        System.out.println(ANSI_RED + animalFainted.getName() + " has been fainted!" + ANSI_RESET);
        System.out.println();
        Animal[] whichAnimalFainted = switchAnimal(animalFainted, benchedAnimal);
        animalFainted = whichAnimalFainted[0];
        benchedAnimal = whichAnimalFainted[1];

        return whichAnimalFainted;
    }

    public void displayAnimalStats(Animal animal) {
        System.out.println(animal.getIcon() + " " + animal.getName() + " stats: " + " ⚔\uFE0F: " + animal.getStrength() + " \uD83D\uDEE1\uFE0F: " + animal.getDefense() + " \uD83C\uDFC3: " + animal.getSpeed() + " \uD83D\uDE36\u200D\uD83C\uDF2B\uFE0F: " + animal.getCounter());
    }

    public void battleAction(Animal attacker, Animal defender) {
        System.out.println("--------------------------------------");
        displayAnimalStats(attacker);
        drawHealthBar(attacker);
        System.out.println();
        System.out.println();
        displayAnimalStats(defender);
        drawHealthBar(defender);
        System.out.println();
        System.out.println();
    }

    public void setActionChoice(int choice) {
        setTeam1ActionChoice(choice);
    }

    public Animal[] actionPhase(Animal team1Active, Animal team2Active, Animal team1Benched, Animal team2Benched) {
        getTeam1ActionChoice();

        switch (team1ActionChoice) {
            case 1 -> executeSmokesBasedOnPercentage(team1Active, team2Active);
            case 2 -> newheal(team1Active);
            case 3 -> newPowerUp(team1Active);
            case 4 -> newIncreaseCounterForSmokesScreen(team1Active);
            case 5 -> {
                Animal[] switchedAnimalsArray = switchAnimal(team1Active, team1Benched);
                team1Active = switchedAnimalsArray[0];
                team1Benched = switchedAnimalsArray[1];
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
        switch (team2ActionChoice) {
            case 1 -> executeSmokesBasedOnPercentage(team2Active, team1Active);
            case 2 -> newheal(team2Active);
        }
        Animal[] animalPositions = new Animal[4];
        animalPositions[0] = team1Active;
        animalPositions[1] = team2Active;
        animalPositions[2] = team1Benched;
        animalPositions[3] = team2Benched;
        return animalPositions;

    }

    public void fightInput(Animal attacker, Animal defender, Animal benchedAnimal) {
        System.out.println("choose 1 option for " + attacker.getName());
        System.out.println("1. attack");
        System.out.println("2. heal");
        System.out.println("3. power up");
        System.out.println("4. set smokes");
        System.out.println("5. switch animals");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int actionGame = 0;
        try {
            actionGame = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("You must input a number!");
        }
        switch (actionGame) {
            case 1 -> setActionChoice(1);
            case 2 -> setActionChoice();
            case 3 -> setActionChoice();
            case 4 -> setActionChoice();
            case 5 -> setActionChoice();
            default -> System.out.println("Invalid choice. Please try again.");
        }

    }

    public void fight(Animal animal1, Animal animal2, Animal animal3, Animal animal4) {
        if (animal1 == null || animal2 == null) {
            return;
        } else {
            animal1.setMaxHealth(animal1.getHealth());
            animal2.setMaxHealth(animal2.getHealth());
            animal3.setMaxHealth(animal3.getHealth());
            animal4.setMaxHealth(animal4.getHealth());


            while (animal1.getHealth() > 0 || animal2.getHealth() > 0) {
                // before battle phase
                battleAction(animal1, animal2);

                // fight input team 1
                fightInput(animal1, animal2, animal3);
                // fight input team 2
                fightInput(animal2, animal1, animal4);

                // battle phase
                Animal[] myUpdatedAnimalArray = actionPhase(animal1, animal2, animal3, animal4);
                animal1 = myUpdatedAnimalArray[0];
                animal2 = myUpdatedAnimalArray[1];
                animal3 = myUpdatedAnimalArray[2];
                animal4 = myUpdatedAnimalArray[3];

                // after battle phase
                if ((animal1.getHealth() <= 0 && animal3.getHealth() <= 0) || (animal2.getHealth() <= 0 && animal4.getHealth() <= 0)) {
                    endGame(animal1, animal2, animal3, animal4);
                    return;
                } else if (animal1.getHealth() <= 0) {
                    Animal[] updateFaintedAnimal = animalFainted(animal1, animal3);
                    animal1 = updateFaintedAnimal[0];
                    animal3 = updateFaintedAnimal[1];
                } else if (animal2.getHealth() <= 0) {
                    Animal[] updateFaintedAnimal = animalFainted(animal2, animal4);
                    animal2 = updateFaintedAnimal[0];
                    animal4 = updateFaintedAnimal[1];
                }
            }
        }
    }

    public int getTeam1ActionChoice() {
        return team1ActionChoice;
    }

    public void setTeam1ActionChoice(int team1ActionChoice) {
        this.team1ActionChoice = team1ActionChoice;
    }

    public int getTeam2ActionChoice() {
        return team2ActionChoice;
    }

    public void setTeam2ActionChoice(int team2ActionChoice) {
        this.team2ActionChoice = team2ActionChoice;
    }
}