package DataStructures_Wk1;

import java.util.*;

public class MaxSlidingWindow {

    //using deque
    public static void maxSlidingWin(int[] arr, int m, int arr_length){
        Deque<Integer> deque = new LinkedList<>();
        int start = 0;
        int end = start+ m - 1;
        for(int i = 0; i <= arr_length - 1;){
            while(!deque.isEmpty() && deque.peekFirst() < start){
                deque.removeFirst();
            }
            while(i <= end){
                if(deque.isEmpty() || arr[deque.peekLast()] > arr[i]){
                    deque.addLast(i);
                    i++;
                }else{
                    while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                        deque.removeLast();
                    }
                    deque.addLast(i);
                    i++;
                }
            }
            System.out.print(arr[deque.peekFirst()] + " ");
            start++;
            end++;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr_length = sc.nextInt();
        int[] arr = new int[arr_length];
        for(int i = 0; i < arr_length; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        maxSlidingWin(arr, m, arr_length);
    }
}
