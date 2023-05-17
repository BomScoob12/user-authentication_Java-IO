public class User {
    private String userID;
    private String username;
    private String password;
    private static int COUNT;

    public User(String username, String password){
        this.userID = "00"+COUNT++;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }
    public String getUserID(){
        return userID;
    }
}
