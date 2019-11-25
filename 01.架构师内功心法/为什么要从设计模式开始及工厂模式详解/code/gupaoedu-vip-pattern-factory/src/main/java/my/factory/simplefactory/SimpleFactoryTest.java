package my.factory.simplefactory;

import my.factory.Apple;
import my.factory.IFruits;
import my.factory.Orange;

public class SimpleFactoryTest {

    public static void main(String[] args) {
        FruitsFactory factory = new FruitsFactory();
        IFruits fruits = factory.getFruits(Apple.class);
        fruits.eat();
        fruits = factory.getFruits(Orange.class);
        fruits.eat();
    }
}
