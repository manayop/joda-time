package org.joda.time;

import org.joda.time.tz.Provider;
import org.joda.time.tz.ZoneInfoProvider;

import java.io.File;

public class DateTimeZoneFolderProvider extends DateTimeZoneAbstractProvider {

    public Provider getProvider() {
        try {
            String dataFolder = System.getProperty("org.joda.time.DateTimeZone.Folder");
            if (dataFolder != null) {
                try {
                    Provider provider = new ZoneInfoProvider(new File(dataFolder));
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
