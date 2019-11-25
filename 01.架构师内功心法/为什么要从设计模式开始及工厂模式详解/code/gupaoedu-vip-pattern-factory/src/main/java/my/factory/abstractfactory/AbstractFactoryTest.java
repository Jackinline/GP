package my.factory.abstractfactory;

import my.factory.IFruits;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IFruitFactory factory = new AppleFactorty();
        IFruits fruit = factory.createFruit();
        IEnergy energy = factory.createEnergy();
        IMoisture moisture = factory.createMoisture();
        fruit.eat();
        energy.getEnergy();
        moisture.getMoistur();

        factory = new OrangeFactory();
        fruit = factory.createFruit();
        energy = factory.createEnergy();
        moisture = factory.createMoisture();
        fruit.eat();
        energy.getEnergy();
        moisture.getMoistur();

    }

}
