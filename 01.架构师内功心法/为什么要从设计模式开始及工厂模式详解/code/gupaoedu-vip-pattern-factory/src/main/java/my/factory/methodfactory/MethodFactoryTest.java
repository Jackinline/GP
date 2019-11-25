package my.factory.methodfactory;

import my.factory.Apple;
import my.factory.IFruits;
import my.factory.Orange;

public class MethodFactoryTest {
    public static void main(String[] args) {
        AppleFactorty appleFac = new AppleFactorty();
        IFruits fruit = appleFac.getFruit();
        fruit.eat();
        OrangeFactory orangeFac = new OrangeFactory();
        fruit = orangeFac.getFruit();
        fruit.eat();
    }
}
