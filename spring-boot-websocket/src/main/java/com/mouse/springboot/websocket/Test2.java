package com.mouse.springboot.websocket;

import java.util.Objects;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/28
 * @description
 */
public class Test2 {


    public Node merge(Node node1,Node node2){
        if (Objects.isNull(node1)){
            return node2;
        }

        if(Objects.isNull(node2)){
            return node1;
        }

        int node1value = node1.value;
        int node2value = node2.value;

        if (node1value<node2value){
            node1.next = merge(node1.next,node2);
            return node1;
        } else {
            node2.next = merge(node2.next,node1);
            return node2;
        }

    }

    static class Node{
        int value;
        Node next;
    }

}
