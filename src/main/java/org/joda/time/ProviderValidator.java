package org.joda.time;

import org.joda.time.tz.Provider;

import java.util.Set;

public class ProviderValidator {

    public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;


    public static Provider validateProvider(Provider provider) {
        Set<String> ids = provider.getAvailableIDs();
        if (ids == null || ids.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        }
        if (!ids.contains("UTC")) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        }
        if (!UTC.equals(provider.getZone("UTC"))) {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
        return provider;
    }

}
