package AnswerLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T>  implements Iterable<T>{
    private Node<T> head;
    private int size=0;

    public void add(T data){
        Node<T> node = new Node<>(data);

        //LinkedList가 비어있는 경우 : head에 넣어준다.
        if(size==0) {
            head = node;
        }else {
            //마지막 노드를 찾는다.
            Node<T> current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            //현재 current에는 가장 마지막 Node가 위치하고 있음
            // 마지막 노드의 next에 새로운 노드를 추가했다.
            current.setNext(node);
        }
        this.size++;
    }
    public T get(int index){
        //양 끝 경계값 예외처리
        if(size<0 || this.size <= index){
            throw new IndexOutOfBoundsException();
        }

        // index번째 노드를 찾는다.
        Node<T> current = this.head;
        for(int i=0;i<index;i++)
            current = current.getNext();

        return current.getData();
    }
    public void delete(int index){
        //양 끝 경계값 예외처리
        if(size<0 || this.size <= index){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            head = head.getNext();
        }else{
            // index번째 노드를 찾는다.
            Node<T> current = this.head;
            for(int i=0;i<index-1;i++){ // index-1노드랑 index+1를 연결시키기 위해 index-1 노드를 찾음.
                current = current.getNext();
            }
            // 직전 노드의 Next를 i+1번재 노드로 바꿔준다.
            current.setNext(current.getNext().getNext());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            //맨 처음부터 순회
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current !=null; //내가 null만 아니면 항상 다음이 있음.
            }

            @Override
            public T next() {
                // 다음이 있는지 먼저 확인하고, 있으면 동작
                if(!hasNext()){
                    throw new NoSuchElementException();
                }else{
                    T data = current.getData(); //현재 데이터를 따로 저장
                    current = current.getNext(); // 다음 노드로 넘김.
                    return data;
                }
            }
        };
    }
    // Stack, Queue 활용에 이용.
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size>0) return false;
        else return false;
    }
}
