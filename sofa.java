



public class sofa extends furniture {

    protected int amntOfSeats;                      //variables specific to this sub class
    protected String shapeOfSofa;


    protected boolean hasRecliner;
    protected boolean seatWarmers; 


    public sofa(){                                  //Constructor

        super();
        
        this.amntOfSeats = 0;
        this.shapeOfSofa = "";
        this.hasRecliner = false;
        this.seatWarmers = false;

    }

    public sofa(double inPrice, double inLength, double inWidth, String inType, String inDescription, int amountSeats, String shape, boolean seatExtends, boolean warmSeats, String productID ){          //constructor with parameters
        
        super( inPrice,  inLength,  inWidth,  inType,  inDescription, productID);
        
        this.amntOfSeats = amountSeats;
        this.shapeOfSofa = shape;                                                                   
        this.seatWarmers = warmSeats;
        this.hasRecliner = seatExtends;
    }




    public int getAmountSeats(){                    //getter for amnt seats
        return this.amntOfSeats;
    }

    public void setAmountSeats(int inSeats){        //setter for amnt seats
        this.amntOfSeats = inSeats;
    }



    public String getShape(){                       //getter for shape
        return this.shapeOfSofa;                
    }

    public void setShape(String inShape){           //setter for shape
        this.shapeOfSofa = inShape;
    }



    public boolean getExtendSeat(){                 //getter for extendable seat 
        return this.hasRecliner;
    }

    public void setExtendSeat(boolean inExtend){    //setter for extendable seat
        this.hasRecliner = inExtend; 
    }



    public boolean getWarmer(){                     //getter for warmed seat
        return this.seatWarmers;
    }

    public void setWarmer(boolean inWarmer){        //setter for warmed seats
        this.seatWarmers = inWarmer;
    }






}