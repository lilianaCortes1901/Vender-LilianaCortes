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
        item.restock(0);
        Assertions.assertEquals(0, item.stock);
    }

}