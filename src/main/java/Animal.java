
    public abstract class Animal {
        String name;
        int age;
        String icon;

        String animal;


        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
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

        public abstract void atributes();

    }


