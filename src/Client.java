import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket сlient = new Socket("127.0.0.1", 23489);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(сlient.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(сlient.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            String message;
            System.out.println("Добрый день!");
            while (true) {
                System.out.println("Введите число и степерь в которую хотите возвести число, через запятую !");
                message = scanner.nextLine();
                if ("end".equals(message)) break;
                out.println(message);


                System.out.println("SERVER: " + in.readLine());
            }
        }
    }
}
