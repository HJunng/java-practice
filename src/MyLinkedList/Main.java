package MyLinkedList;

import java.util.*;

public class Main {
    public static class MyLinkedList<E> implements Iterable<E> {

        private int size; //원소 개수
        private Node<E> head; //첫번째 노드

        private class Node<E>{
            E data; //값 저장할 때 쓰이는 변수
            Node<E> next; //다음 노드를 가르킬 변수

            public Node(E data) {
                this.data = data;
                this.next = null;
            }
        }

        //MyLinkedList 생성자
        public MyLinkedList() {
            this.head = null; //처음 LinkedList를 만들면 head는 비어있다.
            size=0;
        }
        //add함수
        public boolean add(E element) {
            Node<E> newNode = new Node<>(element); //element를 새로운 node에 집어넣기.

            //첫번째 노드이면,
            if(head == null) {
                head = newNode;
            }else {
                Node<E> current = head; //첫번째 노드 탐색
                //헤더의 다음 노드를 계속 탐색, 다음 노드가 null이 아닐 때까지 탐색.
                while(current.next!=null) { current=current.next; } //연결된 item 끝까지 탐색하
                current.next = newNode; //탐색 다 하면 마지막에 element 추가.
            }
            size++; //사이즈 늘림.

            return true;
        }
        //get함수: 해당 index 칸에 들어있는 값 반환.
        public E get(int index) {
            if(index<0 || size<=index) //조회하려는 Index가 list 크기를 넘으면
                throw new IndexOutOfBoundsException(); //인덱스 오류

            Node<E> current = head;
            for(int i=0;i<index;i++) {
                current=current.next;
            }
            return current.data;
        }
        // delete함수: index번째 노드의 데이터를 삭제합니다.
        public E delete(int index) {
            if(index<0 || size<=index) //조회하려는 Index가 list 크기를 넘으면
                throw new IndexOutOfBoundsException(); //인덱스 오류

            E deleteData;
            if(index==0) { // head를 바꿔야 하는 경우
                deleteData = head.data;
                head = head.next; //head를 그 다음 노드로 바꿔줌.
            }else {
                Node<E> current = head;
                for(int i=0;i<index-1;i++) {
                    current=current.next;
                }
                deleteData = current.next.data;
                current.next=current.next.next; //삭제해야 하는 node 이전 노드와 다음 노드 연결.
            }
            size--;//사이즈 줄임.
            return deleteData;
        }
        @Override
        public Iterator<E> iterator() {
            // TODO Auto-generated method stub
            return new MyIterator();
        }

        private class MyIterator implements Iterator<E> {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return current != null; //현재 노드가 비어있는지.
            }

            @Override
            public E next() {
                // TODO Auto-generated method stub
                if(!hasNext()) throw new NoSuchElementException();

                E data = current.data; //현재 노드의 데이터를 반환하고
                current = current.next; //다음 노드를 가져옴.
                return data;
            }

        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        Iterator<Integer> it = list.iterator();

        /**
         *   하위과제 01: Iterator interface를 구현해 for-each로 순회 가능하도록 합니다.
         */

        MyLinkedList<Integer> mll = new MyLinkedList<>();
        mll.add(10); mll.add(20); mll.add(30);

        for(Integer item : mll) {
            System.out.println(item); //10, 20, 30 이 한줄씩 띄어서 출력된다.
        }

        /**
         *  하위 과제 02: MyLinkedList를 이용해서 Queue와 Stack을 구현해봅시다.
         */

        MyLinkedList<Integer> queue = new MyLinkedList<>();
        queue.add(1); queue.add(2); queue.add(3);
        // 1, 2, 3

        for(int i=0;i<queue.size;i++) System.out.println(queue.get(i));

        MyLinkedList<String> stack = new MyLinkedList<>();
        stack.add("안"); stack.add("녕");
        // 녕, 안

        for(int i=stack.size-1;i>=0;i--) System.out.println(stack.get(i));
    }
}
