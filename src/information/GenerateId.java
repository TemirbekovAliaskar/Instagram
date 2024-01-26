package information;

public class GenerateId {

    public static int id = 0;
    public static int postId = 0;



    public static int generateIds(){
        return (++id);
    }
    public static int postIds(){
        return (++postId);
    }
}
