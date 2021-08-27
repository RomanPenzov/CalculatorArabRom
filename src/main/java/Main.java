import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Would!!!");

        Scanner scanner = new Scanner(System.in);
        CheckingTheFormat checkingTheFormat = new CheckingTheFormat();
        Arithmetic arithmetic = new Arithmetic();
        String inputStr = "";

        while (true) {
            System.out.println("введите выражение: ");
            System.out.println("если хотите выйти введите 1: ");
            inputStr = scanner.nextLine() + " ";

            if (inputStr.equals("1")) break;

            System.out.println("ответ:");

            if (checkingTheFormat.check(inputStr) == Format.ARAB) {
                System.out.println(arithmetic.getResultForArab(inputStr));
            }

            if (checkingTheFormat.check(inputStr) == Format.ROME) {
                System.out.println(arithmetic.getResultForRome(inputStr));
            }

            if (checkingTheFormat.check(inputStr) == Format.NUN){
                System.err.println("ваше число не входит в диапазон 1-10 I-X!");
            }
        }

    }
}
