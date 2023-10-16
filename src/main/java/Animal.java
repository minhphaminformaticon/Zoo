
    public abstract class Animal {
        String name;
        int age;
        String icon;
        String animal;
        int health;
        int strength;

        int defense;
        public Animal(String name, int age, int strength, int health, int defense) {
            this.name = name;
            this.age = age;
            this.strength = strength;
            this.health = health;
            this.defense = defense;
        }
        public String getAnimal(){return animal;}

        public abstract void makeSound();

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getIcon() {
            return icon;
        }
        public abstract void action();

        public abstract void attributes();

        public int getHealth(){
            return health;
        }
        public int getStrength(){
            return strength;
        }
        public int getDefense(){
            return defense;
        }
    }


