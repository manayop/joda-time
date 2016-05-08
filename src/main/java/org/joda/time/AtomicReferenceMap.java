package org.joda.time;

import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by manayop on 9/05/16.
 */
public class AtomicReferenceMap {

    private static final int DEFAULT = 1;
    private static final int PROVIDER = 2;
    private static final int NAME_PROVIDER = 3;

    private HashMap<Integer, AtomicReference> map;

    public AtomicReferenceMap() {
        map = new HashMap<Integer, AtomicReference>();
        map.put(DEFAULT,new AtomicReference<DateTimeZone>());
        map.put(PROVIDER, new AtomicReference<Provider>());
        map.put(NAME_PROVIDER,new AtomicReference<NameProvider>());
    }

    public DateTimeZone getDefault()
    {
        return (DateTimeZone) get(DEFAULT);
    }

    public void setDefault(DateTimeZone zone)
    {
        set(DEFAULT,zone);
    }

    public boolean compareAndSetDefault(DateTimeZone expected,DateTimeZone zone)
    {
         return compareAndSet(DEFAULT,expected,zone);
    }

    public Provider getProvider()
    {
        return (Provider) get(PROVIDER);
    }

    public void setProvider(Provider provider)
    {
        set(PROVIDER,provider);
    }

    public boolean compareAndSetProvider(Provider expected,Provider provider)
    {
         return compareAndSet(PROVIDER,expected,provider);
    }

    public NameProvider getNameProvider()
    {
        return (NameProvider) get(NAME_PROVIDER);
    }

    public void setNameProvider(NameProvider provider)
    {
        set(NAME_PROVIDER,provider);
    }

    public boolean compareAndSetNameProvider(NameProvider expected,NameProvider provider)
    {
         return compareAndSet(NAME_PROVIDER,expected,provider);
    }

    private Object get(Integer type)
    {
        return map.get(type).get();
    }

    private boolean compareAndSet(Integer type, Object expected, Object update)
    {
        return map.get(type).compareAndSet(expected,update);
    }

    private void set(Integer type, Object value)
    {
        map.get(type).set(value);
    }



}
