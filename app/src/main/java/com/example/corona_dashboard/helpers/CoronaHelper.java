package com.example.corona_dashboard.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class CoronaHelper {
    private static String[] notAvailableCountries = {
            "AQ","AX","AS","BV","CC","CK","CX","FM","GS","GU","GG","HM",
            "IO","KI","KP","MH","MP","NF","NU","NR","PN","PR","PW","SB",
            "SH","SJ","SP","TF","TM","TK","TV","TO","UM","VI","WF","VU",
            "WS","ZG"
    };

    /**
     * This method generates a list with all available countries
     * @return List of available counties
     */
    public static ArrayList<String> getCountryCodes(){
        ArrayList<String> countries = new ArrayList<>(Arrays.asList(Locale.getISOCountries()));
        countries.removeAll(Arrays.asList(notAvailableCountries));
        return countries;
    }
}
