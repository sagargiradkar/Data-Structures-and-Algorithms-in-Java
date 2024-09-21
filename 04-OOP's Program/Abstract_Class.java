
abstract class Animal {
    public abstract void makeSound(); // Abstract method

    public void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Abstract_Class {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.makeSound();
        c.eat();
    }
}
