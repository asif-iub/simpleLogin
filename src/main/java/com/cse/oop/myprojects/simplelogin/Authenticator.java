package com.cse.oop.myprojects.simplelogin;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    private static final List<User> userlist = new ArrayList<>();

    static {
        userlist.add(new User("admin", "1234"));
        userlist.add(new User("hr", "0987"));
        userlist.add(new User("engineer", "qwerty"));
        userlist.add(new User("customer", "asdf"));
    }

    public List<User> getUserList() {
        return userlist;
    }

    public boolean checkLogIn(User loginUser){
        for (User user: userlist) {
            if (loginUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean addNewUser(User loginUser) {
        for (User user: userlist) {
            if (loginUser.getUsername().equals(user.getUsername())) {
                System.out.println("A user '" + loginUser.getUsername() + "' already exists!");
                return false;
            }
        }

        userlist.add(loginUser);
        System.out.println("New user added: " + loginUser.toString());
        return true;
    }
}
