package loginregister;

public class Record {
    private String premise;
    private double price;
    private String address;

    public Record(String premise, double price, String address) {
        this.premise = premise;
        this.price = price;
        this.address = address;
    }

    // Getter and Setter methods
    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return premise + "\n\nPrice: RM" + String.format("%.2f\n\n", price) + "\n\nAddress: " + address;
    }
}

  
//public Record (price,address,premise){
//this. = =;
//}
//
////getter and setter
//}
//------------------------------------------------------------------
//// in the file where u find the top 5
//
//ArrayList<Record> recordlist = new ArrayList<>();
//
//if (){
//	while(){
//		Record top = new Record (price, add, premis);
//		recordlist.add(top);
//		pass recordlist in a method into the GUI thing and add to the label text
//	}
//}
//}
