public class Ship implements Displayable{
    private String name;
    private String yearBuilt;

    public Ship (String n, String y)
    {
        this.name = n;
        this.yearBuilt = y;
    }

    public Ship(CargoShip other) {
    this.name = other.getName();
    this.yearBuilt = other.getYearBuilt();
    }

    public Ship(CruiseShip other) {
        this.name = other.getName();
        this.yearBuilt = other.getYearBuilt();
    }

    public void setName(String n) {this.name =n;}
    public void setYearBuilt(String y) {this.yearBuilt = y;}


    public String getName() {return name;}
    public String getYearBuilt() {return yearBuilt;}

    @Override
    public String toString() {
        return String.format("Ship Name is: %s, Year built is: %s",
                getName(), getYearBuilt());}

    @Override
    public void display() {
        System.out.println(this.toString());
    }

}

