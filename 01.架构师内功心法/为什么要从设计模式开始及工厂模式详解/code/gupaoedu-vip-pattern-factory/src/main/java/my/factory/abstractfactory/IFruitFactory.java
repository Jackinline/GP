package my.factory.abstractfactory;

import my.factory.IFruits;

public interface IFruitFactory {
    IFruits createFruit();
    IEnergy createEnergy();
    IMoisture createMoisture();
}
