import java.util.*;

import java.util.ArrayList
;
import java.io.Serializable;    

public class admin implements Serializable {

    protected String AccountNumber;
    protected String passcode;                                                           //Account number and passcode variables
    protected double money = 10000;

    protected ArrayList<user> users;                                                       //vector that stores users
    
    protected ArrayList<chair> chairInventory;                                             //Inventory of furniture 
    protected ArrayList<sofa> sofaInventory;                                               //Inventory of Sofas
    protected ArrayList<table> tableInventory;                                             //Inventory of Tables

    protected ArrayList<ordered> orderedInventory;                                          //admin can see what has been ordered



    
    public admin(){                                                                     //admin Constructor
        this.AccountNumber = "00000";
        this.passcode = "12345";
  

        this.users = new ArrayList<user>();
        this.chairInventory = new ArrayList<chair>();
        this.sofaInventory = new ArrayList<sofa>();
        this.tableInventory = new ArrayList<table>();
        this.orderedInventory = new ArrayList<ordered>();

    }


    public admin(String accountTemp, String passTemp){                                  //admin constructor with parameters
        this.AccountNumber = accountTemp;
        this.passcode = passTemp;


        this.users = new ArrayList<user>();
        this.chairInventory = new ArrayList<chair>();
        this.sofaInventory = new ArrayList<sofa>();
        this.tableInventory = new ArrayList<table>();
        this.orderedInventory = new ArrayList<ordered>();

    }




    public void setMoney(double inMoney){                                               //setter for money
        this.money = inMoney;
    }

    public double getMoney(){                                                           //getter for money
        return this.money;
    }


    public String getAccountNum(){                                                      //getter for account number
        return this.AccountNumber;
    }



    public String getPassCode(){                                                        //getter for passcode
        return this.passcode;
    }



    public ArrayList<user> getUsers(){                                                     //Getter for users 
        return users;
    }



    public void DeleteUser(user tempUser){                                              //Method to delete a user
        users.remove(tempUser);
    }



    public void listUsers(){                                                            //method to print out a list of all users
        for(user index: users){
            System.out.println("ACCOUNT NUMBER: "+ index.getAccountNum() + " PASSCODE: " + index.getPassCode());
            System.out.println("NAME: " + index.getFirst() + " " + index.getLast() + "\n"); 
        }
    }

    public void editInventory(String editID, String inventoryToSearch){                 //edit inventory method

        Scanner userInput = new Scanner(System.in);

        if(inventoryToSearch.equals("CHAIR")){

            for(chair chairIndex: chairInventory){

                if(chairIndex.getID().equals(editID)){
                    System.out.println("EDITABLE VARIABLES: 1. Price 2. Description 3. productID");
                    System.out.println("Enter choice: ");

                    String choice = userInput.nextLine().toUpperCase();

                    if(choice.equals("1")){

                        System.out.println("Enter new Price: ");

                        try{

                            Double newPrice = userInput.nextDouble();

                            chairIndex.setPrice(newPrice);


                        }
                        catch(Exception caught){
                            System.out.println("ERROR: invalid entry");
                        }

                    }

                    else if(choice.equals("2")){

                        System.out.println("Enter new Description");

                        try{
                            String newDescription = userInput.nextLine();


                            chairIndex.setDescription(newDescription);
                        }
                        catch(Exception caught){
                            System.out.print("ERROR: invalid Entry");
                        }

                    }

                    else if(choice.equals("3")){

                        System.out.println("Enter new Product ID");

                        try{
                            String newID = userInput.nextLine();



                            chairIndex.setID(newID);
                        }

                        catch(Exception caught){
                            System.out.println("ERROR: invalid Entry");
                        }
                    }


                }






                else{
                    System.out.println("Product ID was not found.");
                }
            }
        }

        else if(inventoryToSearch.equals("SOFA")){

            for(sofa sofaIndex: sofaInventory){

                if(sofaIndex.getID().equals(editID)){
                    System.out.println("EDITABLE VARIABLES: 1. Price 2. Description 3. productID");
                    System.out.println("Enter choice: ");

                    String choice = userInput.next();

                    if(choice.equals("1")){

                        System.out.println("Enter new Price: ");

                        try{

                            Double newPrice = userInput.nextDouble();

                            sofaIndex.setPrice(newPrice);


                        }
                        catch(Exception caught){
                            System.out.println("ERROR: invalid entry");
                        }

                    }

                    else if(choice.equals("2")){

                        System.out.println("Enter new Description: ");

                        try{
                            String newDescription = userInput.nextLine();



                            sofaIndex.setDescription(newDescription);
                        }
                        catch(Exception caught){
                            System.out.print("ERROR: invalid Entry");
                        }

                    }

                    else if(choice.equals("3")){

                        System.out.println("Enter new Product ID");

                        try{
                            String newID = userInput.nextLine();


                            sofaIndex.setID(newID);
                        }

                        catch(Exception caught){
                            System.out.println("ERROR: invalid Entry");
                        }
                    }


                }
                






                else{
                    System.out.println("Product ID was not found.");
                }
            } 




        }

        else if(inventoryToSearch.equals("TABLE")){

            for(table tableIndex: tableInventory){

                if(tableIndex.getID().equals(editID)){
                    System.out.println("EDITABLE VARIABLES: 1. Price 2. Description 3. productID");
                    System.out.println("Enter choice: ");

                    String choice = userInput.nextLine().toUpperCase();

                    if(choice.equals("1")){

                        System.out.println("Enter new Price: ");

                        try{

                            Double newPrice = userInput.nextDouble();



                            tableIndex.setPrice(newPrice);


                        }
                        catch(Exception caught){
                            System.out.println("ERROR: invalid entry");
                        }

                    }

                    else if(choice.equals("2")){

                        System.out.println("Enter new Description");

                        try{
                            String newDescription = userInput.nextLine();


                            tableIndex.setDescription(newDescription);
                        }

                        catch(Exception caught){
                            System.out.print("ERROR: invalid Entry");
                        }

                    }

                    else if(choice.equals("3")){

                        System.out.println("Enter new Product ID");

                        try{
                            String newID = userInput.nextLine();



                            tableIndex.setID(newID);
                        }

                        catch(Exception caught){
                            System.out.println("ERROR: invalid Entry");
                        }
                    }


                }






                else{
                    System.out.println("Product ID was not found.");
                }
            }
        }





    }   //end of edit inventory




