package CartFunction;

import java.util.*;

public class Cart {
    private Map<String,Integer> cart;

    public Cart(){
        this.cart = new HashMap<>();
    }

    // 상품 추가
    public void addProduct(String item, int quantity){
        if(cart.containsKey(item)){ //기존에 있던 아이템이면 갯수 추가.
            cart.put(item, cart.get(item)+quantity);
        }else{ // 기존에 없던 아이템이면 아이템 추가.
            cart.put(item,quantity);
        }
    }

    // 상품 제거
    public void removeProduct(String item, int quantity){
        if(cart.containsKey(item)){ // 카트에 item이 담겨있는지 먼저 확인.
            if(cart.get(item)>quantity){ // cart에 quantity 개수만큼 있는지 확인.
                cart.put(item, cart.get(item)-quantity);
            }else{
                cart.remove(item);
            }
        }
    }
    public void removeProduct(String item){
        if(cart.containsKey(item)){
            cart.remove(item);
        }
    }

    // 장바구니에 담겨있는 상품들 출력
    public void showItems(){
        System.out.println("=== 장바구니 목록 ===");
        for(String item: cart.keySet()){
            System.out.println(item+" : "+cart.get(item));
        }
        System.out.println();
    }
}
