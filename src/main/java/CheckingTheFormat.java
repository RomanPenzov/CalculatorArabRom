
// проверка введенного выражения
public class CheckingTheFormat  {


    public Format check(String expression) throws Exception {

        // разбиваемем строку на символы
        String[] str = expression.trim().split("\\s+");

        // проверка на правильность выражения из 2 чисел и 1 знака
        if (str.length < 3)
            throw new Exception("строка не является математической операцией");

        // проверка на наличие операции
        if (!(str[1].equals("-") || str[1].equals("+") || str[1].equals("/") || str[1].equals("*")))
            throw new Exception(" такой операции нет!");


        // проверка на пербор чисел 1 + 2 + 5 и т.д
        if (str.length > 3)
            throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        // название ошибки говорит само за себя
        if (isRome(str[0]) && isArab(str[2]) || isArab(str[0]) && isRome(str[2]))
            throw new Exception("используются одновременно разные системы счисления");

        // если ввели римские числа
        if (isRome(str[0]) && isRome(str[2])) {
            // проверяем знак т.к нужно обработать случай их отрицательного ответа
            if (str[1].equals("-")) {
                if (isPositionRome(str[0], str[2]))
                    throw new Exception("результат не может быть отрицательным, т.к. " +
                            "в римской системе нет отрицательных чисел");
            }
            return Format.ROME;
        }

        // если числа обычные
        if (isArab(str[0]) && isArab(str[2])) {
            return Format.ARAB;
        }
        // выход за диапазон 1-10 I - X
        return Format.NUN;
    }

    // смотрим арабское ли число
    private boolean isArab(String x) {
        for (int i = 0; i < 10; i++) {
            if (x.equals(Data.arab.get(i))) return true;
        }
        return false;
    }

    // смотрим римское ли число
    private boolean isRome(String x) {
        for (int i = 0; i < 10; i++) {
            if (x.equals(Data.rome.get(i))) return true;
        }
        return false;
    }

    // проверяем, чтобы для разности между римскими числами не было отрицательного числа
    private boolean isPositionRome(String rome1, String rome2) {
        return (Data.rome.indexOf(rome1) - Data.rome.indexOf(rome2)) < 0;
    }

}
