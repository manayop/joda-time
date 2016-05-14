package org.joda.time;

import org.joda.time.tz.Provider;
import org.joda.time.tz.ZoneInfoProvider;

public class DateTimeZoneDefaultFolderProvider extends DateTimeZoneAbstractProvider {

    public Provider getProvider() {
        try {
            Provider provider = new ZoneInfoProvider("org/joda/time/tz/data");
            return ProviderValidator.validateProvider(provider);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return next.getProvider();
    }
}
