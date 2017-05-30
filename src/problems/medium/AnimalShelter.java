package problems.medium;

import java.util.LinkedList;

/**
 * Created by sherxon on 5/2/17.
 */
/**
* this problem also can be solved using one linked list. however it takes the same amount of space
 * and much longer time.
* */
public class AnimalShelter {
    LinkedList<Integer> dogs =new LinkedList<>();
    LinkedList<Integer> cats =new LinkedList<>();

    void pushCat(Integer cat){
        cats.push(cat);
    }
    void pushDog(Integer dog){
        cats.push(dog);
    }
    void popDog(Integer dog){
        dogs.pollFirst();
    }
    void popCat(Integer cat){
        cats.pollFirst();
    }

}
