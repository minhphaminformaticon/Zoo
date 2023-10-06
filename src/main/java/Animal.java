
    public abstract class Animal {
        String name;
        int age;
        String icon;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

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


