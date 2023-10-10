package AnswerCart;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.
        Product product1 = new Product("1","칫솔",1000);
        Product product2 = new Product("2","치약",2000);
        productSet.add(product1);
        productSet.add(product2);

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct(product1,3);
        myCart.addProduct(product2,2);
        myCart.showItems();

        // 추가 테스트
        System.out.println("remove again");
    }
}
