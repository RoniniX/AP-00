package Server.Model.Chatroom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Amir Iravanimanesh
 * @date 6/6/2021
 */
public class ChatServer {
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();
    private ArrayList<Socket> sockets;

    public ChatServer(ArrayList<Socket> sockets) {
        this.sockets = sockets;
        execute();
    }

    public void execute() {

        System.out.println("Chat Server is listening on port " + port);

        for (Socket socket : sockets) {
            UserThread newUser = new UserThread(socket, this);
            userThreads.add(newUser);
            newUser.start();
        }
        try {
            Thread.sleep(30000);
            broadcast("300", null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delivers a message from one user to others (broadcasting)
     */
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    /**
     * Stores username of the newly connected client.
     */
    void addUserName(String userName) {
        userNames.add(userName);
    }

    /**
     * When a client is disconneted, removes the associated username and UserThread
     */
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    /**
     * Returns true if there are other users connected (not count the currently connected user)
     */
    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }
}