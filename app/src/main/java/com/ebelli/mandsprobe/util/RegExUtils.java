package com.ebelli.mandsprobe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class For the Regular Expressions.
 *
 */
public class RegExUtils {

    public static boolean applyRegEx(String prefix, String phoneExpn) {
        Pattern patternObj = Pattern.compile(phoneExpn);
        Matcher matcherObj = patternObj.matcher(prefix);
        return matcherObj.matches();
    }
}
