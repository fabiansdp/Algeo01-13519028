/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Hafid Abi Daniswara
 */
public class IOFile {
   File f;
   JFileChooser pilihFile;
   ArrayList<String> lineread;
   boolean matriksAble = true;
   int kolomMatriks=0;
   public static String PATH_TXT = "/test/";
   //public IOFile(){}
   public IOFile(String filename){
       try {
           File cek = new File("README.md");
           String pths = String.copyValueOf(cek.getCanonicalPath().toCharArray(),0,cek.getCanonicalPath().length()-9);
           //System.out.println(cek.getCanonicalPath());
           f = new File(pths+PATH_TXT+filename+".txt");
           lineread = new ArrayList<>();
           Scanner sc = new Scanner(f);
           int count =0;
           while(sc.hasNextLine()){
                String temp = sc.nextLine();
                lineread.add(temp);

           }
           sc.close();
           for(int x=0;x<lineread.size();x++){
                int c = 0;
                sc = new Scanner(lineread.get(x));
                while (sc.hasNext()){
                    String temp = sc.next();
                    try{
                        Double.parseDouble(temp);
                    }catch (NumberFormatException e){
                        System.out.println(e);
                        matriksAble = false;
                    }
                    c++;
                }

                if(c!=count && x>0){
                    matriksAble=1==2;
                }else{
                    count = c;
                }
                sc.close();
           }

           if(matriksAble){
                kolomMatriks=count;
           }
           //System.out.println(matriksAble);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
           matriksAble = false;
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public Matriks getMatriks(){
       if(matriksAble){
            Matriks ret = new Matriks(lineread.size(),kolomMatriks,1==2);
            for(int x=0;x<lineread.size();x++){
                int count =0;
                Scanner sc = new Scanner(lineread.get(x));
                while(sc.hasNext()){
                    String tmp = sc.next();
                    ret.mtrx[x][count] = (float) Double.parseDouble(tmp);
                    count++;
                }
            }
            return ret;
       }else{
           System.out.println("Tidak ada matriks valid di file ini");
           return new Matriks(0,0,0);
       }
   }

   public static boolean writeMatriks(Matriks matriks,String filename){
       File cek = new File("README.md");
       String pths="";
       try {
           pths = String.copyValueOf(cek.getCanonicalPath().toCharArray(),0,cek.getCanonicalPath().length()-9);
       } catch (IOException e) {
           e.printStackTrace();
       }

       String newpath = pths+PATH_TXT+filename+".txt";
       File file = new File(newpath);
       String teks="";
       try{
           if(!file.exists()){
               file.createNewFile();
               file.setWritable(1==1);

               for(int x=0;x<matriks.getBaris();x++){
                   for(int y=0;y<matriks.getKolom();y++){
                       teks = teks+matriks.getElement(x,y)+" ";
                   }
                   teks = teks+"\n";
               }

               byte[] b = teks.getBytes();
               Files.write(Paths.get(newpath),b);
               return true;
           }else{
               return false;
           }
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
   }

}  
