
import java.util.Scanner;

public class Basics {

    public static void main(String[] args) {
        System.out.println("Hello World");

        // Byte Data Type -128 to 127 (8 bits / 1 byte)
        byte num = 100;
        System.out.println(num);

        // Short data type 16 bits 2 bytes
        short snum = 200;
        System.out.println(snum);

        // Integer Data Type -2^31 to 2^31 - 1
        int inum = 74291;
        System.out.println(inum);

        // float data type and double data type for decimal types
        // float for 6-7 precision points for bigger precision use double
        double dnum = 5.6;
        System.out.println(dnum);

        char ch = 'a';
        System.out.println(ch);

        // Can only store true or false
        boolean boolval = true;
        System.out.println(boolval);

        int num1 = 5;
        int num2 = 10;
        int add = num1 + num2;
        int sub = num2 - num1;
        int mul = num1 * num2;
        int div = num2 / num1;
        System.out.println(add + " " + sub + " " + mul + " " + div);

        String s = "Arihant";
        System.out.println(s.length());
        System.out.println(s.charAt(2));

        Scanner sc = new Scanner(System.in);
        int inputNumber = sc.nextInt();
        System.out.println(inputNumber);
        String firstName = sc.next();
        String lastName = sc.next();
        String aSentence = sc.nextLine();
        System.out.println(firstName + " " + lastName + aSentence);
        sc.close();

        // Constants are declared using Final Keyword
        final int const1 = 10;
        // const = 11 will throw an error.
        System.out.println(const1);
    }
}
