package varianta.two.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    private String pattern = "(\\s)+|($)";

    /**
     *
     * @return arrayOfNumbers
     */
    public String[] numbers() {
        boolean result;
        float number;
        String[] arrayOfNumbers = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String inputString = scan.nextLine();
            for (String currentValue : inputString.split(pattern)) {
                try {
                    if (!currentValue.isEmpty()) {
                        number = Float.valueOf(currentValue);
                        result = true;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат чисел!");
                    result = false;
                    break;
                }
            }
            scan.close();
            if (result) {
                arrayOfNumbers = inputString.split(pattern);
            }
        }
        return arrayOfNumbers;
    }
    
    /**
     *
     * @param arrayOfNumbers
     */
    public void decNumbers(String[] arrayOfNumbers) {
        String[] arrayOfNumbersDec = arrayOfNumbers;
        int min;
        int min_i;
        String stringOut = "";
        for (int i = 0; i < arrayOfNumbersDec.length; i++) {
            /*Предполагаем, что первый элемент (в каждом
             подмножестве элементов) является минимальным */
            min = arrayOfNumbersDec[i].length();
            min_i = i;
            /*В оставшейся части подмножества ищем элемент,
             который меньше предположенного минимума*/
            for (int j = i + 1; j < arrayOfNumbersDec.length; j++) {
                //Если находим, запоминаем его индекс
                if (arrayOfNumbersDec[j].length() < min) {
                    min = arrayOfNumbersDec[j].length();
                    min_i = j;
                }
            }
            /*Если нашелся элемент, меньший, чем на текущей позиции,
             меняем их местами*/
            if (i != min_i) {
                String tmp = arrayOfNumbersDec[i];
                arrayOfNumbersDec[i] = arrayOfNumbersDec[min_i];
                arrayOfNumbersDec[min_i] = tmp;
            }
        }
        for (String str : arrayOfNumbersDec) {
            stringOut = stringOut +" "+ str;
        }
        System.out.println("Числа в порядке возрастания значений их длины - " + stringOut);
    }

    /**
     *
     * @param arrayOfNumbers
     */
    public void incNumbers(String[] arrayOfNumbers) {
        String[] arrayOfNumbersInc = arrayOfNumbers;
        int max;
        int max_i;
        String stringOut = "";
        for (int i = 0; i < arrayOfNumbersInc.length; i++) {
            /*Предполагаем, что первый элемент (в каждом
             подмножестве элементов) является минимальным */
            max = arrayOfNumbersInc[i].length();
            max_i = i;
            /*В оставшейся части подмножества ищем элемент,
             который меньше предположенного минимума*/
            for (int j = i + 1; j < arrayOfNumbersInc.length; j++) {
                //Если находим, запоминаем его индекс
                if (arrayOfNumbersInc[j].length() > max) {
                    max = arrayOfNumbersInc[j].length();
                    max_i = j;
                }
            }
            /*Если нашелся элемент, меньший, чем на текущей позиции,
             меняем их местами*/
            if (i != max_i) {
                String tmp = arrayOfNumbersInc[i];
                arrayOfNumbersInc[i] = arrayOfNumbersInc[max_i];
                arrayOfNumbersInc[max_i] = tmp;
            }
        }
        for (String str : arrayOfNumbersInc) {
            stringOut = stringOut + " "+str;
        }

        System.out.println("Числа в порядке убывания значений их длины - " + stringOut);
    }
}
