package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if((inputArray == null)||(inputArray.length == 0)){
            return  new int[]{};
        }
        int[] outputArray = new int[inputArray.length];
        for(int i=0;i < inputArray.length - 1;i++){
            outputArray[i+1] = inputArray[i];
        }
        outputArray[0] = inputArray[inputArray.length - 1];
        return outputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if((inputArray == null)||(inputArray.length == 0)){
            return 0;
        }
        int max1 = -1;
        int max2 = -1;
        int max_i = -1;
        for (int i=0;i < inputArray.length;i++){
            if (inputArray[i] > max1) {
                max1 = inputArray[i];
                max_i = i;
                }
        }
        for (int i=0;i < inputArray.length;i++){
            if ((inputArray[i] > max2)&&(i != max_i)) {
                max2 = inputArray[i];
            }
        }
        if (max2 == -1){
            return inputArray[0];
        }
        return max1*max2;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if((input == null)||(input.equals(""))){
           return 0;
        }
        input = input.toLowerCase();
        char[] in = input.toCharArray();
        int k = 0;
        for(int i=0; i < in.length; i++){
            if ((in[i] == 'a')||(in[i] == 'b')){
                k++;
            }
        }
        return k*100/in.length;
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if(input == null){
            return false;
        }
        if(input.equals("")){
            return true;
        }
        char[] in = input.toCharArray();
        boolean check = true;
        for (int i = 0; i < in.length/2; i++){
            if (in[i] != in[in.length - i - 1]){
                check = false;
            }
        }
        return check;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if((input == null)||(input.equals(""))){
            return "";
        }
        char[] in = input.toCharArray();
        String out = "";
        char x = in[0];
        int k = 0;
        for (int i = 0; i < in.length; i++){
            if (in[i] == x) {
                k++;
            }
            else {
                out = out + x + k;
                x = in[i];
                k = 1;
            }
        }
        out = out + x + k;
        return out;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if((one == null)||(two == null)||(one.equals(""))||(two.equals(""))){
            return false;
        }
        int[] storage = new int[96];
        Arrays.fill(storage, 0);
        char[] s1 = one.toCharArray();
        char[] s2 = two.toCharArray();
        for (int i=0; i < s1.length; i++){
            storage[(int)s1[i] - 32]++;
        }
        for (int i=0; i < s2.length; i++){
            storage[(int)s2[i] - 32]--;
        }
        for (int i=0; i < storage.length; i++){
            if (storage[i] != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if((s == null)||(s.equals(""))){
            return false;
        }
        char[] in = s.toCharArray();
        for(int i=0; i < in.length - 1; i++){
            for(int j=i+1; j < in.length; j++){
                if (in[i] == in[j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if ((m == null)||(m.length == 0)){
            return new int[][]{{},{}};
        }
       for (int i = 0; i < m.length; i++){
           for (int j = i; j < m[0].length; j++){
               int buf = m[i][j];
               m[i][j] = m[j][i];
               m[j][i] = buf;
           }
       }
       return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        String ans = "";
        if ((inputStrings == null)||(inputStrings.length == 0)){
            return ans;
        }
        if (separator == null){
            separator = ' ';
        }
        for(int i=0; i < inputStrings.length - 1; i++){
            ans = ans + inputStrings[i] + separator;
        }
        ans = ans + inputStrings[inputStrings.length - 1];
        return ans;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if ((inputStrings == null)||(inputStrings.length == 0)||(prefix == null)){
            return 0;
        }
        char[] newprefix = prefix.toCharArray();
        if (newprefix.length == 0){
            return 0;
        }
        int k = 0;
        for (int i = 0; i < inputStrings.length; i++){
            char[] str = inputStrings[i].toCharArray();
            if (str.length == 0){
                continue;
            }
            label:for (int j = 0; j < str.length - newprefix.length;j++){
                if (str[j] == newprefix[0]){
                    if (newprefix.length > 1) {
                        for (int y = 1; y < newprefix.length; y++) {
                            if (str[j+y] != newprefix[y]){
                                break label;
                            }
                        }
                        k++;
                    }
                    else {
                        k++;
                    }
                    break;
                }
            }
        }
        return k;
    }
}
