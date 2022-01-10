import java.util.Scanner;

class test{

    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            int nextNum = b;
            int dif = b-a;
            int i = 0;

            for(i = 0; i<k; i++){
                nextNum = nextNum + dif;
                System.out.print(nextNum);
                System.out.print(" ");
            }
            sc.close();
        }
    }
}