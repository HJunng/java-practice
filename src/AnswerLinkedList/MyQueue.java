package AnswerLinkedList;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    // enqueue
    public void enqueue(T item){
        list.add(item);
    }

    // dequeue
    public T dequeue(){
        // 비어있는데 꺼내려고 하면 오류.
        if(list.isEmpty()){
            throw new IllegalStateException();
        }
        T frontItem = list.get(0);
        list.delete(0);
        return frontItem;
    }

    // peek
    public T peek(){
        if(list.isEmpty()){
            throw new IllegalStateException();
        }
        return list.get(0);
    }
}
