package AnswerCart;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception{

        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // csv read
        BufferedReader br = null;
        String line;
        String path = "/Users/guswjd/Java/java-practice/src/AnswerCart/data.csv";
        List<Product> myProducts = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf-8"));

            // 한 줄씩 읽기
            while((line = br.readLine()) != null){
                // csv이므로 ,로 한 라인을 읽는다.
                String[] temp = line.split(",");

                // 파싱한 정보로 Product 생성
                Product product = new Product(temp[0],temp[1],Integer.parseInt(temp[2]));
                productSet.add(product);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("고유한 상품 목록: ");
        for(Product product : productSet){
            System.out.println(product.getName()+" : "+product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        myCart.addProduct(myProducts.get(0),1);
        myCart.addProduct(myProducts.get(1),2);


    }
}
