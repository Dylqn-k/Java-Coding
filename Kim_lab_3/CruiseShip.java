public class CruiseShip extends Ship {
    private int setpassengers;

    public CruiseShip (CruiseShip other)
    {
        super(other);
        this.setpassengers = other.setpassengers;
    }

    public CruiseShip(String n, String y, int p){
        super(n,y);
        this.setpassengers = p;
    }


    public void setpassengers(int p) {this.setpassengers = p;}

    public int getSetpassengers() {return setpassengers;}

    @Override
    public String toString() {
        return String.format("CruiseShip Name is: %s, Maximum number of passengers are: %d",
                getName(), getSetpassengers());}

    @Override
    public void display() {
        System.out.println(this.toString());
    }
}

