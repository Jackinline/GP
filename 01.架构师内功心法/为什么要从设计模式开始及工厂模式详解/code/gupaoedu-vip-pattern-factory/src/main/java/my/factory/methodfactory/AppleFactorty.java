package my.factory.methodfactory;

import my.factory.Apple;
import my.factory.IFruits;

public class AppleFactorty implements IFruitFactory{
    public IFruits getFruit() {
        return new Apple();
    }
}
