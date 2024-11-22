import java.util.ArrayList;

/**
 * Class for managing multiple Vendors - User Story feature 4
 * System will support 5 different vendors, each with unique items and prices.
 * */

public class VendorManager {
    private ArrayList<Vendor> vendors;

    VendorManager(){
        this.vendors = new ArrayList<>();
    }

    //Adds new Vendor to vendors list
    void addVendor(Vendor vendor){
        vendors.add(vendor);
        System.out.println("New Vendor added.");
    }

}
