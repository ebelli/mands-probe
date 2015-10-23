package com.ebelli.mandsprobe.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class DataValidationTest {

    @Test
    public void testIsValidEmail(){
        assertTrue(DataValidator.isValidEmail("test@gmail.com"));
        assertTrue(DataValidator.isValidEmail("test@gmail.co.uk"));
        assertFalse(DataValidator.isValidEmail("testgmail.com"));
        assertFalse(DataValidator.isValidEmail("testgmailcom"));
        assertFalse(DataValidator.isValidEmail(""));
        assertFalse(DataValidator.isValidEmail(null));
    }

}
