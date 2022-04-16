import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ComplexCalculations {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(23489);

        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String line;
                String [] massLine;

                while ((line = in.readLine()) != null) {
                    massLine = line.split(",");
                    out.println(pow(massLine[0],massLine[1]));
                }

                    if (line.equals("end")) {
                        break;
                    }


            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public static String pow(String message, String message2) {
        String result = Integer.toString((int) Math.pow(Integer.parseInt(message), Integer.parseInt(message2)));
        return result;
    }

}
// Был выбран Blocking вид, потому что важно чтобы поток был блокирован
// при записи и потом при чтении, чтобы получить правильный ответ, чтобы поток не прервался и ответ был бы верным,
// если поток прирвется, то мы можем получить неверное число.
