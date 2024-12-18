import java.util.ArrayList;
import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vendor {
    private static HashMap<String, Item> Stock = new HashMap<String,Item>();
    private double balance;

    Vendor(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy, "A sweet treat that can't be beat :]"));
        Stock.put("Gum", new Item(.5, numGum, "New a refresher? Try gum :]"));
        this.balance = 0;
    }

    /** resets the Balance to 0 */
    void resetBalance () {
        this.balance = 0;
    }

    /** returns the current balance */
    double getBalance () {
        return this.balance;
    }

    /** adds money to the machine's balance
     * @param amt how much money to add
     * */
    void addMoney (double amt) {
        this.balance = this.balance + amt;
    }

    /** attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void select (String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                item.purchase(1);
                this.balance = this.balance - item.price;
            }
            else
                System.out.println("Gimme more money");
        }
        else System.out.println("Sorry, don't know that item");
    }

    //Returns the stock of a specific item
    int getItemStock(String name){
        if (Stock.containsKey(name)){
            return Stock.get(name).getStock();
        }
        return 0;
    }

    //Returns sold value of a specific item
    int getItemSold(String name){
        if(Stock.containsKey(name)){
            return Stock.get(name).getSold();
        }
        return 0;
    }

    //Returns description of an item
    String getItemDec(String name){
        if(Stock.containsKey(name)){
            return Stock.get(name).getDesc();
        }
        return null;
    }

    //Restock items if unavailable so Vendor's inventory can change over time
    void restockItem(String name, double price, int amount, String dec){
        if (Stock.containsKey(name)){
            Stock.get(name).restock(amount);
        } else {
            Stock.put(name, new Item(price, amount, dec));
            System.out.println("Added " +name+ " for " + price + ". Inventory: " + amount);
        }
    }

    //Change the name of an item
    void renameItem (String name, String newName){
        if(Stock.containsKey(name)){
            Item item = Stock.remove(name);
            Stock.put(newName, item);
            System.out.println("Renamed " + name + " to " + newName);
        } else {
            System.out.println("Item name not found");
        }
    }

    //Printing list from Vendor
    void printVendorList(){
        System.out.println("List of current Vendor Inventory: ");
        //keySet() is a method in HashMap class that returns a set of items contained in Hashmap
        for (String itemName : Stock.keySet()){
            Item item = Stock.get(itemName);
            System.out.println(itemName +" :" + " Price:" + item.price + " Stock:" + item.stock);
        }
    }

    //Removes an item if discontinued
    short removeItem(String name){
        if(Stock.containsKey(name)){
            if(Stock.get(name).getStock() == 0){
                Stock.remove(name);
            }
        } else {
            System.out.println("No item listed");
        }
        return 0;
    }

    //Track customer purchase for each item and provide insight on result
    void soldItem(String name){
        if(Stock.containsKey(name)){
            Stock.get(name).getSold();
            if (Stock.get(name).getSold() >= 5){
                System.out.println("Popular");
            } else {
                System.out.println("Not popular");
            }
        }
    }

    //Check Item's description before purchasing
    void itemDesc(String name){
        if(Stock.containsKey(name)){
            Stock.get(name).getDesc();
        }
    }

    //Applies discounts to selected Items
    void itemDiscount(String name, int discount){
        if(Stock.containsKey(name)){
            double savings = Stock.get(name).price/100 * discount;
            double newPrice = Stock.get(name).price - savings;
            System.out.println("Discounted Item Price: " + newPrice);
        }
    }

    //Gets the discount from Item
    double getItemDiscount(String name, int discount) {
        double newPrice = 0;
        if (Stock.containsKey(name)) {
            double savings = Stock.get(name).price / 100 * discount;
            newPrice = Stock.get(name).price - savings;
        }
        return newPrice;
    }

    //Mark best-seller items based on getSold
    ArrayList<String> bestSellers = new ArrayList<>();
    void bestSellerItem(){
        System.out.println("Current Best-Sellers: ");
        for (String itemName : Stock.keySet()){
            Item item = Stock.get(itemName);
            if(item.sold >= 5){
                bestSellers.add(itemName);
            }
            System.out.println(bestSellers);
        }
    }

}

class Examples {
}

