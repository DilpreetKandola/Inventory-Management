-----Store.java-----
Store.java is the main brains of this program that will handle majority of user inputs and call class methods as neccessary

function login: 
    this is the main screen of when first statring program
    print out menu
    then check what user wants
    if login as admin
    then check against the admin login else take back to this menu

    if login as user
    then check against users in array list else take back to this menu
    create account will now be in the hands of the user
    which is defined in new Acc

    each will have its own function

function newAcc:
    ask user for a account number and a new password
    ask for first name and last name as well
    then check against the user array list to see if this account number
    already exists
    if it does then end the funcion creating no new account
    otherwise a new user is created passing it parameters
    and then add it to the array list of users

function userMenu:
    when the user wants to log in this will be called
    check against array list to see if acc and pass match to an account
    if it does then continue into menu
    else print error

    the menu for the user is simple
    order an item
    in this the inventory is listed and the user is asked to provide the Id of what they would like to order
    then it checks the array lists to see if this ID is a real product otherwise it will print it does not exist
    if the product is found then the user is asked to put in their address and an instance of ordered class is created with product id and address passed as parameters
    the item is then sent to the admin to complete the order
    incase the user wants to change their name scanners will ask the user for the new name and set methods will simply change the name.
    CURRENT USER NEEDS TO BE RESET TO NULL OTHERWISE USER WILLS STAY LOGGED IN/CAUSE AN ERROR

function adminMenu:
    this is the biggest part of the program
    view inventory option will list out all admin ordered furniture 
    order inventory option will ask for what they want to order and the admin to specify everything about this particular order
    then add to specific array lists seperated by type of furniture
    customer account methods will also be defined
    first is going to list out all users in the users array list
    second will delete an user by searching the array list using for loop to find accound number and password and remove it from the list.
    a simple admin method that prints out the funds remaining with the company
    edit a item will loop over array list to find what admin wants to edit and give the options that are allowed to be changed, some things about the order are final.
    an option to view all the customer orders and the option to complete them which will remove them from inventory and the list of orders. this will be like when the order gets shipped. 

function orderInventory:
    the admin will be asked what type of furniture they would like to order
    then class specific options will be asked for as well as variables all furniture will have no matter the type they are
    use try and except to catch type errors from mis inputs
    then send those parameters when creating new instance of the choosen furniture type and print order complete

function writeFile:
    this function is used to save data so it will persist in between sessions
    a file output stream will be used to create a new file data.txt
    and the admin object will be written to it.
    this will save everything because all array lists and instances of other classes are stored in the admin class
    must use try and except to catch any errors

function readfile:
    this function will use file input stream to read from data.txt
    and return the data to an instance of admin
    try and except must be used to catch and class not found erros and IO exceptions
    otherwise it returns null that will indicate to the main function that a new admin needs to be created.

-----Admin.java-----
    this class is the brains of the operation
    will contain protected array lists of each furniture type for the reason of sortness. 
    the default admin will default to 00000 and 12345
    it will use serializable so that it can be saved to data.txt
    have get and set methods for each variable that will or can be changed for redudancy such as getmoney get account num or get passcode
    a function will return all users

function listUsers:
    this will use for loop to iterate over users and print out each account number and passcode as well as the first name and last name.

function editInventory:
    using enhanced for loops search the asked inventory and ask what variable they will like to change
    the changeable variables will be price, description, and product ID
    other variables CAN be changed however it would not make much sense
    use try and except to catch any user input errors. 

function listInventory:
    iterate over each array list and print each index as well as the class specific variables
    using each the inherited furnture methods and children class specfic ones. 

function listOrders;
    same idea as above but iterate over orders array list and print out the product id and address

function findUser:
    this is an important method
    using a for loop index over the array list till the passed account number and passcode is found and return that object
    otherwise return null

function removeProduct:
    this method will be used when a order is completed and "shipped"
    using traditional loop because java did not like .remove
    find the id and remove it from the array list of inventory as well as the order list as it technically has been completed

function findID:
    this method is used once to make sure the product ID the user wants to buy exists and then only pass the object onto orders

-----Furniture.java------
this is an abstract class that will and cannot be initilized directly. 
the only methods will be constructor and constructor with parameters that all children class can use. it will have variables that ALL sub classes will use so that code does not need to be copy and pasted between very similar classes
it will also contain methods to set and get these variables that all sub classes will inherit as generic methods.

-----chair.java-----
this is an extension of furniture class and will has two unique variables of arm rests and whether the chair has wheels or not. with constructors as well and some unique to the class methods that set and get those unique variables

-----Sofa.java-----
also an extension of furniture class and will have its own special variables like amount of seats, shape, reciler seats, or seat warmers
also have constructors as well as set and get methods specific to this class

-----table.java------
this is also an extension of furniture class that will have sub class specific like amount of legs, shape, material, and whether the height is ajustable or not 
constructors as well as sub class specific getter and setter methods

-----ordered.java-----
this class will be on its on and will be very simple with only address and product ID as variables
it will have constructors incase but it will only be initilized with parameters

has get and set method incase anything needs to be changed.


SELF NOTES:
    do not use one vector of inventory, Super class cannot and does not know it has children, cannot access subclass methods to print class specific variables
    use a tradional loop to find and remove ordered invetory, from what I can tell is due to how array lists iterate and .remove works on it compared to how it works on vectors.
    switch to array lists instead of vectors to try something new and potentially faster.
    split what you can into seperate lists or functions so debugging can be made way easier. 
