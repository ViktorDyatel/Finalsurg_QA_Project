package entities;

import models.User;

public class EntitiesFactory {
    public static User getUser() {
        return User.builder().password(System.getProperty("password")).email(System.getProperty("email")).build();
    }

}


