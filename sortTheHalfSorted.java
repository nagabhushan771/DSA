//
//public class sortTheHalfSorted {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
import java.io.*;
import java.util.*;
public class sortTheHalfSorted {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arrf = new int[n];


        int a,b=0;
        arr1[0] = sc.nextInt();
        int flag = 0;
        
        for(int i = 1; i<n; i++){
            a = sc.nextInt();
            
            if((a >= arr1[i-1]) && (flag == 0)){
                arr1[i] = a;
            } else if((a<arr1[i-1]) && (flag == 0)){
                b=i;
                arr2[i-b] = a;
                flag = 1;
            } else {
                arr2[i-b] = a;
            }
        }
        int p = 0;
        int q = 0;
        int r = 0;
        while(p<b && q<n-b){
            if(arr1[p]<arr2[q]){
                arrf[r++] = arr1[p++];
            } else {
                arrf[r++] = arr2[q++];
            }
        }
        if(p == b){
            while(q<n-b){
                arrf[r++] = arr2[q++];
            }
        } else {
            while(p<b){
                arrf[r++] = arr1[p++];
            }
        }

        for(int i = 0; i<n; i++){
            System.out.print(arrf[i]+" ");
        }
    }
}