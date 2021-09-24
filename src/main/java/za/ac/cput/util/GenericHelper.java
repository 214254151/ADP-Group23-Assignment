package za.ac.cput.util;

import java.util.UUID;

public class GenericHelper
{
    public static String generateID()
    {
        return UUID.randomUUID().toString();
    }

    public static boolean validEmail(String email) {
        String regex = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        return email.matches(regex);
    }

    public static boolean validateEmail(String supplierEmail) {
        String regex = "^\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        return supplierEmail.matches(regex);
    }




}
