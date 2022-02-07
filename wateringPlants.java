
//public class wateringPlants {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
import java.util.*;
import java.io.*;

public class wateringPlants {
    public static void main(String args[]) {
        Scanner sc  = new Scanner(System.in);
        int noPlants = sc.nextInt();
        int capacity = sc.nextInt();
        int can = capacity;
        int[] plants = new int[noPlants];
        for(int i = 0; i<noPlants; i++){
            plants[i] = sc.nextInt();
        }
        int steps = 0;
        for(int i = 0; i<noPlants; i++){
            if(can>=plants[i]){
                steps++;
                can-=plants[i];
            }
            else{
                can = capacity;
                steps+=((2*i)+1);
                can-=plants[i];
            }
        }
        System.out.println(steps);
    }

    // public static int refill(int){

    // }
}