package my.factory.abstractfactory;


import my.factory.IFruits;
import my.factory.Orange;

public class OrangeFactory implements IFruitFactory {
    public IFruits createFruit() {
        return new Orange();
    }

    public IEnergy createEnergy() {
        return new OrangeEnergy();
    }

    public IMoisture createMoisture() {
        return new OrangeMoisture();
    }
}
