package my.factory.abstractfactory;

import my.factory.Apple;
import my.factory.IFruits;

public class AppleFactorty implements IFruitFactory {
    public IFruits createFruit() {
        return new Apple();
    }

    public IEnergy createEnergy() {
        return new AppleEnergy();
    }

    public IMoisture createMoisture() {
        return new AppleMoisture();
    }
}
