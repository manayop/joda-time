package org.joda.time;

import org.joda.time.tz.Provider;
import org.joda.time.tz.UTCProvider;

public class DateTimeZoneMainProvider extends DateTimeZoneAbstractProvider {

    public Provider getProvider() {

        DateTimeZoneProviderChainInterface provider = new DateTimeZoneSystemProvider();

        DateTimeZoneProviderChainInterface folderProvider = new DateTimeZoneFolderProvider();
        provider.setNext(folderProvider);

        DateTimeZoneProviderChainInterface defaultFolderProvider = new DateTimeZoneDefaultFolderProvider();
        folderProvider.setNext(defaultFolderProvider);

        DateTimeZoneProviderChainInterface endChain = new DateTimeZoneProviderEndChain();
        defaultFolderProvider.setNext(endChain);


        Provider result  = provider.getProvider();
        if (null == result){
            result = new UTCProvider();
        }

        return result;
    }
}
