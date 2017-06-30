/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package varianta.two.action;

import java.util.Scanner;

/**
 *
 * @author Sukhocheva Maryana
 */
public class Action {
    
    String pattern = "(\\s)+|($)";

    /**
     *
     * @return
     */
    public String[] Numbers() {
        boolean result;
        float number;
        String[] masNum = null;
        try (Scanner scan = new Scanner(System.in)) {
            result = false;
            String str = scan.nextLine();
            for (String retval : str.split(pattern)) {
                try {
                    if (!retval.isEmpty()) {
                        number = Float.valueOf(retval);
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
                masNum = str.split(pattern);
            }
        }
        return masNum;
    }
    
    /**
     *
     * @param masDec
     */
    public void DecNumbers(String[] masNum) {
        String[] masDec=masNum;
        int min;
        int min_i;
        String strOut = "";
        for (int i = 0; i < masDec.length; i++) {
            /*Предполагаем, что первый элемент (в каждом
             подмножестве элементов) является минимальным */
            min = masDec[i].length();
            min_i = i;
            /*В оставшейся части подмножества ищем элемент,
             который меньше предположенного минимума*/
            for (int j = i + 1; j < masDec.length; j++) {
                //Если находим, запоминаем его индекс
                if (masDec[j].length() < min) {
                    min = masDec[j].length();
                    min_i = j;
                }
            }
            /*Если нашелся элемент, меньший, чем на текущей позиции,
             меняем их местами*/
            if (i != min_i) {
                String tmp = masDec[i];
                masDec[i] = masDec[min_i];
                masDec[min_i] = tmp;
            }
        }
        for (String str : masDec) {
            strOut = strOut +" "+ str;
        }
        System.out.println("Числа в порядке возрастания значений их длины - " + strOut);
    }

    /**
     *
     * @param masInc
     */
    public void IncNumbers(String[] masNum) {
        String[] masInc=masNum;
        int max;
        int max_i;
        String strOut = "";
        for (int i = 0; i < masInc.length; i++) {
            /*Предполагаем, что первый элемент (в каждом
             подмножестве элементов) является минимальным */
            max = masInc[i].length();
            max_i = i;
            /*В оставшейся части подмножества ищем элемент,
             который меньше предположенного минимума*/
            for (int j = i + 1; j < masInc.length; j++) {
                //Если находим, запоминаем его индекс
                if (masInc[j].length() > max) {
                    max = masInc[j].length();
                    max_i = j;
                }
            }
            /*Если нашелся элемент, меньший, чем на текущей позиции,
             меняем их местами*/
            if (i != max_i) {
                String tmp = masInc[i];
                masInc[i] = masInc[max_i];
                masInc[max_i] = tmp;
            }
        }
        for (String str : masInc) {
            strOut = strOut + " "+str;
        }

        System.out.println("Числа в порядке убывания значений их длины - " + strOut);
    }
}
