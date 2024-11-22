public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Ultra Shop!");
        System.out.println("Maintained by <A human>");

        //Add 5 new Vendors
        Vendor vendor1 = new Vendor(5,5);
        Vendor vendor2 = new Vendor(10, 10);
        Vendor vendor3 = new Vendor(15, 15);
        Vendor vendor4 = new Vendor(20,20);
        Vendor vendor5 = new Vendor(25,25);

        //Create vendorManager & added vendors
        VendorManager vendorManager = new VendorManager();
        vendorManager.addVendor(vendor1);
        vendorManager.addVendor(vendor2);
        vendorManager.addVendor(vendor3);
        vendorManager.addVendor(vendor4);
        vendorManager.addVendor(vendor5);

        //Print vendor inventory
        vendorManager.printVendorInventory();

    }
}