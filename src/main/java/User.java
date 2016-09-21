public class User {
    private int ID;
    private String firstName;
    private String surname;
    enum Rights{
        User, Admin
    }
    private Rights rights;
    private Location location;

    User(int ID, String firstName, String surname, Rights rights, Location location){
        this.ID = ID;
        this.firstName = firstName;
        this.surname = surname;
        this.rights = rights;
        this.location = location;
    }

    public int getID(){return ID;}
    public String getSurname() {return surname;}
    public String getFirstName() {return firstName;}
    public Rights getRights(){return rights;}
    public Location getLocation() {return location;}
}
