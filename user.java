
import java.io.Serializable;


public class user implements Serializable {

    protected String accountNumber;
    protected String passCode;

    protected String FirstName;                                                         //Variables to store simple information
    protected String lastName;
    protected String address;

    protected double funds;
   
    

    public user(){                                                                      //user constructor
       
        this.accountNumber = "";
        this.passCode = "";
        this.FirstName = "";
        this.lastName = "";
        this.address = "";

    }



    public user(String accountTemp, String pinTemp, String first, String last){        //user constructor with parameters
        
        this.accountNumber = accountTemp;
        this.passCode = pinTemp;
        this.FirstName = first;
        this.lastName = last;
        this.address = "";
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String inAddy){
        this.address = inAddy;
    }

    public String getAccountNum(){                                                      //getter for account number
        return this.accountNumber;
    }



    public String getPassCode(){                                                        //getter for passcode
        return this.passCode;
    }



    public String getFirst(){                                                           //getter for first name
        return this.FirstName;
    }

    public void setFirst(String inFirst){
        this.FirstName = inFirst;
    }

    public String getLast(){                                                            //getter for last name
        return this.lastName;   
    }

    public void setLast(String inLast){
        this.lastName = inLast;
    }
    



}