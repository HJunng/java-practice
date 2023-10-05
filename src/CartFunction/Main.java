package CartFunction;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // 상품 목록 추가
        productSet.add(new Product("우유",2000));
        productSet.add(new Product("계란",3500));
        productSet.add(new Product("과자",1200));
        productSet.add(new Product("사과",1000));

        // 상품 목록 확인
        System.out.println("--- 고유한 상품 목록 ---");
        for(Product product: productSet){
            System.out.println(product.getName()+" : "+product.getPrice());
        }
        System.out.println();

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct("우유",3);
        myCart.addProduct("사과",5);
        myCart.addProduct("과자",1);

        //장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        myCart.showItems();

        // 상품을 장바구니에서 제거
        myCart.removeProduct("우유",1);
        myCart.removeProduct("사과");

        //장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        myCart.showItems();

    }
}
