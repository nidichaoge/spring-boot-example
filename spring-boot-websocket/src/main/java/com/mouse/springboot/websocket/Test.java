package com.mouse.springboot.websocket;

/**
 * @author mouse
 * @version 1.0
 * @date 2020/5/28
 * @description
 */
public class Test {

    public static void main(String[] args) {
        int array[] = {1, 2, 2, 3, 4};
        findIndex(array, 3);
    }

    /**
     * @param array 有序数组
     * @param num
     * @return 比num大的数字的坐标
     */
    public static int findIndex(int[] array, int num) {
        for (int i=0;i<array.length;i++){
            if (array[i]>num){
                return i;
        }
        return -1;
    }

}
