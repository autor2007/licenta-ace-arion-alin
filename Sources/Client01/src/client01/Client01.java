/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.timer.Timer;

/**
 *
 * @author alinw3
 */
public class Client01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            //Compiling java code
            Process p;
            p=Runtime.getRuntime().exec("javac CodUser.java");
            p.waitFor();
         
            System.gc();
            //Running the java programe and timming the execution
            Process p2;
            Thread t1;
            
            long a=System.nanoTime();
            p2=Runtime.getRuntime().exec("java CodUser");
            p2.waitFor();
            long b=System.nanoTime();
            System.out.println(" "+((b-a)/1000000000.));
            
            //The verification of the output of the program
            int i=0;
            int[] number=new int[100];
            FileInputStream fstream = new FileInputStream("out.txt");
            
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            
            while ((strLine = br.readLine()) != null)   {
                number[i]=Integer.parseInt(strLine);
                i++;
            }
            
            i=0;
            int[] number2=new int[100];
            FileInputStream fstream2 = new FileInputStream("out_verify.txt");
            
            DataInputStream in2 = new DataInputStream(fstream2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
            String strLine2;
            
            while ((strLine2 = br2.readLine()) != null)   {
                number2[i]=Integer.parseInt(strLine2);
                i++;
            }
            
            //Verification if the output data is the same with the known correct data
            int ok=1;
            if(number.length==number2.length){
                for(int j=0;j<number.length;j++){
                    if(number[j]!=number2[j]){
                        ok=0;
                        break;
                    }
                }
            }else{
                ok=0;
            }
            System.out.println("ok= "+ok);
            
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
