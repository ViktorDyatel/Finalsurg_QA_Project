package entities;

import models.User;

public class EntitiesFactory {
    public static User getUser() {
        return User.builder().password(System.getProperty("password")).email(System.getProperty("email")).build();
    }

    public static User getUserWithIncorrectPassword() {
        return User.builder().password("423424235").email(System.getProperty("email")).build();
    }

    public static User getUserWithIncorrectEmail() {
        return User.builder().password(System.getProperty("password")).email("victor1998@gmail.com").build();
    }


}


