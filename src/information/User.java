package information;

import java.util.Arrays;

public class User {

    private int id ;
    private String email ;
    private String password;
    private String fullName;
    private String gender;

    public   Post [] posts = new Post[0];

    public User(){};

    public User(int id, String email, String password, String fullName, String gender, Post[] posts) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", posts=" + Arrays.toString(posts) +
                '}';
    }
}
