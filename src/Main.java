import database.DataBase;
import information.User;
import service.PostService;
import service.UserService;
import service.impl.PostServiceimpl;
import service.impl.UserServiceimpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceimpl();
        PostService postService = new PostServiceimpl();
        Scanner scanner = new Scanner(System.in);
        User currentUser = new User();

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                    1.Register
                    2.SignUp
                    3.Exit
                    """);
            switch (scanner.nextLine()) {
                case "1" -> DataBase.users = userService.register();
                case "2" -> {
                    currentUser = userService.login();
                    if (currentUser != null) {
                        boolean isTrue = true;
                        while (isTrue) {
                            System.out.println("""
                                    1.Get User by email
                                    2.Get All Users
                                    3.Add post User
                                    4.Delete post by Id
                                    5.GetAllPostUserById
                                    0.Exit
                                    """);

                            switch (scanner.nextLine()) {
                                case "1" -> userService.getUserByEmail();
                                case "2" -> userService.getAllUsers();
                                case "3" -> postService.addPostToUser();
                                case "4" -> postService.deletePostId();
                                case "5" -> postService.getAllPostByUserId();
                                case "0" -> isTrue = false;
                            }
                        }
                    }
                }
                case "3" -> {
                    isRunning = false;
                }
            }

        }

    }
}