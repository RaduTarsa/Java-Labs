package com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.*;

public class Info {
    /**
     * Afiseaza informatiile.
     * @param locale
     */
    public static void showInfo(Locale locale) {
        showCountry(locale);
        showLanguage(locale);
        showCurrency(locale);
        showWeekDays(locale);
        showMonths(locale);
        showDate(locale);
    }

    /**
     * Afiseaza tara.
     * @param locale
     */
    public static void showCountry(Locale locale) {
        System.out.println(locale.getDisplayCountry());
    }

    /**
     * Afiseaza limba.
     * @param locale
     */
    public static void showLanguage(Locale locale) {
        System.out.println(locale.getDisplayLanguage());
    }

    /**
     * Afiseaza moneda/bancnota folosita de tara respectiva.
     * @param locale
     */
    public static void showCurrency(Locale locale) {
        System.out.println(Currency.getInstance(locale).getDisplayName());
    }

    /**
     * Afiseaza zilele saptamanii.
     * @param locale
     */
    public static void showWeekDays(Locale locale) {
        String[] weekDays = new DateFormatSymbols(locale).getWeekdays();
        String[] tmp = Arrays.copyOfRange(weekDays, 1, weekDays.length);
        String sunday;
        for(int i = 0; i < tmp.length - 1; i++){
            sunday = tmp[i];
            tmp[i] = tmp[i+1];
            tmp[i+1] = sunday;
        }
        System.out.println(Arrays.toString(tmp));
    }

    /**
     * Afiseaza lunile.
     * @param locale
     */
    public static void showMonths(Locale locale) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] months = dateFormatSymbols.getMonths();
        String[] tmp = Arrays.copyOfRange(months, 0, months.length - 1);
        System.out.println(Arrays.toString(tmp));
    }

    /**
     * Afiseaza data.
     * @param locale
     */
    public static void showDate(Locale locale) {
        System.out.println(DateFormat.getDateInstance(DateFormat.LONG, locale).format(new Date()));
    }
}
