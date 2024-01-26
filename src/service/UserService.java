package service;

import information.User;

public interface UserService {

    User [] register();
    User login();

    void getUserByEmail();
    void getAllUsers();

}
