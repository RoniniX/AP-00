package Project.Client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * The type Write thread.
 *
 * @author Amir Iravanimanesh
 * @date 6 /7/2021
 */
public class WriteThread extends Thread {
    /**
     * The constant writer.
     */
    public static PrintWriter writer;
    private final Socket socket;
    private final ChatClient client;

    /**
     * Instantiates a new Write thread.
     *
     * @param socket the socket
     * @param client the client
     */
    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        String userName = scanner.nextLine();
        client.setUserName(userName);
        writer.println(userName);

        String text;
        do {
            text = scanner.nextLine();
            if (ChatClient.type)
                writer.println(text);

        } while (!text.equals("bye"));
        try {
            socket.close();
        } catch (IOException ex) {

            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send to server.
     *
     * @param string the string
     */
    public void sendToServer(String string) {
        writer.println(string);
    }
}
