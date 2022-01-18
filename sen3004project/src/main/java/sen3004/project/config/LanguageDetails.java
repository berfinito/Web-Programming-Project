package sen3004.project.config;

import java.util.Locale;

public class LanguageDetails {
    private static String locale = Locale.getDefault().getDisplayLanguage();

    public void setLocale(String locale1) {
        LanguageDetails.locale = locale1;
    }

    public synchronized String getLocale() {
        return LanguageDetails.locale;
    }

    public synchronized String changeLanguage() {
        return "changed";
    }
}
