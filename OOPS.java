import java.io.*;

import javax.print.event.PrintJobListener;
class person{
    int age;
    String name;
    public person(int age,String name){
        this.age=age;
        this.name=name;
    }
    public void getDetails(){
        System.out.println("age: "+age+"name: "+name);
    }

    public void printClass(){
        System.out.println("person");
    }
}
class Developer extends person{
    String github_user;
    public Developer(int age,String name,String github_user){
        super(age,name);
        this.github_user = github_user;
    }
    public void getDetails(){
         System.out.println("age: "+age+"name: "+name+ "github_user: "+github_user);
    }

    public void printClass(){
        System.out.println("Developer");
    }
}

class OOPS {
    public static void main (String[] args) {
        person p1 = new person(45,"mukul");
        person p2 = new Developer(23,"uday","udaysrinu@123");

        // person [] p = new person[]{p1,p2};//Reference to all the employees

        //int [] a =new int[]{1,2,3};
        // for(person people : p){
        //     people.getDetails();//additional attributes will be print
        //     people.printClass();
        // }
        p1.getDetails();
        p1.printClass();

        p2.getDetails();
        p2.printClass();
//         for(int x :arr){
//             x;
//         }
    }
}