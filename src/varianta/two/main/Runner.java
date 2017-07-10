package varianta.two.main;

import varianta.two.action.Action;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Runner {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Введите несколько чисел и нажмите <Enter>:");
        Action action = new Action();
        String[] arrayOfNumbers=action.numbers();
        if (arrayOfNumbers!=null) {
        action.decNumbers(arrayOfNumbers);
        action.incNumbers(arrayOfNumbers);
        }
        
    }
  
}
