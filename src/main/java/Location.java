public class Location {
    private int ID;
    private String name;
    enum LocationType{
        HeadOffice, Store
    }
    private LocationType locationType;
    Location(int ID, String name, LocationType locationType){
        this.ID = ID;
        this.name = name;
        this.locationType = locationType;
    }

    public int getID() {return ID;}
    public String getName() {return name;}
    public LocationType getLocationType() {return locationType;}
}
