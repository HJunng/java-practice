package AnswerLinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        // add
        myLinkedList.add(1);


        //get
        System.out.println("---get---");

        //delete
        myLinkedList.delete(1);

        System.out.println("---loop---");
        for(Integer item : myLinkedList){
            System.out.println(item);
        }
    }

}
