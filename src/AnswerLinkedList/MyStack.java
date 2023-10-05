package AnswerLinkedList;

public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    // push
    // top에 원소를 추가한다.
    public void push(T item){
        list.add(item);
    }

    // pop
    public T pop(){
        // 아무것도 없는데 꺼내려고 하면 예외
        if(list.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int lastIndex = list.size()-1;
        T top = list.get(lastIndex);
        list.delete(lastIndex);
        return top;
    }
    // peek
    public T peek(){
        int lastIndex = list.size()-1;
        T top = list.get(lastIndex);
        return top;
    }
}
