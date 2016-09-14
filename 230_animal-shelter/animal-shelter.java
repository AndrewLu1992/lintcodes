/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Java
@Datetime: 16-08-02 07:44
*/

public class AnimalShelter {
    //Implementation in double queue
    private class Animal {
        String name;
        int index;
        public Animal(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }
    
    private int total;
    private LinkedList<Animal> dog;
    private LinkedList<Animal> cat;
    
    public AnimalShelter() {
        // do initialize if necessary
        total = 0;
        dog = new LinkedList<Animal>();
        cat = new LinkedList<Animal>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        // Write your code here
        total += 1;
        if (type == 1) {
            dog.add(new Animal(name, total));
        } else {
            cat.add(new Animal(name, total));
        } 
    }

    public String dequeueAny() {
        // Write your code here
        if (dog.isEmpty()) {
            Animal firstCat = cat.removeFirst();
            return firstCat.name;
        } else if (cat.isEmpty()) {
            Animal firstDog = dog.removeFirst();
            return firstDog.name;
        } else {
            int catTime = cat.getFirst().index;
            int dogTime = dog.getFirst().index;
            if (catTime < dogTime) {
                return cat.removeFirst().name;
            } else {
                return dog.removeFirst().name;
            }
        }
    }

    public String dequeueDog() {
        // Write your code here
        if (dog.size() == 0) {
            return "";
        }
        return dog.removeFirst().name;
    }

    public String dequeueCat() {
        // Write your code here
        if (cat.size() == 0) {
            return "";
        }
        return cat.removeFirst().name;
    }
}
