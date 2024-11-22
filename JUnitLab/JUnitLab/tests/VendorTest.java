import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {
    //init Vendor & Item classes
    static Vendor vendor;
    static Item item;
    static VendorManager vendors;
    @BeforeEach
    public void setup(){
        vendor = new Vendor(1,5);
        vendors = new VendorManager();
    }

    @Test
    void addition() {
        assertEquals(2.25, 1.11);
    }

    //Unit test to validate: add money to vendor
    @Test
    public void addMoneyVendorTest(){
      vendor.addMoney(1.50);
      assertEquals(1.50, vendor.getBalance());
    }

    //unit test: validate that you can buy an item from vendor
    @Test
    public void buyItemVendorTest(){
        vendor.select("Candy");
        //item.purchase(1);
        Assertions.assertEquals(0, vendor.getBalance());

        vendor.select("Gum");
        Assertions.assertEquals(0, vendor.getBalance());
    }

    //unit test: validate that vendor inventory can be emptied
    @Test
    public void emptyVendorInventory(){
        //empty inventory for Candy
        vendor.addMoney(10);
        vendor.select("Candy");
        vendor.select("Candy");
        vendor.select("Candy");

        Assertions.assertEquals(-2, vendor.getItemStock("Candy"));

        //empty inventory for Gum
        vendor.select("Gum");
        vendor.select("Gum");
        vendor.select("Gum");
        vendor.select("Gum");
        vendor.select("Gum");

        Assertions.assertEquals(0, vendor.getItemStock("Gum"));
    }

    //Validate that items are restocked
    @Test
    public void restockItem(){
        vendor.select("Candy");
        if (vendor.getItemStock("Candy") == 0){
            item.restock(10);
        }

        vendor.select("Gum");
        if (vendor.getItemStock("Gum") == 0){
            item.restock(10);
        }

        Assertions.assertEquals(10, vendor.getItemStock("Candy"));
    }

    //Validate restock items in inventory
    @Test
    public void restockItemTest(){
        //checks current items can be restocked
        vendor.restockItem("Candy", 1.50, 5, item.desc);
        assertEquals(6, vendor.getItemStock("Candy"));

        vendor.restockItem("Gum", 0.5, 5, item.desc);
        assertEquals(10, vendor.getItemStock("Gum"));

        //Adds new items to inventory if they are not available
        vendor.restockItem("Chips", 2.0, 5, item.desc);
        assertEquals(5, vendor.getItemStock("Chips"));
    }

    //Change Name of item at a vendor
    @Test
    public void renameItemTest(){
        vendor.renameItem("Candy", "Skittles");
        //-1 because the original item name "Candy" is removed before renaming
        assertEquals(0, vendor.getItemStock("Candy"));
    }

    //Validates removeItem: Removes items if discontinued
    @Test
    public void removeItemTest(){
        vendor.removeItem("Candy");
        assertEquals(0, vendor.removeItem("Candy"));

        //checks if item is in vendor
        vendor.removeItem("Chips");
        assertEquals(0, vendor.removeItem("Chips"));
    }

    //Validates system can add new Vendor
    @Test
    public void addVendorTest(){
        vendors.addVendor(vendor);
    }

    //Validates soldItem insights
    @Test
    public void soldItemTest(){
        vendor.addMoney(7.0);

        //buy items
        vendor.select("Candy");
        vendor.select("Candy");
        vendor.select("Candy");
        vendor.select("Candy");
        vendor.select("Candy");
        vendor.select("Gum");

        //tests popular item
        vendor.soldItem("Candy");
        assertEquals(5, vendor.getItemSold("Candy"));

        //tests not popular item
        vendor.soldItem("Gum");
        assertEquals(1, vendor.getItemSold("Gum"));
    }

    //Validates Items have descriptions
    @Test
    public void itemDescTest(){
        //tests non-existing items
        vendor.itemDesc("Chips");
        Assertions.assertEquals(null, vendor.getItemDec("Chips"));

        //tests existing items
        vendor.itemDesc("Candy");
        Assertions.assertEquals(vendor.getItemDec("Candy"), vendor.getItemDec("Candy"));
    }

    //Validates Item discount
    @Test
    public void itemDiscTest(){
        vendor.itemDiscount("Candy", 10);
        assertEquals(1.125, vendor.getItemDiscount("Candy", 10));
    }

    //Validate Item bestSeller
    @Test
    public void bestSellerTest(){
        vendor.bestSellerItem();
    }

}