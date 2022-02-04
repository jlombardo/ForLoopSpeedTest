package net.byteshop.util.forloopspeedtest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This class is used as a demonstration of speed of 
 * execution differences between various looping alternatives, from the original 
 * (pre JDK 5) for-loop to modern stream/lambda techniques. While these tests 
 * are open to vagaries caused by things like warm-up time, fit-for-purpose, 
 * amount and difficulty of work done, etc., they are still useful in 
 * contemplating which technique you may want to use.<br>
 * <br>
 * It should come as no surprise that the original for-loop is almost always the 
 * fastest, with the one exception being the Lambda Stream loop in the 
 * Double test.<br>
 * <br>
 * For best results run the tests multiple times. You will get different 
 * results each time, though the overall ranking will be the same. You should 
 * also change the size of the collection (mostly smaller) to again see different 
 * results, though not as great as you might expect.
 * 
 * 
 * @author Jim Lombardo, jlombardo@byteshop.net
 * @version 1.00
 * @since JDK 8
 */
public class ForLoopSpeedTest {
    public static List<String> strList = Collections.nCopies(500000, "a string");
    public static List<Integer> intList = Collections.nCopies(500000, 25);
    public static List<Double> dblList = Collections.nCopies(500000, 25.01);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testStrListEnhancedForEachLoop();
        testStrListForEachLoopLambda();
        testStrStreamForEachLoopLambda();
        testStrOrigForEachLoop();
        testIntListEnhancedForEachLoop();
        testIntListForEachLoopLambda();
        testIntStreamForEachLoopLambda();
        testIntListOrigForEachLoop();
        testDoubleListEnhancedForEachLoop();
        testDoubleListForEachLoopLambda();
        testDoubleStreamForEachLoopLambda();
        testDoubleListOrigForEachLoop();
    }
      
    /** 3RD FASTEST */
    public static void testStrStreamForEachLoopLambda() {
        LocalDateTime start = LocalDateTime.now();
        
        strList.stream().forEach((item) -> {
            int hash = item.hashCode();
        });
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Lambda Stream loop String test:\n" + diff.toMillis() + " msec\n");
    }
    
    /** 2ND FASTEST */
    public static void testStrListForEachLoopLambda() {
        LocalDateTime start = LocalDateTime.now();
        
        strList.forEach((item) -> {
            int hash = item.hashCode();
        });
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Lambda for-each String list test:\n" + diff.toMillis() + " msec\n");
    }

    /** SLOWEST BY A HUGE MARGIN  */
    public static void testStrListEnhancedForEachLoop() {
        LocalDateTime start = LocalDateTime.now();
        
        for (String s : strList) {
            int hash = s.hashCode();
        }
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Enhanced for loop String test:\n" + diff.toMillis() + " msec\n");
    }

    /** FASTEST */
    public static void testStrOrigForEachLoop() {
        LocalDateTime start = LocalDateTime.now();
        
        for (int i = 0; i < strList.size(); i++) {
            int hash = strList.get(i).hashCode();
        }
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Original for loop String test:\n" + diff.toMillis() + " msec\n");
    }
      
    public static void testIntStreamForEachLoopLambda() {
        LocalDateTime start = LocalDateTime.now();
        
        intList.stream().forEach((item) -> {
            int hash = item.hashCode();
        });
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Lambda Stream loop Integer test:\n" + diff.toMillis() + " msec\n");
    }
    
    public static void testIntListForEachLoopLambda() {
        LocalDateTime start = LocalDateTime.now();
        
        intList.forEach((item) -> {
            int hash = item.hashCode();
        });
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Lambda for-each Integer list test:\n" + diff.toMillis() + " msec\n");
    }

    public static void testIntListEnhancedForEachLoop() {
        LocalDateTime start = LocalDateTime.now();
        
        for (Integer i : intList) {
            int hash = i.hashCode();
        }
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Enhanced for loop Integer test:\n" + diff.toMillis() + " msec\n");
    }

    public static void testIntListOrigForEachLoop() {
        LocalDateTime start = LocalDateTime.now();
        
        for (int i=0; i < intList.size(); i++) {
            int hash = intList.get(i).hashCode();
        }
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Original for loop Integer test:\n" + diff.toMillis() + " msec\n");
    }
      
    public static void testDoubleStreamForEachLoopLambda() {
        LocalDateTime start = LocalDateTime.now();
        
        dblList.stream().forEach((item) -> {
            double hash = item.hashCode();
        });
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Lambda Stream loop Double test:\n" + diff.toMillis() + " msec\n");
    }
    
    public static void testDoubleListForEachLoopLambda() {
        LocalDateTime start = LocalDateTime.now();
        
        dblList.forEach((item) -> {
            int hash = item.hashCode();
        });
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Lambda for-each Double list test:\n" + diff.toMillis() + " msec\n");
    }

    public static void testDoubleListEnhancedForEachLoop() {
        LocalDateTime start = LocalDateTime.now();
        
        for (Double d : dblList) {
            int hash = d.hashCode();
        }
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Enhanced for loop Double test:\n" + diff.toMillis() + " msec\n");
    }

    public static void testDoubleListOrigForEachLoop() {
        LocalDateTime start = LocalDateTime.now();
        
        for (int i=0; i < dblList.size(); i++) {
            int hash = dblList.get(i).hashCode();
        }
        
        LocalDateTime end = LocalDateTime.now();
        Duration diff = Duration.between(start, end);
        System.out.println("Original for loop Double test:\n" + diff.toMillis() + " msec\n");
    }

}
