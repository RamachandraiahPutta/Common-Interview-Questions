package datastructures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList<Integer> sList = new LinkedList<Integer>();

        //Add nodes to the list
        sList.add(2);
        sList.add(3);
        sList.add(4);
        sList.add(5);
        sList.add(6);
        sList.add(7);
        sList.add(8);

        //Displays the nodes present in the list
        sList.display();

        sList.reverse();
        sList.display();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class LinkedList<T>{
    Node<T> head;
    Node<T> tail;

    public void  add(T data){

        Node<T> node = new Node<T>(data, null);

        if(Objects.isNull(head)) {
            head = node;
        }else {
            tail.next = node;
        }
        tail = node;
    }

    public void reverse(){
        tail = head;

        Node<T> current = head;
        Node<T> previous = null;
        Node<T> next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void display(){
        if (Objects.isNull(head)) {
            System.out.println("LinkedList is Empty");
        }else{
            Node pointer = head;
            while (Objects.nonNull(pointer)){
                System.out.print(pointer.data+ " ");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class  Node<T>{
    T data;
    Node<T> next;
}
