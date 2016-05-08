package org.joda.time;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BaseSingleFieldPeriodPool {

    private static BaseSingleFieldPeriodPool myInstance;
    private HashMap<Class, HashMap<Integer, Object>> flexiblePool;

    private BaseSingleFieldPeriodPool()
    {
        this.flexiblePool = new HashMap<Class, HashMap<Integer, Object>>();
    }

    public static BaseSingleFieldPeriodPool getInstance()
    {
        if (myInstance == null) {
            myInstance = new BaseSingleFieldPeriodPool();
        }

        return myInstance;
    }

    public static Object retrieve(Class type, int numeral)
    {
        BaseSingleFieldPeriodPool pool = BaseSingleFieldPeriodPool.getInstance();

        Object result = pool.get(type,numeral);

        if (result == null) {
            try {
                result = type.getDeclaredConstructor(int.class).newInstance(numeral);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


            pool.add(type, numeral, result);
        }

        return result;
    }

    private void addObject(Class type, int numeral, Object object)
    {
        HashMap<Integer, Object> typePool = flexiblePool.get(type);
        if (null == typePool){
            typePool = new HashMap<Integer, Object>();
            flexiblePool.put(type,typePool);
        }

        typePool.put(numeral,object);
    }

    private Object getObject(Class type, int numeral)
    {
        HashMap<Integer, Object> typePool = flexiblePool.get(type);
        if (null == typePool){
            return null;
        }

        return typePool.get(numeral);
    }

    private void add(Class type,int numeral, Object object)
    {
        addObject(type, numeral, object);
    }

    private Object get(Class type, int numeral)
    {
        return getObject(type,numeral);
    }

}
