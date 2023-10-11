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
            String stringaRicevuta;
            int c = 0;
            
            System.out.println(num);
            do{
                
                c++;
                
                stringaRicevuta = in.readLine();
                
                if(Integer.parseInt(stringaRicevuta) < num){
                    
                    out.writeBytes("1" + "\n");

                }

                else if(Integer.parseInt(stringaRicevuta) > num){

                    out.writeBytes("2" + '\n');
            
                }

                else if(Integer.parseInt(stringaRicevuta) == num){

                    out.writeBytes("3" + '\n');
                    out.writeBytes(String.valueOf(c));
            
                }
                

                

            }while(Integer.parseInt(stringaRicevuta) != num);

            
            s.close();
            server.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