    public void listInventory(){                                                        //prints out inventorys 
        for(chair chairIndex: chairInventory){  

            System.out.println("TYPE: " + chairIndex.getTypeFurn() + "  " + "PRICE: $" + chairIndex.getPrice());
            System.out.println("PRODUCT ID: " + chairIndex.getID());

            System.out.println("DESCRIPTION: " + chairIndex.getDescription() + " ");
            System.out.println("DIMENSIONS: " + "WIDTH: " + chairIndex.getWidth() + " inches LENGTH: " + chairIndex.getLength() + " inches");
            
            System.out.println("Has Arm Rests: " + chairIndex.getRests());
            System.out.println("Has Wheels: " + chairIndex.getWheels() + "\n");
             
        }
        for(sofa sofaIndex: sofaInventory){

            System.out.println("TYPE: " + sofaIndex.getTypeFurn() + "  " + "PRICE: $" + sofaIndex.getPrice());
            System.out.println("PRODUCT ID: " + sofaIndex.getID());

            System.out.println("DESCRIPTION: " + sofaIndex.getDescription() + " ");
            System.out.println("DIMENSIONS: " + "WIDTH: " + sofaIndex.getWidth() + " inches LENGTH: " + sofaIndex.getLength() + " inches");
            
            System.out.println("Amount of Seats: " + sofaIndex.getAmountSeats());
            System.out.println("Shape of Sofa: " + sofaIndex.getShape());
            System.out.println("Extendable Seat: " + sofaIndex.getExtendSeat() + " Seat Warmers: " + sofaIndex.getWarmer() + "\n"); 
        }

        for(table tableIndex: tableInventory){

            System.out.println("TYPE: " + tableIndex.getTypeFurn() + "  " + "PRICE: $" + tableIndex.getPrice());
            System.out.println("PRODUCT ID: " + tableIndex.getID());

            System.out.println("DESCRIPTION: " + tableIndex.getDescription() + " ");
            System.out.println("DIMENSIONS: " + "WIDTH: " + tableIndex.getWidth() + " inches LENGTH: " + tableIndex.getLength() + " inches");

            System.out.println("legs: " + tableIndex.getLegs() + " Material: " + tableIndex.getmaterial() + " Shape: " + tableIndex.getShape());
            System.out.println("Height Adjustable: " + tableIndex.getHeight() + "\n");
            
        }
    }
    //end of list inventory

    public void listOrders(){
        for(ordered index: orderedInventory){
            System.out.println("Ordered product ID: " + index.getID() + " Ship To: " + index.getAddy());
        }
    }


    public user findUser(String findACC, String findPASS){                              //method to find a certain user
        for(user index: users){
            if(index.getAccountNum().equals(findACC) && index.getPassCode().equals(findPASS)){
                return index;
            };
        }
        return null;
    }

    public void removeProduct(String ID){

        for(int i=0; i < chairInventory.size(); i++){
            if(chairInventory.get(i).getID().equals(ID)){
                chairInventory.remove(chairInventory.get(i));
            }
        }
        for(int i=0; i < sofaInventory.size(); i++){
            if(sofaInventory.get(i).getID().equals(ID)){
                sofaInventory.remove(sofaInventory.get(i));
            }
        }
        for(int i=0; i < tableInventory.size(); i++){
            if(tableInventory.get(i).getID().equals(ID)){
                tableInventory.remove(tableInventory.get(i));
            }
        }
        for(int i=0; i < orderedInventory.size(); i++){
            if(orderedInventory.get(i).getID().equals(ID)){
                orderedInventory.remove(orderedInventory.get(i));
            }
        }

    }



    public String findID(String inID){
        for(chair Chairindex: chairInventory){

            if(Chairindex.getID().equals(inID)){
                return "1";
            }
        }
        for(sofa sofaIndex: sofaInventory){

            if(sofaIndex.getID().equals(inID)){
                return "1";
            }
        }
        for(table tableIndex: tableInventory){
            if(tableIndex.getID().equals(inID)){
                return "1";
            }
        }
        return "2";
    
    }
    //end of find user


    public void addUser(user tempUser){                                                 //method to add a user to the vector
        users.add(tempUser);
    }

    public void addChair(chair inChair){                                                //method to add chair
        chairInventory.add(inChair);
    }

    public void addSofa(sofa inSofa){                                                   //method to add sofa
        sofaInventory.add(inSofa);
    }

    public void addTable(table inTable){                                                //method to add tables
        tableInventory.add(inTable);
    }

    public void addOrder(ordered inOrder){
        orderedInventory.add(inOrder);
    }











}