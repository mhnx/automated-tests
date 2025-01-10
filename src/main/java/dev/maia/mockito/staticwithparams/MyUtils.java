package dev.maia.mockito.staticwithparams;

public class MyUtils {

    public static String getWelcomeMessage(String username, boolean isCustomer) {

        if (isCustomer) {
            return "Dear " + username;
        }

        return "Hello " + username;
    }
}
