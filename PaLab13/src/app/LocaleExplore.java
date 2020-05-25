package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    /**
     * Functia main care verifica stringul primit si apeleaza functia respectiva.
     * @param args
     */
    public static void main(String[] args) {
        SetLocale setLocale = new SetLocale();
        setLocale.setLocaleFunction("EN");
        String command;
        Scanner scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res/Messages", setLocale.getLocale());

        while (true) {
            System.out.println(resourceBundle.getString("prompt"));
            command = scanner.nextLine();
            switch (command) {
                case "locales":
                    localesCommand(resourceBundle, setLocale);
                    break;
                case "locale.set":
                    setLocale = localeSetCommand(resourceBundle, setLocale);
                    resourceBundle = ResourceBundle.getBundle("res/Messages", setLocale.getLocale());
                    break;
                case "info":
                    infoCommand(resourceBundle, setLocale);
                    break;
                default:
                    System.out.println(resourceBundle.getString("invalid"));
                    break;
            }
        }
    }

    /**
     * Functia care afiseaza locatiile valabile.
     * @param resourceBundle
     * @param setLocale
     */
    public static void localesCommand(ResourceBundle resourceBundle, SetLocale setLocale) {
        System.out.println(resourceBundle.getString("locales"));
        DisplayLocales.getLocales(SetLocale.getLocale());
    }

    /**
     * Functia care seteaza locatia.
     * @param resourceBundle
     * @param setLocale
     * @return setLocale
     */
    public static SetLocale localeSetCommand(ResourceBundle resourceBundle, SetLocale setLocale) {
        Scanner scanner = new Scanner(System.in);
        String locale;
        MessageFormat messageFormat = new MessageFormat(resourceBundle.getString("locale.set"));
        System.out.println(messageFormat.format(new Object[]{setLocale.getLocale()}));
        locale = scanner.nextLine();
        setLocale.setLocaleFunction(locale);
        return setLocale;
    }

    /**
     * Functia care afiseaza informatiile aferente ale locatiei setate ca parametru.
     * @param resourceBundle
     * @param setLocale
     */
    public static void infoCommand(ResourceBundle resourceBundle, SetLocale setLocale) {
        MessageFormat messageFormat = new MessageFormat(resourceBundle.getString("info"));
        System.out.println(messageFormat.format(new Object[]{setLocale.getLocale()}));
        Info.showInfo(setLocale.getLocale());
    }
}