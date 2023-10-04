package CartFunction;

import java.util.*;

public class Main {

    static class Product { // 상품 클래스.
        int key;
        String name;
        int price;
        public Product(String name, int price){
            this.key=hashCode();
            this.name=name;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public int getKey() {
            return key;
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
            return this.hashCode();
        }
    }

    class CartItem{
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity){
            this.product=product;
            this.quantity=quantity;
        }
        public Product getProduct(){
            return product;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }
    }
    class Cart{
        private List<CartItem> items = new ArrayList<>();

        public void addProduct(Product product, int quantity){
            // 기존에 있던 아이템이면 갯수 추가.
            for(CartItem item : items){
                if(item.getProduct().getKey() == product.getKey()){
                    item.setQuantity(item.getQuantity()+quantity);
                    return;
                }
            }
            // 새로운 아이템이면 list에 추가.
            items.add(new CartItem(product,quantity));
        }
        public void removeProduct(Product product){
            items.removeIf(item -> item.getProduct().getKey() == product.getKey());
        }
        public List<CartItem> getItems(){
            return items;
        }
    }
    public static void main(String[] args) {

        //상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // 상품 목록 추가
        productSet.add(new Product("우유",2000));
        productSet.add(new Product("계란",3500));
        productSet.add(new Product("과자",1200));

        // 상품 목록 확인
        System.out.println("고유한 상품 목록: ");
        for(Product product: productSet){
            System.out.println(product.getName()+" : "+product.getPrice());
        }

        // 장바구니 생성


    }
}
