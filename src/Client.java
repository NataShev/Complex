import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket serverClient = new Socket("127.0.0.1", 23489);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(serverClient.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(serverClient.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            String message;
            System.out.println("Добрый день!");
            while (true) {
                System.out.println("Введите число, которое хотите возвести в степень!");
                message = scanner.nextLine();
                if ("end".equals(message)) break;
                out.println(message);
                System.out.println("Введите степень в которую хотите возвести число");
                String message2 = scanner.nextLine();
                out.println(message2);
                int result = pow(message, message2);
                System.out.println("Результат: " + result);

            }
        }
    }

    public static int pow(String message, String message2) {
        int result = (int) Math.pow(Integer.parseInt(message), Integer.parseInt(message2));
        return result;

    }
}
