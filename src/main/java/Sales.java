public class Sales {
    int week;
    int year;
    Location location;
    int stock;
    int quantity;
    float net;
    Sales(int week,int year,Location location,int stock,int quantity,float net){
        this.week= week;
        this.year= year;
        this.location= location;
        this.stock= stock;
        this.quantity= quantity;
        this.net= net;
    }

    public int getYear() {
        return year;
    }

    public Location getLocation() {
        return location;
    }

    public int getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getNet() {
        return net;
    }

    public int getWeek() {
        return week;

    }
}
