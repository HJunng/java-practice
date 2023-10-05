package CartFunction;

import java.util.Objects;

public class Product {
    private int key;
    private String name;
    private int price;
    public Product(String name, int price){
        this.name=name;
        this.price=price;
        this.key=hashCode();
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || getClass() !=o.getClass()) return false;

        Product p = (Product) o;
        return Objects.equals(key,p.key);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.name);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
