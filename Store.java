import java.util.*;
import java.io.*;


public class Store {
    protected static Scanner user = new Scanner(System.in);       //username
    protected static Scanner password = new Scanner(System.in);   //password
    
    protected static Scanner firstName = new Scanner(System.in);  //First Name
    protected static Scanner lastName = new Scanner(System.in);   //Last Name

    protected static admin bigAdmin;                     
    
    public static void main(String[] args){
        bigAdmin = readFile();
        if(bigAdmin == null){
            bigAdmin = new admin("00000", "12345");
        }
        login(bigAdmin);

        

        writeFile(bigAdmin);


    }

    public static void login(admin bigAdmin){
        boolean loop = true;

        while(loop){
            Scanner userInput = new Scanner(System.in);
            System.out.println("Welcome to the Store! login in to your account or create one if your new!");
            System.out.println("0: Admin");
            System.out.println("1: User");
            System.out.println("2: Create new account");;
            System.out.println("3: EXIT");
            String userChoice = userInput.nextLine();


            //admin 
            if(userChoice.equals("0")){
                adminMenu();

            }

            //user
            else if(userChoice.equals("1")){
               userMenu();
            }

            //new account
            else if(userChoice.equals("2")){
                newAcc();

            }


            else if(userChoice.equals("3")){
                loop = false;

            }

            //invalid choice
            else{
                System.out.println("Invalid Choice");
            }
        }




    }

    public static void newAcc(){
        System.out.println("Enter an Account Number: ");
        String NewAcc = user.next();
        System.out.println("Enter new password: ");
        String newPass = password.next();
        System.out.println("Enter your First Name: ");
        String newFirst = firstName.next();
        System.out.println("Enter your Last Name: ");
        String newLast = lastName.next();



        for(user index: bigAdmin.getUsers()){
            if(index.getAccountNum().equals(NewAcc)){
                System.out.println("Error: an account with this number already exists");
                return;
            }
        }
        //System.out.println("Does it still go here? ");
        user newUser = new user(NewAcc, newPass, newFirst, newLast);
        bigAdmin.addUser(newUser);
        System.out.println("Account Created! please log in \n");

    }
    

    public static void userMenu(){
        
        System.out.println("Enter your Account Number: ");
        String userNum = user.next();

        System.out.println("Enter your Password: ");
        String userPass = password.next();

        user CurrentUser = null;
        CurrentUser = bigAdmin.findUser(userNum, userPass);

        if(CurrentUser != null){

            Scanner userInput = new Scanner(System.in);
            boolean loop = true;

            while(loop){
                System.out.println("Welcome " + CurrentUser.getFirst() + " " + CurrentUser.getLast() + "!");

                System.out.println("1) order an item");
                System.out.println("2) Change Name");
                System.out.println("3) exit");

                String userChoice = userInput.next();

                if(userChoice.equals("1")){
                    bigAdmin.listInventory();

                    System.out.println("\n Please provide productID of what you would like to order: ");
                    String idOfChoice = userInput.next();

                    String foundOrNot = bigAdmin.findID(idOfChoice);

                    if(foundOrNot.equals("1")){
                        Scanner address = new Scanner(System.in);



                        System.out.println("Enter address: ");
                        String addy = address.nextLine();


                        CurrentUser.setAddress(addy);

                        ordered newOrder = new ordered(idOfChoice, addy);
                        bigAdmin.addOrder(newOrder);

                        System.out.println("Item Ordered! ");
                    }   

                    else if(foundOrNot.equals("2")){
                        System.out.println("Item not found.");
                    }

                    else{
                        System.out.println("Something aint right");
                    }

                }

                else if(userChoice.equals("2")){

                    System.out.println("Sure! Please enter your new First name: ");
                    String newFirst = firstName.nextLine();

                    System.out.println("Please enter your new Last name: ");
                    String newLast = lastName.nextLine();

                    CurrentUser.setFirst(newFirst);
                    CurrentUser.setLast(newLast);
                }

                else if(userChoice.equals("3")){

                    System.out.println("GoodBye");
                    loop = false;

                }
            }


        }
        else{
            System.out.println("This account does not exist or your password is incorrect. \n");
            CurrentUser = null;
        }

        CurrentUser = null;
        
    }

