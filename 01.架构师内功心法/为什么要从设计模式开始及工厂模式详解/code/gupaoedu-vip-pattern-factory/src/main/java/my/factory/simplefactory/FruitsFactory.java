package my.factory.simplefactory;

import my.factory.IFruits;

public class FruitsFactory {
    public IFruits getFruits(Class<? extends IFruits> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
