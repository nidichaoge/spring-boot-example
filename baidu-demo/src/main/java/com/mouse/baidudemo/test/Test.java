package com.mouse.baidudemo.test;

import java.util.LinkedList;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/13
 * @description
 */
public class Test {

    /**
     *
     * @param num1 数组1
     * @param m 实际数组元素
     * @param num2 数组2
     * @param n 实际数据元素
     */
    public static void merge(int[] num1,int m,int[] num2,int n){
        int i=m-1;
        int j=n-1;
        int k =m+n-1;
        while ((i>=0)&&(j>=0)){
            num1[k--] = (num1[i]<num2[j])?num2[j--]:num1[i--];
        }

        System.arraycopy(num2,0,num1,0,j+1);
    }

    public static void merge(LinkedList<Integer> linkedList,LinkedList<Integer> linkedList2){
        LinkedList newLink = new LinkedList<>();
        Integer first1 ;
        Integer first2 ;
        while (linkedList.size()!=0&&linkedList2.size()!=0){
            first1 = linkedList.getFirst();
            first2 = linkedList2.getFirst();
            if (first1<first2){
                newLink.add(first1);
                linkedList.remove(0);
            } else {
                newLink.add(first2);
                linkedList2.remove(0);
            }
        }

        if (linkedList.size()!=0){

        }
        if (linkedList2.size()!=0){

        }
    }

}
