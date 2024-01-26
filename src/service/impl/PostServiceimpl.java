package service.impl;

import database.DataBase;
import information.GenerateId;
import information.Post;
import information.User;
import service.PostService;

import java.util.Arrays;
import java.util.Scanner;

public class PostServiceimpl implements PostService {
    @Override
    public void addPostToUser() {
        Scanner scanner = new Scanner(System.in);
        Post post = new Post();
        System.out.println("Image Url :");
        post.setImageUrl(scanner.nextLine());
        System.out.println("Description : ");
        post.setDescription(scanner.nextLine());
        post.setId(GenerateId.postIds());
        for (int i = 0; i < DataBase.users.length; i++) {
            DataBase.users[i].posts = Arrays.copyOf(DataBase.users[i].posts, DataBase.users[i].posts.length + 1);
            DataBase.users[i].posts[DataBase.users[i].posts.length - 1] = post;
        }


    }

    @Override
    public void deletePostId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your id : ");
        int id = scanner.nextInt();
        for (int i = 0; i < DataBase.users.length; i++) {
            for (int k = 0; k < DataBase.users[i].posts.length; k++) {
                if (DataBase.users[i].posts[k].getId() == id) {
                    DataBase.users[i].posts[k] = DataBase.users[i].posts[k + 1];
                }
            }
            DataBase.users[i].posts = Arrays.copyOf(DataBase.users[i].posts, DataBase.users[i].posts.length - 1);
        }

    }

    @Override
    public void getAllPostByUserId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your id : ");
        int id = scanner.nextInt();
        for (int i = 0; i < DataBase.users.length; i++) {
            if (DataBase.users[i].getId() == id) {
                System.out.println(Arrays.toString(DataBase.users[i].posts));
            }
        }
    }
}
