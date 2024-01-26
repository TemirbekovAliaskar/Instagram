package service.impl;

import database.DataBase;
import information.GenerateId;
import information.User;
import service.UserService;

import java.util.Arrays;
import java.util.Scanner;

public class UserServiceimpl implements UserService {
    @Override
    public User[] register() {
        User user = new User();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name  : ");
        user.setFullName(scanner.nextLine());
        System.out.println("Write gender : ");
        user.setGender(scanner.nextLine());
        System.out.println("Email  : ");
        user.setEmail(scanner.nextLine());
        System.out.println("Password : ");
        user.setPassword(scanner.nextLine());

        user.setId(GenerateId.generateIds());

        DataBase.users = Arrays.copyOf(DataBase.users, DataBase.users.length + 1);
        DataBase.users[DataBase.users.length - 1] = user;
        return DataBase.users;
    }

    @Override
    public User login() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Email : ");
        String email = scanner.nextLine();
        System.out.println("Password : ");
        String pass = scanner.nextLine();
        for (int i = 0; i < DataBase.users.length; i++) {
            if (DataBase.users[i].getEmail().equalsIgnoreCase(email) && DataBase.users[i].getPassword().equalsIgnoreCase(pass)) {
                return DataBase.users[i];
            }
        }
        return null;
    }

    @Override
    public void getUserByEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Email : ");
        String email = scanner.nextLine();
        for (int i = 0; i < DataBase.users.length; i++) {
            if (DataBase.users[i].getEmail().equalsIgnoreCase(email)) {
                System.out.println(DataBase.users[i]);
            }
        }

    }

    @Override
    public void getAllUsers() {
        User[] users = DataBase.users;
        System.out.println(Arrays.toString(users));
    }
}
