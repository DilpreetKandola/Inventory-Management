
import java.io.Serializable;


abstract class furniture implements Serializable {
    
    protected double price;                                                                                          //basic double variables all furniture should inherit/have
    protected double length;
    protected double width;

    protected String typeOfFurniture;
    protected String Description;                                                                                     //basic string vars that all furniture should inherit/have

    protected String ProductID; 


    public furniture(){                                                                                              //Furniture Constructor
        this.price = 0.00;
        this.length = 0.00;
        this.width = 0.00;
        this.typeOfFurniture = "null";
        this.ProductID = null;
        this.Description = "No Description";
    }


    public furniture(double InPrice, double inLength, double inWidth, String inType, String inDescription, String productID){         //Constructor with Parameters 
        this.price = InPrice;
        this.length = inLength;
        this.width = inWidth;
        this.typeOfFurniture = inType;
        this.ProductID = productID;
        this.Description = inDescription;
    }


    public double getPrice(){                                                                                       //getters//Setter for variables
        
        return this.price;
        
    }

    public void setPrice(double setPrice){
        this.price = setPrice;
    }

    public double getLength(){
        
        return this.length;
    }

    public double getWidth(){

        return this.width;
    }
    


    public String getTypeFurn(){

        return this.typeOfFurniture;
    }

    public String getDescription(){

        return this.Description;
    }

    public void setDescription(String inDescription){
        this.Description = inDescription;
    }


    public String getID(){
        return this.ProductID;
    }

    public void setID(String newID){
        this.ProductID = newID;
    }


}