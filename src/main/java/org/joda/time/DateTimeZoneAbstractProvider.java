package org.joda.time;

import org.joda.time.tz.Provider;


public abstract class DateTimeZoneAbstractProvider implements DateTimeZoneProviderChainInterface {

    protected DateTimeZoneProviderChainInterface next;

    public abstract Provider getProvider();

    public DateTimeZoneProviderChainInterface getNext() {
        return this.next;
    }

    public void setNext(DateTimeZoneProviderChainInterface next) {
        this.next = next;
    }
}
