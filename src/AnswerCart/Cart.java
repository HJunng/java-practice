package AnswerCart;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int amount){

        // 있으면 갯수를 더하고, 처음 나왔으면 새로 추가한다.
//        if(items.containsKey(product)){
//            items.put(product, items.get(product)+amount);
//        }else{
//            items.put(product,amount);
//        }
        // 기존에 있는 item을 병합해준다. -> Integer::sum 신기..!
        items.merge(product, amount, Integer::sum);
    }

    public void removeProduct(Product product, int amount){
        // 있으면 갯수를 빼고, 없으면 아무것도 하지 않는다.
        if(items.containsKey(product) && items.get(product) - amount >0){
            items.put(product,items.get(product)-amount);
        }
    }

    public void showItems(){
        System.out.println("=== show items in cart ===");
        for(Map.Entry<Product,Integer> entry : items.entrySet()){
            System.out.println(entry.getKey().getName()+" : "+entry.getValue());
        }
    }

    public Map<String,Integer> showItemsStream(){
        return items.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
    }
}
