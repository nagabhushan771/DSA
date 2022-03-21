

import java.io.*;

// public class vehicle{
//     private String mode;
    
// }
class Counter2{  
    static int count=0;//will get memory only once and retain its value  
      
    Counter2(){  
    count++;//incrementing the value of static variable  
    System.out.println(count);  
    } 
}

class A{
    
    final String name;
    A(){
        name = "nagu";
    }
    public static void main(String[] args){
        System.out.println("main of A");
    }
    A getA(){  
    return this;  
    }  
    final void msg(){System.out.println("Hello java");}  
    final void msg(String name){
        System.out.println("Hello "+this.name);
    }
}

public class oopsConcepts extends A{
    public static void main(String[] args){
        // Counter2 c1=new Counter2(); 
        // c1.count++;
        // System.out.println(c1.count);
        System.out.println("main of oopsConcepts");
        new A().getA().msg();
        new A().msg("Nags"); 
    }
    // public static void main(String args){System.out.println("main with String");}  
    // public static void main(){System.out.println("main without args");}
    // public static void main(String[] args){System.out.println("main with String[]");}  
  
}
