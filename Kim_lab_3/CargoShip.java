public class CargoShip extends Ship{
    private int tonnage;

    public CargoShip (CargoShip other)
    {
        super(other);
        this.tonnage = other.tonnage;
    }

    public CargoShip(String n, String y, int t){
        super(n,y);
        this.tonnage = t;
    }

    public void setpassengers(int t) {this.tonnage = t;}

    public int getSetpassengers() {return tonnage;}

    @Override
    public String toString() {
        return String.format("CargoShip Name: %s, Maximum cargo capacity is: %d tons",
                getName(), getSetpassengers());}

    @Override
    public void display() {
        System.out.println(this.toString());
    }
}
