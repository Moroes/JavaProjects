import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[1000];
        int A = -100;
        int B = 100;

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) Math.round((Math.random() * B) - A);
        }
        sortStatistic(myArray);
        System.out.println("Результат парсера: " + (digitParser("-123s") + 122));
    }

    public static void sortStatistic(int[] myArray){
        long startTime = System.nanoTime();
        mySort(myArray);
        long endTime = System.nanoTime();
        long mySortTime = endTime - startTime;

        startTime = System.nanoTime();
        Arrays.sort(myArray);
        endTime = System.nanoTime();
        long arraySortTime = endTime - startTime;
        System.out.println("Встроенная сортировка лучше самописной сортировки в "
                + (mySortTime / arraySortTime) + " раз");
    }

    public static void mySort(int[] array) {
        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = array[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;    // меняем местами наименьший с array[i]
        }
    }

    public static int digitParser(String str){
        boolean isNegative = str.charAt(0) == '-';
        int firstIndex = isNegative ? 1 : 0;
        str = str.substring(firstIndex);
        int resultInt = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                resultInt *= 10;
                resultInt += Character.getNumericValue(c);
            }
        }
        if (isNegative){
            resultInt *= -1;
        }
        return resultInt;
    }
}