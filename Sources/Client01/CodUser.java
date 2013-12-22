/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package coduser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author alinw3
 */
public class CodUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i=0;
        int[] number=new int[100];
        try{
            FileInputStream fstream = new FileInputStream("input.in");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                number[i]=Integer.parseInt(strLine);
                i++;
            }
            //Close the input stream
            in.close();
            int numarDeDate=i;
            int[] rez=new int[100];
            for(int k=0;k<numarDeDate;k++){
                rez[k]=1;
                for(int j=2;j<=number[k];j++){
                    rez[k]*=j;
                }
            }
            FileWriter outstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(outstream);
            for(int j=0;j<numarDeDate;j++){
                out.write(rez[j]+"\n");
            }
            out.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        
        
    }
    
}