    public static void adminMenu(){

        System.out.println("Enter Admin Account Number: ");
        String AdminNum = user.next();

        System.out.println("Enter Admin Password: ");
        String AdminPass = password.next();

        if(bigAdmin.getAccountNum().equals(AdminNum) && bigAdmin.getPassCode().equals(AdminPass)){
            boolean loop = true;
            while(loop){
                Scanner userInput = new Scanner(System.in);
                System.out.println("Welcome Admin!");

                System.out.println("0) View Inventory");
                System.out.println("1) Order Inventory");

                System.out.println("2) Delete Customer Account");
                System.out.println("3) View Customer Accounts");

                System.out.println("4) view company funds");
                System.out.println("5) edit Piece of Furniture");
                System.out.println("6) view ordered items");
                System.out.println("7) complete an Order");

                System.out.println("8) exit");
                String userChoice = userInput.nextLine();


                
                if(userChoice.equals("0")){
                    bigAdmin.listInventory();
                }
                

                else if(userChoice.equals("1")){
                    orderInventory();
                }


                else if(userChoice.equals("2")){
                    System.out.println("Enter Account Number to Delete: ");
                    String delAcc = user.next();
                    System.out.println("Enter the passowrd: ");
                    String delPass = password.next();
                    user foundUser = null;
                    for(user index: bigAdmin.getUsers()){
                        if(index.getAccountNum().equals(delAcc) && index.getPassCode().equals(delPass)){
                            foundUser = index;
                        }
                    }
                    if(foundUser != null){
                        bigAdmin.getUsers().remove(foundUser);
                        System.out.println("User Removed! \n");
                    }
                    else{
                        System.out.println("User not Found \n");    
                    }

                }


                else if(userChoice.equals("3")){
                    bigAdmin.listUsers();
                }
                

                else if(userChoice.equals("8")){
                    loop = false;
                }


                else if(userChoice.equals("4")){
                    System.out.println("Funds: $" + bigAdmin.getMoney()); 
                }


                else if(userChoice.equals("5")){
                    Scanner editChoice = new Scanner(System.in);

                    Boolean editLoop = true;

                    while(editLoop){
                        System.out.println("Enter Inventory to Search(furniture type) 1: Chair 2: Sofa 3: table ");
                        String searchChoice = editChoice.next();

                        System.out.println("Enter product ID you would like to edit: ");

                        String editID = editChoice.next();

                        if(searchChoice.equals("1")){
                            bigAdmin.editInventory(editID, "CHAIR");
                            editLoop = false;
                        }

                        else if(searchChoice.equals("2")){
                            bigAdmin.editInventory(editID,"SOFA");
                            editLoop = false;

                        }
                        
                        else if(searchChoice.equals("3")){
                            bigAdmin.editInventory(editID, "TABLE");
                            editLoop = false;
                        }

                        else{
                            System.out.println("Not a currently available furniture type.");
                        }


                    }

             

                }

                else if(userChoice.equals("6")){
                    bigAdmin.listOrders();
                }

                else if(userChoice.equals("7")){

                    bigAdmin.listOrders();

                    System.out.println("\nEnter productID of order you would like to complete: ");
                    String ID = userInput.next();

                    bigAdmin.removeProduct(ID);


                }



            }
        }
        else{
            System.out.println("Invalid Credentials");
        }
    }







