class Item {
    double price;
    int stock;
    int sold;

    Item(double price, int numPieces) {
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

    void purchase(int amount) {
        this.stock = this.stock - amount;
        this.sold += amount;
    }
}