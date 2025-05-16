package com.github.LeilaM99.Librarary.Managment.System.dS;

public class Node <T>{

        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

}
