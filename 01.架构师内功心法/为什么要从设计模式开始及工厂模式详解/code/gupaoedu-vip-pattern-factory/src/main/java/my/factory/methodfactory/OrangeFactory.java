package my.factory.methodfactory;


import my.factory.IFruits;
import my.factory.Orange;

public class OrangeFactory implements IFruitFactory{
    public IFruits getFruit() {
        return new Orange();
    }
}
