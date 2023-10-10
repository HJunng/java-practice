package AnswerCart;

import java.util.Objects;

public class Product {
    private String key;
    private String name;
    private int price;

    public Product(String key, String name, int price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public String getKey() {
        return key;
    }


    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    // cmd+N -> 바로 만들 수 있음.
    @Override
    public boolean equals(Object o) { // key, name, price 가 모두 같아야 같은 걸로 확인할 것!
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        // 같은 key, 이름, 가격인 경우 true 를 리턴하도록 해줌.
        return price == product.price && Objects.equals(key, product.key) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }
}
