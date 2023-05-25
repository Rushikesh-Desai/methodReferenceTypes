package main.java;

import java.util.Arrays;
import java.util.function.*;

@FunctionalInterface
interface Display {
    void display();
}

public class Main {
    public void myMethod() {
        System.out.println("method reference in java 8");
    }

    public static void main(String[] args) {

        Main obj = new Main();

        Display ref1 = obj::myMethod;   // Reference to the method using the object of the class myMethod

        ref1.display(); // Calling the method inside the functional interface main.java.Display

        Display ref2 = new Display() {
            @Override
            public void display() {
                obj.myMethod();
            }
        };
        ref2.display();

        Television sonyTV = new Television("Sony", 10000);
        Watchable watchableAnonymousClass = new Watchable() {                     //  sonyTV::warranty;
            @Override
            public void watch() {
                sonyTV.warranty();
            }
        };
        watchableAnonymousClass.watch();

        Watchable watchableLambda = () -> sonyTV.warranty();
        watchableLambda.watch();

        Watchable watchableMethodReference = sonyTV::warranty;  //  Method references to an instance method via object of a class.
        watchableMethodReference.watch();

        Television lgTV = new Television("LG", 15000);
        Watchable watchable = lgTV::watch;  //  Method references to an instance method via object of a class.
        watchable.watch();
        lgTV.connectivity();        //<---  Accessing static method through instance reference.

        Watchable miTV = new Television("MI", 12000, 2)::warranty;  //  Method references to an instance method via object of a class.
        miTV.watch();

        //  Method references to an instance method via instance of a class is also called as Bounded Receiver
        Watchable samsungTV = new Television()::warranty;  //  Method references to an instance method via object of a class.
        samsungTV.watch();

        Watchable renewed = new Watchable() {
            @Override
            public void watch() {
                new Television().watch();
            }
        };
        renewed.watch();

        //  Method Reference to a static method of a class.
        Watchable zudioTV = new Watchable() {
            @Override
            public void watch() {
                Television.connectivity();
            }
        };
        Watchable asusTV = Television::connectivity;    //  Method references to a static method via "Classname".
        asusTV.watch();                     // Method references to a static method via instances of a class is not possible.
        // e.g. new main.java.Television()::connectivity; This is not possible.
        // but a static method can be accessed via instances of that class.
        // This is not recommended but it is possible.

        //  Method references to a Constructor
        // Method references to the default no-args constructor via "Classname".
        // Default no-args constructor must be declared for this method reference to work.
        Supplier<Watchable> watchableSupplier = Television::new;
        System.out.println(watchableSupplier.get());

        //  Method references to an instance method of a specific class via arbitrary object of that class.
        //  This is also called as Unbounded Receiver.
        //  This looks similar to Method References to a static method but both are different.
        String[] names = new String[]{"Jack", "Sandra", "Joey", "Bob", "Anna"};
        Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.setAll(names, (int i) -> names[i].toUpperCase());
        System.out.println(Arrays.toString(names));
        System.out.println("-".repeat(70));

        Arrays.asList(names).replaceAll(String::toLowerCase);
        System.out.println(Arrays.toString(names));
//        System.out.println("-".transform(70));

    }
}