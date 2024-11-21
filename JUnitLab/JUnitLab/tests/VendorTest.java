import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {
    //init Vendor & Item classes
    static Vendor vendor;
    static Item item;
    @BeforeEach
    public void setup(){
        vendor = new Vendor(1,5);
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
        vendor.restockItem("Candy", 1.50, 5);
        assertEquals(6, vendor.getItemStock("Candy"));
    }

    //Change Name of item at a vendor
    @Test
    public void renameItem(){

    }

}