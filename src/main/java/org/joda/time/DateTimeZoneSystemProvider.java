package org.joda.time;

import org.joda.time.tz.Provider;

public class DateTimeZoneSystemProvider extends DateTimeZoneAbstractProvider {

    public Provider getProvider() {
        try {
            String providerClass = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (providerClass != null) {
                try {
                    Provider provider = (Provider) Class.forName(providerClass).newInstance();
                    return ProviderValidator.validateProvider(provider);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (SecurityException ex) {
            // ignored
        }

        return next.getProvider();
    }
}
