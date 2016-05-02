package org.joda.time;

import java.util.HashMap;

public class Pool {

    private enum Types {
        YEAR, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND
    }

    private static Pool myInstance;
    private HashMap<Types, HashMap<Integer, Object>> flexiblePool;

    private Pool()
    {
        this.flexiblePool = new HashMap<Types, HashMap<Integer, Object>>();
    }

    public static Pool getInstance()
    {
        if (myInstance == null) {
            myInstance = new Pool();
        }

        return myInstance;
    }

    public static Years retrieveYears(int numeral)
    {
        Pool pool = Pool.getInstance();

        Object result = pool.getYears(numeral);

        if (result == null) {
            result =  new Years(numeral);
            pool.addYears(numeral, (Years) result);
        }

        return (Years) result;
    }

    public static Months retrieveMonths(int numeral)
    {
        Pool pool = Pool.getInstance();

        Object result = pool.getMonths(numeral);

        if (result == null) {
            result =  new Months(numeral);
            pool.addMonths(numeral, (Months) result);
        }

        return (Months) result;
    }

    public static Weeks retrieveWeeks(int numeral)
    {
        Pool pool = Pool.getInstance();

        Object result = pool.getWeeks(numeral);

        if (result == null) {
            result =  new Weeks(numeral);
            pool.addWeeks(numeral, (Weeks) result);
        }

        return (Weeks) result;
    }


    public static Hours retrieveHours(int numeral)
    {
        Pool pool = Pool.getInstance();

        Object result = pool.getHours(numeral);

        if (result == null) {
            result =  new Hours(numeral);
            pool.addHours(numeral, (Hours) result);
        }

        return (Hours) result;
    }

    public static Days retrieveDays(int numeral)
    {
        Pool pool = Pool.getInstance();

        Object result = pool.getDays(numeral);

        if (result == null) {
            result =  new Days(numeral);
            pool.addDay(numeral, (Days) result);
        }

        return (Days) result;
    }

    public static Seconds retrieveSeconds(int numeral) {
        Pool pool = Pool.getInstance();

        Object result = pool.getSeconds(numeral);

        if (result == null) {
            result =  new Seconds(numeral);
            pool.addSeconds(numeral, (Seconds) result);
        }

        return (Seconds) result;
    }

    public static Minutes retrieveMinutes(int numeral)
    {

        Pool pool = Pool.getInstance();

        Object result = pool.getMinutes(numeral);

        if (result == null) {
            result =  new Minutes(numeral);
            pool.addMinutes(numeral, (Minutes) result);
        }

        return (Minutes) result;
    }

    private void addObject(Types type, int numeral, Object object)
    {
        HashMap<Integer, Object> typePool = flexiblePool.get(type);
        if (null == typePool){
            typePool = new HashMap<Integer, Object>();
            flexiblePool.put(type,typePool);
        }

        typePool.put(numeral,object);
    }

    private Object getObject(Types type, int numeral)
    {
        HashMap<Integer, Object> typePool = flexiblePool.get(type);
        if (null == typePool){
            return null;
        }

        return typePool.get(numeral);
    }

    private void addYears(int numeral, Years year)
    {
        addObject(Types.YEAR, numeral, year);
    }

    private void addMonths(int numeral, Months month)
    {
        addObject(Types.MONTH, numeral, month);
    }

    private void addWeeks(int numeral, Weeks week)
    {
        addObject(Types.WEEK, numeral, week);
    }

    private void addDay(int numeral, Days day)
    {
        addObject(Types.DAY, numeral, day);
    }

    private void addHours(int numeral, Hours hour)
    {
        addObject(Types.HOUR, numeral, hour);
    }

    private void addSeconds(int numeral, Seconds second)
    {
        addObject(Types.SECOND, numeral, second);
    }

    private void addMinutes(int numeral, Minutes minute)
    {
        addObject(Types.MINUTE, numeral, minute);
    }

    private Object getYears(int numeral)
    {
        return getObject(Types.YEAR,numeral);
    }

    private Object getMonths(int numeral)
    {
        return getObject(Types.MONTH,numeral);
    }

    private Object getWeeks(int numeral)
    {
        return getObject(Types.WEEK,numeral);
    }

    private Object getDays(int numeral)
    {
        return getObject(Types.DAY,numeral);
    }

    private Object getHours(int numeral)
    {
        return getObject(Types.HOUR,numeral);
    }

    private Object getMinutes(int numeral)
    {
        return getObject(Types.MINUTE,numeral);
    }

    private Object getSeconds(int numeral)
    {
        return getObject(Types.SECOND,numeral);
    }

}
