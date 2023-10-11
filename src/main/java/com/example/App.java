package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Server Partito!" );

        try {

            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();
            
            System.out.println("client collegato");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            int num = (int)(Math.random()*101);

            System.out.println("prova ad indovinare");

            String stringaRicevuta = in.readLine();
            
            int c = 0;

            while(Integer.parseInt(stringaRicevuta) != num){

                if(Integer.parseInt(stringaRicevuta) < num){
                    
                    out.writeBytes("num troppo piccolo");

                }

                else if(Integer.parseInt(stringaRicevuta) > num){

                    out.writeBytes("num troppo grande");
            
                }

                c++;

            }

            System.out.println("Stringa indovinata");
            out.writeBytes("Hai indovinato in: " + num + " tentativi");
            
            s.close();
            server.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
