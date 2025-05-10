package com.github.LeilaM99.Librarary.Managment.System;

public class Node <T>{

        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

}
