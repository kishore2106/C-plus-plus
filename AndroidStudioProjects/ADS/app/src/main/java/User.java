public class User {
    public String usn;
    public String imageUrl;

    // Add a default constructor for Firebase
    public User() {
    }

    public User(String name, String imageUrl) {
        this.usn = name;
        this.imageUrl = imageUrl;
    }
}
