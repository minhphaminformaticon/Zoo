package com.informaticon.java.tutorial.zoo.miph;

import java.util.Random;
import java.util.List;
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

    public boolean mainFunction;

    Random countR = new Random();

    // class variables with active or benched states for team 1 & 2
    private Animal team1Active;
    private Animal team1Benched;
    private Animal team2Active;
    private Animal team2Benched;


    public Game() {
        mainFunction = true;
    }

    public void newIncreaseCounterForSmokesScreen(Animal animal1Or2) {
        animal1Or2.setCounter(animal1Or2.getCounter() + 1);
        System.out.println(animal1Or2.getName() + " has increased its smokescounter to: " + animal1Or2.getCounter());
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
        System.out.println("Battle: " + ANSI_BLUE + selectedAnimals[0].getName() + " & " + selectedAnimals[2].getName()
                + ANSI_RESET + " vs " + ANSI_RED + selectedAnimals[1].getName() + " & " + selectedAnimals[3].getName()
                + ANSI_RESET);

        team1Active = selectedAnimals[0];
        team1Benched = selectedAnimals[2];
        team2Active = selectedAnimals[1];
        team2Benched = selectedAnimals[3];

        fight(team1Active, team2Active, team1Benched, team2Benched);

        return false;
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
        attacker.setStrength(attacker.getOriginalStrength());
        defender.setDefense(defender.getOriginalDefense());
        System.out.println(ANSI_RED + attacker.getName() + " inflicts " + dmgOutput + " dmg to " + defender.getName() +
                ANSI_RESET);
        System.out.println("health: " + defender.getHealth());
    }

    public void newHeal(Animal animal1Or2) {
        Random random = new Random();
        System.out.println(animal1Or2.getMaxHealth());
        System.out.println(animal1Or2.getHealth());
        int heal = random.nextInt(10, 100);
        ;
        if (animal1Or2.getMaxHealth() <= animal1Or2.getHealth()) {
            System.out.println("You can't heal because your health has already reached its max!");
            return;
        } else {
            int newHealth = Math.min(animal1Or2.getMaxHealth(), animal1Or2.getHealth() + heal);
            int actualHeal = newHealth - animal1Or2.getHealth();
            animal1Or2.setHealth(newHealth);
            System.out.println(animal1Or2.getName() + " healed for " + actualHeal + " health.");
            System.out.println(animal1Or2.getHealth());
        }
    }

    public void newPowerUp(Animal animal1Or2) {
        System.out.println("the previous strength: " + animal1Or2.getStrength());
        System.out.println();
        Random random = new Random();
        double randomMultiplier = random.nextDouble();
        int currentStrength = animal1Or2.getStrength();
        double strengthMultiplier = currentStrength * (randomMultiplier);
        double strengthMultiplied = currentStrength + strengthMultiplier;

        currentStrength = (int) strengthMultiplied;
        animal1Or2.setStrength(currentStrength);

        System.out.println(animal1Or2.getName() + " has its strength increased to " + currentStrength);
    }

    public void newDefenseUp(Animal animal1Or2) {
        System.out.println("the previous strength: " + animal1Or2.getDefense());
        System.out.println();
        Random random = new Random();
        double randomMultiplier = random.nextDouble();
        int currentDefense = animal1Or2.getDefense();
        double defenseMultiplier = currentDefense * (randomMultiplier);
        double defenseMultiplied = currentDefense + defenseMultiplier;

        currentDefense = (int) defenseMultiplied;
        animal1Or2.setDefense(currentDefense);

        System.out.println(animal1Or2.getName() + " has its defense increased to " + currentDefense);
    }


    public void switchAnimal(Animal oldAnimal, Animal newAnimal) {
        int switchedStrength = oldAnimal.getStrength();
        int switchedHealth = oldAnimal.getHealth();
        int switchedDefense = oldAnimal.getDefense();
        int switchedSpeed = oldAnimal.getSpeed();
        int switchedMaxHealth = oldAnimal.getMaxHealth();
        int switchedOriginalStrength = oldAnimal.getOriginalStrength();
        int switchedOriginalDefense = oldAnimal.getOriginalDefense();
        String switchedName = oldAnimal.getName();
        String switchedIcon = oldAnimal.getIcon();

        oldAnimal.setStrength(newAnimal.getStrength());
        oldAnimal.setHealth(newAnimal.getHealth());
        oldAnimal.setDefense(newAnimal.getDefense());
        oldAnimal.setSpeed(newAnimal.getSpeed());
        oldAnimal.setIcon(newAnimal.getIcon());
        oldAnimal.setMaxHealth(newAnimal.getMaxHealth());
        oldAnimal.setOriginalStrength(newAnimal.getOriginalStrength());
        oldAnimal.setOriginalDefense(newAnimal.getOriginalDefense());

        newAnimal.setStrength(switchedStrength);
        newAnimal.setHealth(switchedHealth);
        newAnimal.setDefense(switchedDefense);
        newAnimal.setSpeed(switchedSpeed);
        newAnimal.setIcon(switchedIcon);
        newAnimal.setMaxHealth(switchedMaxHealth);
        newAnimal.setOriginalStrength(switchedOriginalStrength);
        newAnimal.setOriginalDefense(switchedOriginalDefense);


        System.out.println(oldAnimal.getName() + " has been switched with " + newAnimal.getName());
        oldAnimal.setName(newAnimal.getName());
        newAnimal.setName(switchedName);
    }


    public void endGame(Animal animal1, Animal animal2, Animal animal3, Animal animal4) {
        System.out.println();
        System.out.println("zoo.Game Over!");
        if (animal1.getHealth() <= 0 && animal3.getHealth() <= 0) {
            System.out.println(animal2.getName() + " and " + animal4.getName() + " wins!");
        } else {
            System.out.println(animal1.getName() + " and " + animal3.getName() + " wins!");
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

    public void animalFainted(Animal animalFainted, Animal benchedAnimal) {
        System.out.println();
        System.out.println(animalFainted.getName() + " has been fainted!");
        System.out.println();
        switchAnimal(animalFainted, benchedAnimal);
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

    public void battlePhase(Animal animalTeam1Active, Animal animalTeam2Active, Animal animalTeam1benched, Animal animalTeam2benched) {
        if (animalTeam1Active.getSpeed() > animalTeam2Active.getSpeed()) {
            switch (animalTeam1Active.getActionChoice()) {
                case 1 -> executeSmokesBasedOnPercentage(animalTeam1Active, animalTeam2Active);
                case 2 -> newHeal(animalTeam1Active);
                case 3 -> newPowerUp(animalTeam1Active);
                case 4 -> newDefenseUp(animalTeam1Active);
                case 5 -> newIncreaseCounterForSmokesScreen(animalTeam1Active);
                case 6 -> switchAnimal(animalTeam1Active, animalTeam1benched);
            }
            switch (animalTeam2Active.getActionChoice()) {
                case 1 -> executeSmokesBasedOnPercentage(animalTeam2Active, animalTeam1Active);
                case 2 -> newHeal(animalTeam2Active);
                case 3 -> newPowerUp(animalTeam2Active);
                case 4 -> newDefenseUp(animalTeam2Active);
                case 5 -> newIncreaseCounterForSmokesScreen(animalTeam2Active);
                case 6 -> switchAnimal(animalTeam2Active, animalTeam2benched);
            }
        } else if (animalTeam1Active.getSpeed() < animalTeam2Active.getSpeed()) {
            switch (animalTeam2Active.getActionChoice()) {
                case 1 -> executeSmokesBasedOnPercentage(animalTeam2Active, animalTeam1Active);
                case 2 -> newHeal(animalTeam2Active);
                case 3 -> newPowerUp(animalTeam2Active);
                case 4 -> newDefenseUp(animalTeam2Active);
                case 5 -> newIncreaseCounterForSmokesScreen(animalTeam1Active);
                case 6 -> switchAnimal(animalTeam2Active, animalTeam2benched);
            }
            switch (animalTeam1Active.getActionChoice()) {
                case 1 -> executeSmokesBasedOnPercentage(animalTeam1Active, animalTeam2Active);
                case 2 -> newHeal(animalTeam1Active);
                case 3 -> newPowerUp(animalTeam1Active);
                case 4 -> newDefenseUp(animalTeam1Active);
                case 5 -> newIncreaseCounterForSmokesScreen(animalTeam2Active);
                case 6 -> switchAnimal(animalTeam1Active, animalTeam1benched);
            }
        } else if (animalTeam1Active.getSpeed() == animalTeam2Active.getSpeed()) {
            Random random = new Random();
            int bound = 2;
            int randomChoice = random.nextInt(bound);

            if (randomChoice == 0) {
                switch (animalTeam1Active.getActionChoice()) {
                    case 1 -> executeSmokesBasedOnPercentage(animalTeam1Active, animalTeam2Active);
                    case 2 -> newHeal(animalTeam1Active);
                    case 3 -> newPowerUp(animalTeam1Active);
                    case 4 -> newDefenseUp(animalTeam1Active);
                    case 5 -> newIncreaseCounterForSmokesScreen(animalTeam1Active);
                    case 6 -> switchAnimal(animalTeam1Active, animalTeam1benched);
                }
                switch (animalTeam2Active.getActionChoice()) {
                    case 1 -> executeSmokesBasedOnPercentage(animalTeam2Active, animalTeam1Active);
                    case 2 -> newHeal(animalTeam2Active);
                    case 3 -> newPowerUp(animalTeam2Active);
                    case 4 -> newDefenseUp(animalTeam2Active);
                    case 5 -> newIncreaseCounterForSmokesScreen(animalTeam2Active);
                    case 6 -> switchAnimal(animalTeam2Active, animalTeam2benched);
                }
            } else if (randomChoice == 1) {
                switch (animalTeam2Active.getActionChoice()) {
                    case 1 -> executeSmokesBasedOnPercentage(animalTeam2Active, animalTeam1Active);
                    case 2 -> newHeal(animalTeam2Active);
                    case 3 -> newPowerUp(animalTeam2Active);
                    case 4 -> newDefenseUp(animalTeam2Active);
                    case 5 -> newIncreaseCounterForSmokesScreen(animalTeam1Active);
                    case 6 -> switchAnimal(animalTeam2Active, animalTeam2benched);
                }
                switch (animalTeam1Active.getActionChoice()) {
                    case 1 -> executeSmokesBasedOnPercentage(animalTeam1Active, animalTeam2Active);
                    case 2 -> newHeal(animalTeam1Active);
                    case 3 -> newPowerUp(animalTeam1Active);
                    case 4 -> newDefenseUp(animalTeam1Active);
                    case 5 -> newIncreaseCounterForSmokesScreen(animalTeam1Active);
                    case 6 -> switchAnimal(animalTeam1Active, animalTeam1benched);
                }
            }
        }
    }

    public void fightInput(Animal attacker) {
        System.out.println("choose 1 option for " + attacker.getName());
        System.out.println("1. attack");
        System.out.println("2. heal");
        System.out.println("3. power up");
        System.out.println("4. defense up");
        System.out.println("5. set smokes");
        System.out.println("6. switch animals");
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
            case 1 -> attacker.setActionChoice(actionGame);
            case 2 -> attacker.setActionChoice(actionGame);
            case 3 -> attacker.setActionChoice(actionGame);
            case 4 -> attacker.setActionChoice(actionGame);
            case 5 -> attacker.setActionChoice(actionGame);
            case 6 -> attacker.setActionChoice(actionGame);
            default -> System.out.println("Invalid choice!");
        }
    }

    public void fight(Animal animal1, Animal animal2, Animal animal3, Animal animal4) {

        // work with class variables from here
        //team1Active


        boolean isTurnAnimal1 = true;
        if (animal1 == null || animal2 == null) {
            return;
        } else {
            animal1.setMaxHealth(animal1.getHealth());
            animal2.setMaxHealth(animal2.getHealth());
            animal3.setMaxHealth(animal3.getHealth());
            animal4.setMaxHealth(animal4.getHealth());
            animal1.setOriginalStrength(animal1.getStrength());
            animal2.setOriginalStrength(animal2.getStrength());
            animal3.setOriginalStrength(animal3.getStrength());
            animal4.setOriginalStrength(animal4.getStrength());
            animal1.setOriginalDefense(animal1.getDefense());
            animal2.setOriginalDefense(animal2.getDefense());
            animal3.setOriginalDefense(animal3.getDefense());
            animal4.setOriginalDefense(animal4.getDefense());

            while (animal1.getHealth() > 0 || animal2.getHealth() > 0) {
                if (isTurnAnimal1) {
                    battleAction(animal1, animal2);
                    fightInput(animal1);
                    isTurnAnimal1 = false;
                } else {
                    battleAction(animal2, animal1);
                    fightInput(animal2);
                    battlePhase(animal1, animal2, animal3, animal4);
                    isTurnAnimal1 = true;
                }
                if ((animal1.getHealth() <= 0 && animal3.getHealth() <= 0) || (animal2.getHealth() <= 0 && animal4.getHealth() <= 0)) {
                    endGame(animal1, animal2, animal3, animal4);
                    return;
                } else if (animal1.getHealth() <= 0) {
                    animalFainted(animal1, animal3);
                    isTurnAnimal1 = false;
                } else if (animal2.getHealth() <= 0) {
                    animalFainted(animal2, animal4);
                    isTurnAnimal1 = true;
                }
            }
        }
    }
}