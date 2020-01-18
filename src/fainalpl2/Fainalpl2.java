/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fainalpl2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.swing.JFrame;

/**
 *
 * @author Fady Fayek
 */
public class Fainalpl2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
                 JFrame frame=new JFrame();
		ThreatsClass game=new ThreatsClass();
		frame.setBounds(10,10,700,600);
		frame.setVisible(true);
		//frame.setBackground(Color black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(game);
       /* int [] arr={1,2,8,5,7,81,7};
        int key=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("enter key");
        key=scan.nextInt();
        long time=fun(key);
        System.out.println((double)time);*/
        
        
    }
    public static long fun(int key)
    {
        long start=System.currentTimeMillis();
        int c=0;
        for (int i = 0; i <key; i++) {
            c++;
        }
        long end=System.currentTimeMillis();
        return (end-start);
    }
}
