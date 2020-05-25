package com;

import java.util.Locale;

public class SetLocale {
    private static Locale locale;

    /**
     * Seteaza limba engleza by default.
     */
    public SetLocale() {
        locale = Locale.ENGLISH;
    }

    /**
     * Seteaza limba romana daca primeste ca parametru RO sau ro.
     * @param language
     */
    public void setLocaleFunction(String language) {
        if (language.equals("RO") || language.equals("ro")) {
            locale = Locale.forLanguageTag("ro-RO");
        } else {
            locale = Locale.getDefault();
        }
    }

    /**
     * Returneaza locatia.
     * @return locale
     */
    public static Locale getLocale() {
        return locale;
    }
}
