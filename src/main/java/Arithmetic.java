
// схема операций
public class Arithmetic {

    // результат выполнения для обычных чисел
    public  int getResultForArab(String expression) {

        String[] str = expression.trim().split("\\s+");

        int x1 = Integer.parseInt(str[0]);
        int x2 = Integer.parseInt(str[2]);

        return switch (str[1]) {
            case "+" -> x1 + x2;
            case "-" -> x1 - x2;
            case "*" -> x1 * x2;
            case "/" -> x1 / x2;
            default -> 0;
        };
    }

    // результат выполнения для римских чисел
    public  String getResultForRome(String expression) {

        String[] str = expression.trim().split("\\s+");

        int x1 = getNumberForRome(str[0]);
        int x2 = getNumberForRome(str[2]);

        return switch (str[1]) {
            case "-" -> getNumberForArab(String.valueOf(x1 - x2));
            case "+" -> getNumberForArab(String.valueOf(x1 + x2));
            case "*" -> getNumberForArab(String.valueOf(x1 * x2));
            case "/" -> getNumberForArab(String.valueOf(x1 / x2));
            default -> "0";
        };

    }

    // чтобы посчитать римские цифры,то их нужно перевести в арабские
    private int getNumberForRome(String number) {
        return Integer.parseInt( Data.arab.get(Data.rome.indexOf(number)));
    }

    // чтобы вывести ответ в римских цифрах, то нужно перевести арабские в римские
    private  String getNumberForArab(String number) {
        return Data.rome.get(Data.arab.indexOf(number));
    }

}
