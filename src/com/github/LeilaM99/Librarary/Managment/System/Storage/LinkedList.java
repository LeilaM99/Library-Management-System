package com.github.LeilaM99.Librarary.Managment.System.Storage;

public class LinkedList<T> {

        public Node<T> head;

        public LinkedList() {
            head = null;
        }

        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public void remove(T data) {
            if (head == null) return;

            if (head.data.equals(data)) {
                head = head.next;
                return;
            }

            Node<T> temp = head;
            while (temp.next != null && !temp.next.data.equals(data)) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        public T search(T data) {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.data.equals(data)) {
                    return temp.data;
                }
                temp = temp.next;
            }
            return null;
        }

        public void display() {
            Node<T> temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }


}
