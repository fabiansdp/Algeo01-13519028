/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesalgeo;

/**
 *
 * @author Hafid Abi Daniswara
 */
public class TubesAlgeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Matriks mat = new Matriks(3,3);
      mat.tampilinMatriks();
        System.out.println("");
        System.out.println("determinan = "+mat.getDeterminan());
        mat.getInverse().tampilinMatriks();
        System.out.println("=====================");
        mat.getMinor().tampilinMatriks();
        System.out.println("=====================");
        mat.getKofaktor().tampilinMatriks();
        System.out.println("=====================");
        mat.getTranspose().tampilinMatriks();
    }
    
}
