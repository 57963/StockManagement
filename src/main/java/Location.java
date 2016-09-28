import java.util.ArrayList;

public class Location {
    private int ID;
    private String name;
    enum LocationType{
        HeadOffice{
            @Override
            public String toString() {
                return "Head Office";
            }
        }
        , Store

    }
    private LocationType locationType;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Sales> sales = new ArrayList<>();
    Location(int ID, String name, LocationType locationType){
        this.ID = ID;
        this.name = name;
        this.locationType = locationType;
    }

    public int getID() {return ID;}
    public String getName() {return name;}
    public LocationType getLocationType() {return locationType;}
    public ArrayList<User> getUsers(){return users;}
    public ArrayList<Sales> getSales(){return sales;}
}
