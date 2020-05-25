package com;

import java.util.Locale;

public class DisplayLocales{
    /**
     * Returneaza locatiile valabile.
     * @param setLocale
     */
    public static void getLocales(Locale setLocale) {
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale locale = new Locale("", countryCode);
            System.out.println(locale.getDisplayCountry() + " - " + locale.getCountry());
        }
    }
}
