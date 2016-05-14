package org.joda.time;

import org.joda.time.tz.Provider;

public interface DateTimeZoneProviderChainInterface {

    Provider getProvider();
    DateTimeZoneProviderChainInterface getNext();
    void setNext(DateTimeZoneProviderChainInterface next);

}