    public static void orderInventory(){

        Scanner input = new Scanner(System.in);
        Scanner options = new Scanner(System.in);

        Scanner price = new Scanner(System.in);
        Scanner description = new Scanner(System.in);

        Scanner ID = new Scanner(System.in);

        System.out.println("What Would you Like to order? ");
        System.out.println("0) chair");
        System.out.println("1) sofa");
        System.out.println("2) table");
        String choice = input.nextLine();


        if(choice.equals("0")){

            try{
            System.out.println("Order with ArmRests? (enter true or false): ");
            Boolean armChoice = options.nextBoolean();

            System.out.println("Order with wheels? (enter true or false): ");
            Boolean wheelChoice = options.nextBoolean();

            System.out.println("Please set the Price: Order cost is $100");
            double setPrice = price.nextDouble();

            System.out.println("Enter chair Description: ");
            String inDescription = description.nextLine();

            System.out.println("Set the product ID(must be unique to each piece of furniture): ");
            String productID = ID.nextLine();

            double newAmount = bigAdmin.getMoney() - 150;
            bigAdmin.setMoney(newAmount);

            String type = "Chair";
            double inLength = 18;
            double inWidth = 15;


            chair newChair = new chair(setPrice, inLength, inWidth, type, inDescription, armChoice, wheelChoice, productID);
            bigAdmin.addChair(newChair);
            System.out.println("Inventory Ordered!");
            }
            catch(Exception TranslationError){
                System.out.println("Invalid Order Entry: ORDER CANCELED \n");
            }


        }

        else if(choice.equals("1")){
            
            try{

            System.out.println("How many Seats?: ");
            int seats = options.nextInt();
            
            System.out.println("Enter shape of the sofa you would Like: ");
            String shape = description.nextLine();

            System.out.println("Add recliner seats?(true or false): ");
            boolean extndSeats = options.nextBoolean();

            System.out.println("Add Seat Warmers(true or false): ");
            boolean seatWarmers = options.nextBoolean();

            System.out.println("Please set the Price: Order cost is $130");
            double setPrice = price.nextDouble();

            System.out.println("Enter Description for Sofa: ");
            String inDescription = description.nextLine();

            System.out.println("Set the product ID(must be unique to each piece of furniture): ");
            String productID = ID.nextLine();
            

            String type = "Sofa";
            double inLength = 80;
            double inWidth = 40;

            double newAmount = bigAdmin.getMoney() - 150;
            bigAdmin.setMoney(newAmount);

            sofa newSofa = new sofa(setPrice, inLength, inWidth, type, inDescription, seats, shape, extndSeats, seatWarmers, productID);
            bigAdmin.addSofa(newSofa);
            System.out.println("Inventory Ordered!");
            }
            catch(Exception translationError){
                System.out.println("Invalid Order Entry: ORDER CANCELED \n");
                return;
            }


        }

        else if(choice.equals("2")){
            try{
            System.out.println("How many Legs?: ");
            int amntLegs = options.nextInt();

            System.out.println("Enter Desired shape of Table: ");
            String tableShape = description.nextLine();

            System.out.println("Enter desired Material: ");
            String tableMaterial = description.nextLine();

            System.out.println("Build with Adjustable Height?: (true or false): ");
            boolean adjustHeight = options.nextBoolean();

            System.out.println("Please set Price: Order Cost is $120: ");
            double newPrice = price.nextDouble();

            System.out.println("Enter Description for product: ");
            String newDescription = description.nextLine();

            System.out.println("Set Product ID(must be unique to each piece of furniture): ");
            String productID = ID.nextLine();

            String type = "Table";
            double inLength = 47;
            double inWidth = 30;

            double newAmount = bigAdmin.getMoney() - 120;
            bigAdmin.setMoney(newAmount);

            table newTable = new table(newPrice, inLength, inWidth, type, newDescription, amntLegs, tableShape, tableMaterial, adjustHeight, productID);
            bigAdmin.addTable(newTable);
            System.out.println("Inventory Ordered!");
            }
            catch(Exception translationError){
                System.out.println("Invalid Order Entry: ORDER CANCELED \n");
            }


        }








    }




    public static void writeFile(admin tempAdmin){
        try{
            FileOutputStream data = new FileOutputStream("DATA.txt");
            ObjectOutputStream output = new ObjectOutputStream(data);
            output.writeObject(tempAdmin);

        }
        catch(IOException CaughtError){
            System.out.println("error occured " + CaughtError);
        }
    }

    public static admin readFile(){
        try{
            FileInputStream data = new FileInputStream("DATA.txt");
            ObjectInputStream dataIn = new ObjectInputStream(data);

            return (admin) dataIn.readObject();
        }

        catch(IOException caughtErrorException){
            System.out.println("\n");
        }

        catch(ClassNotFoundException errorCaught){
            System.out.println(errorCaught);
        }

        return null;
    }


    }






