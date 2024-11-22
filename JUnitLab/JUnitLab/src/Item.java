class Item {
    double price;
    int stock;
    String desc;
    int sold;

    Item(double price, int numPieces, String desc) {
        this.price = price;
        this.stock = numPieces;
        this.sold = 0;
    }

    void restock(int amount) {
        this.stock = this.stock + amount;
    }

    int getStock(){
        return this.stock;
    }

    int getSold(){
        return this.sold;
    }

    String getDesc(){
        return this.desc;
    }

    void purchase(int amount) {
        this.stock = this.stock - amount;
        this.sold += amount;
    }
}