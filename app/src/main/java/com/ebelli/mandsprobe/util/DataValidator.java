package com.ebelli.mandsprobe.util;

/**
 * Class for Data Validator.
 */
public class DataValidator {

    /**
     * isValidEmail() is used to validate an email address whether it is valid
     * format or not.
     *
     *
     * @param inputEmail
     *            This string is the one which you wanna validate for email
     *
     * @return Returns true if valid email or false if not valid email
     *
     */
    public static boolean isValidEmail(String inputEmail) {
        if (inputEmail != null) {
            String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

            return RegExUtils.applyRegEx(inputEmail, regExpn);
        }
        return false;
    }

}
