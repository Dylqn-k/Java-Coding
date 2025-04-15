public class InvalidRetailPrice extends Exception{
    public InvalidRetailPrice(double price){
        super("Invalid Retail Price");}

        public InvalidRetailPrice(String price) {
            super("Invalid Retail Price: " + price);
        }}

