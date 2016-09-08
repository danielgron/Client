package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class Client {

    private static boolean clientRunning = true;
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);

        String host;
        int port;
        if (args.length == 2) {
            host = args[0];
            port = Integer.parseInt(args[1]);
        } else {
            return;
        }
        Socket socket;
        try {
            socket = new Socket(host, port);
            ClientController cc = new ClientController(socket);

            while (clientRunning) {
                System.out.println("Test:");
                cc.sendMessage(input.nextLine());

            }
            cc.runClient();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
