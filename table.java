

public class table extends furniture{
    
    protected int amntOfLegs;                   //variables speciic to tables

    protected String shapeOfTable;
    protected String material;

    protected boolean adjustableheight; 

    public table(){                         //constructor

        super();

        this.amntOfLegs = 0;
        this.shapeOfTable = "";
        this.shapeOfTable = "";
        this.material = "";
        this.adjustableheight = false;

    }

    public table(double inPrice, double inLength, double inWidth, String inType, String inDescription, int legs, String shape, String material, boolean height, String productID){          //constructor with parameters

        super( inPrice,  inLength,  inWidth,  inType,  inDescription, productID);

        this.amntOfLegs = legs;
        this.shapeOfTable = shape;
        this.material = material;
        this.adjustableheight = height;
    }


    public int getLegs(){                           //getter for amount of legs
        return this.amntOfLegs;
    }

    public void setLegs(int inLegs){
        this.amntOfLegs = inLegs;
    }




    public String getShape(){                       //getter for shape
        return this.shapeOfTable;
    }


    public void setShape(String inShapeString){     //setter for shape 
        this.shapeOfTable = inShapeString;
    }



    public String getmaterial(){                   //getter for material
        return this.material;
    }

    public void setMaterial(String Inmaterial){   //setter for material
        this.material = Inmaterial;
    }



    public boolean getHeight(){                    //getter for adjustable height
        return this.adjustableheight;
    }

    public void setHeight(boolean inHeight){        //setter for adjustable height 
        this.adjustableheight =inHeight;
    }
    


}