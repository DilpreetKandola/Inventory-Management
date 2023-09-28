



public class chair extends furniture {

    protected boolean hasArmRests;              //variables specific to this sub class
    protected boolean WheelsOrNah;


    public chair(){                         //chair constructor
        
        super();
        
        this.hasArmRests = false;

    }

    public chair(double InPrice, double inLength, double inWidth, String inType, String inDescription, boolean inrests, boolean inWheel, String productID){         //chair constructor with parameters
        
        super( InPrice, inLength, inWidth, inType, inDescription, productID);

        this.hasArmRests = inrests;
        this.WheelsOrNah = inWheel;
    }

    public boolean getRests(){                                      //get arm rest method
        return this.hasArmRests;
    }

    public void setRests(boolean inRests){                          //setter for arm rests
        this.hasArmRests = inRests;
    }



    public boolean getWheels(){                                    //get wheels method
        return this.WheelsOrNah;
    }

    public void setWheels(boolean inWHeel){                        //setter for wheel
        this.WheelsOrNah = inWHeel;
    }

    






}
