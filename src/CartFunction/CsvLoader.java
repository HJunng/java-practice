package CartFunction;

import java.io.*;
import java.util.*;
public class CsvLoader {
    public static Set<Product> loadProduct(String filename){
        Set<Product> productList = new HashSet<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){

            String line;
            boolean isHeader =true;

            while((line = br.readLine()) != null){ // 한줄을 읽어들여 null이 아닐때까지 반복.
                //헤더 라인은 스킵
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                String[] values = line.split(",");

                if(values.length >= 2){
                    String name = values[0];
                    int price = Integer.parseInt(values[1]);

                    Product product = new Product(name,price);
                    productList.add(product);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return productList;
    }

    public static void main(String[] args) {
        Set<Product> products = loadProduct("경로.csv");

        // 상품 목록 확인
        System.out.println("--- 고유한 상품 목록 ---");
        for(Product product: products){
            System.out.println(product.getName()+" : "+product.getPrice());
        }
    }
}
