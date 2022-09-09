import java.util.Scanner;

public class BinaryASCIIConverter {
    private static Scanner sc = new Scanner(System.in);

    public static void run(){
        System.out.println(
                """
                1. Text to binary
                2. Binary to text
                3. Quit
                Choice:\s
                """
        );
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1){
            textToBinary();
        }
        else if(choice ==2){
            binaryToText();
        }
    }

    private static void binaryToText(){
        System.out.println("Enter binary: ");
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String bin = sc.nextLine();
        int num = 16;
        int binNum = 0;
        String ans = "";
        String start = bin.substring(0,3);
        System.out.println(start);
        for (int i=3; i<bin.length();i++) {
            char bit = bin.charAt(i);
            if (bit == '1') {
                binNum += num;
            } else if (bit == ' ') {
                num = 32;
                System.out.println(binNum);
                //ans += abc.charAt(binNum - 64);
                if (start.equals("011")){
                    ans += lower.charAt(binNum-1);
                }
                else if (start.equals("010")){
                    ans += upper.charAt(binNum-1);
                }
                else{
                    ans += " ";
                }
                start = bin.substring(i+1,i+4);
                i+=3;
                binNum = 0;
            }
            num /= 2;
        }
        if (start.equals("011")){
            ans += lower.charAt(binNum-1);
        }
        else if (start.equals("010")){
            ans += upper.charAt(binNum-1);
        }
        else{
            ans += " ";
        }
        System.out.println(ans);
    }

    private static void textToBinary(){
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String ans = "";
        for (int i = 0;i < text.length();i++){
            int bin = text.charAt(i);
            System.out.println(bin);
            int num = 128;
            while (num >= 1) {
                System.out.println(num);
                System.out.println(bin);
                if (bin - num >= 0) {
                    bin -= num;
                    ans += "1";
                }
                else {
                    ans += "0";
                }
                num /= 2;
            }
            ans += " ";
            System.out.println(ans);
        }
        // String.charAT();
        // int ascii = String.charAt(i(;
    }
}
