import java.io.Serializable;



public class ordered implements Serializable {

    protected String productID;
    protected String Address;


    public ordered(){
        this.productID = "";
        this.Address = "";
    }

    public ordered(String id, String addy){

        this.productID = id;
        this.Address = addy;

    }

    public String getID(){
        return this.productID;
    }

    public void setID(String inIDString){
        this.productID = inIDString;
    }

    public String getAddy(){
        return this.Address;
    }

    public void setAddy(String inAddyString){
        this.Address = inAddyString;
    }
}