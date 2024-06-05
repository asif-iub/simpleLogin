package com.cse.oop.myprojects.simplelogin;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {
    private final List<User> userlist;

    public Authenticator(){
        userlist = new ArrayList<>();
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

    public void addNewUser(User loginUser) {
        // validate and check for rule violations
        // if....
        userlist.add(loginUser);
        System.out.println("New user added: " + loginUser.toString());
    }
}
