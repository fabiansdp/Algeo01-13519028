/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package tubesalgeo;

import static java.lang.Math.pow;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Hafid Abi Daniswara
 */
public class Matriks {
    int baris;
    int kolom;
    float determinan;
    float[][] mtrx;
    //boolean isMinor = false;
    //boolean isCofactor = false;

    /* KONSTRUKTOR */
    public Matriks(int baris, int kolom){
        this.baris  = baris;
        this.kolom = kolom;
        this.mtrx = new float[baris][kolom];
        isiMatriks();
        this.determinan = this.getDeterminanLokal(mtrx);
    }
    
    public Matriks(int baris, int kolom, float determinan){
        this.baris  = baris;
        this.kolom = kolom;
        this.mtrx = new float[baris][kolom];
        this.determinan = determinan;
    }
    
    /* CLASS RESET*/
    public void resetMatriks(int baris,int kolom){
        this.baris = baris;
        this.kolom = kolom;
        this.mtrx = new float[baris][kolom];
        this.isiMatriks();
        this.determinan = this.getDeterminanLokal(mtrx);
    }
    
    public void resetMatriks(){
        this.isiMatriks();
        this.determinan = this.getDeterminanLokal(mtrx);
    }
    
    /* BASIC GETTER AND SETTER */
    
    public boolean isMatrixSquare(){
        return (kolom==baris)&&(kolom>0&&baris>0);
    }
    
    private boolean isInversable(){
        return (this.getDeterminan()!=0) && (this.getBaris()==this.getKolom());
    }
    
    public int getBaris(){
        return this.baris;
    }
    
    public int getKolom(){
        return this.kolom;
    }
    
    public float getElement(int row,int col){
        return this.mtrx[row][col];
    }
    
    public void setElement(int row, int col, float value){
        this.mtrx[row][col] = value;
    }
    
    public void tampilinMatriks(){
        for(int x=0;x<baris;x++){
            for(int y=0; y<kolom;y++){
                DecimalFormat df = new DecimalFormat("##.##");
                System.out.print(df.format(this.mtrx[x][y])+" ");
            }
            System.out.println("");
        }
    }
    
    /* OPERASI MATRIKS KALI TAMBAH KURANG */

    public void KaliBaris ( int i, double num){
        // Kita validasi Barisnya dulu
        // Baris tidak valid bila berada dibawah 0 dan diatas baris
        if (i < 0 || i > baris){
            System.out.printf("Baris tidak valid");
        }
        else{
            for (int j = 0; j < kolom; j ++ ){
                this.mtrx[i][j] *= num;
                // Jadi baris tersebut akan dikali dengan double num untuk semua kolomnya dari 0 sampai jumlahKolom-1
            }
        }
    }
    
    public Matriks KaliMatriks(Matriks M1, Matriks M2){
        Matriks res = new Matriks(M1.baris, M1.kolom,M1.determinan);
        for (int i = 0; i < res.baris; i++){
            for (int j = 0; j < res.kolom; j++){
                res.mtrx[i][j] = 0;
                for (int k = 0; k < this.kolom; k++){
                    res.mtrx[i][j] += M1.mtrx[i][j] * M2.mtrx[i][j];
                }
            }
        }
        res.determinan = getDeterminan();
        return res;
    }

    public void TambahBaris ( int i, int j){
         // Kita validasi Barisnya dulu
        // Baris tidak valid bila berada dibawah 0 dan diatas baris
        if (i < 0 || i > baris){
            System.out.printf("Baris tidak valid");
        }
        else{
            for (int k = 0; k < kolom; k ++ ){
                this.mtrx[i][k] += this.mtrx[j][k];
            }
        }
    }
    public Matriks TambahMatriks(Matriks M1, Matriks M2){
        Matriks res = new Matriks(M1.baris, M1.kolom,M1.determinan);
        for (int i = 0; i < res.baris; i++){
            for (int j = 0; j < res.kolom; j++){
                res.mtrx[i][j] = 0;
                for (int k = 0; k < this.kolom; k++){
                    res.mtrx[i][j] += M1.mtrx[i][j] + M2.mtrx[i][j];
                }
            }
        }
        res.determinan = getDeterminan();
        return res;
    }


    public void KurangBaris ( int i, int j){
         // Kita validasi Barisnya dulu
        // Baris tidak valid bila berada dibawah 0 dan diatas baris
        if (i < 0 || i > baris){
            System.out.printf("Baris tidak valid");
        }
        else{
            for (int k = 0; k < kolom; k ++ ){
                this.mtrx[i][k] -= this.mtrx[j][k];
            }
        }
    }

    public Matriks KurangMatriks(Matriks M1, Matriks M2){
        Matriks res = new Matriks(M1.baris, M1.kolom,M1.determinan);
        for (int i = 0; i < res.baris; i++){
            for (int j = 0; j < res.kolom; j++){
                res.mtrx[i][j] = 0;
                for (int k = 0; k < this.kolom; k++){
                    res.mtrx[i][j] += M1.mtrx[i][j] - M2.mtrx[i][j];
                }
            }
        }
        res.determinan = getDeterminan();
        return res;
    }

    /* ADVANCE GETTER (DETERMINAN, INVERS, MINOR, COFACTR, TRANSPOSE) */
    
    public float getDeterminan(){
        if(this.isMatrixSquare()){
            return this.determinan;
        }else{
            System.out.println("matriks tidak memiliki determinan");
            return 0;            
        }
    }
    
    public Matriks getInverse(){
        
        if(this.isInversable()){
            Matriks result = new Matriks(this.baris,this.kolom,(1/determinan));
            result = this.getAdjoin();
            int l = this.baris;
            int a,b;
            for(a=0;a<l;a++){
               for(b=0;b<l;b++){
                   result.mtrx[a][b] = result.mtrx[a][b]/this.determinan;
               }
           }
           
           return result;
        }else{
            //System.out.println("tidak bisa di Invers, karena matriks tidak persegi atau determinan==0 adalah benar");
            return new Matriks(0,0,0);
        }
    }
    
    public Matriks getAdjoin(){
       Matriks res = new Matriks(this.baris,this.kolom,this.determinan);
        if(this.isMatrixSquare()){
            res.mtrx = this.getTranspose(getKofaktor().mtrx);
            return res;
        }else{
            //System.out.println("tidak punya adjoin karena tidak ada minor dan kofaktor");
            return null;
        }
    }
    
    public Matriks getMinor(){
        if(this.isMatrixSquare()){
            Matriks temp = new Matriks(this.baris,this.kolom,this.determinan);
            int brs = temp.baris;
            int kol = temp.kolom;
            
            for(int a=0;a<brs;a++){
                for(int b=0;b<kol;b++){
                    //debugarr(this.getMatriksNonSejajar(a, b));
                    temp.mtrx[a][b] = this.getDeterminanLokal(this.getMatriksNonSejajar(a, b));
                }
            }
        return temp;
        }else{
            return null;
        }
    }
    
    public Matriks getKofaktor(){
        Matriks temp=null;
        temp = this.getMinor();
        
        if(temp!=null && this.isMatrixSquare()){
            int brs = temp.baris;
            int klm = temp.kolom;
            int a,b;
            
            for(a=0;a<brs;a++){
                for(b=0;b<klm;b++){
                    if((a+b)%2==1 && temp.mtrx[a][b]!=0){
                        temp.mtrx[a][b]= temp.mtrx[a][b]*(-1);
                    }
                }
            }
        }
        
        return temp;
    }
    
    public Matriks getTranspose(){
        Matriks res = new Matriks(this.kolom,this.baris,this.determinan);
        int a,b;
        for(a=0;a<res.baris;a++){
            for(b=0;b<res.kolom;b++){
                res.mtrx[a][b]= this.mtrx[b][a];
            }
        }
        
        return res;
    }
    
    /* DAPUR INTERNAL, BIAR GA DIPAKE AMA PUBLIK */
    
    private float[][] getMatriksNonSejajar(int i, int j){
        
        int a,b; int countRow=0,countCol=0;
        int brs = this.baris;
        int kol = this.kolom;
        float[][] temp = new float[brs-1][kol-1];
        
        for(a=0;a<brs;a++){
            for(b=0;b<kol;b++){
                if(a!=i && b!=j){
                    temp[countRow][countCol]= this.mtrx[a][b];
                    countCol++;
                }
            }
            if(a!=i){countRow++;countCol=0;}
        }
        
        return temp;
    }
    
    private float getDeterminanLokal(float[][] Mat){
        int brs = Mat.length;
        int kol = Mat[0].length;
        //System.out.println(brs+" "+kol);
        if((brs==kol)&&brs==2&&kol==2){
            float r = (Mat[0][0]*Mat[1][1])-(Mat[0][1]*Mat[1][0]);
            return r;
        }else if(brs==kol){
            float[][] newarr = new float[brs-1][kol-1];
            float det =0;
            for(int x=0;x<kol;x++){
                for(int a=1;a<brs;a++){
                    int count =0;
                    for(int b=0;b<kol;b++){
                        if(b!=x){
                            newarr[a-1][count] = Mat[a][b];
                            //System.out.print(Mat[a][b]+" ");
                            count++;
                        }
                    }
                    //System.out.println("");
                }
                
                float detsementara= (float) pow(-1,x)*Mat[0][x]*this.getDeterminanLokal(newarr);
                det = det+detsementara;
            }
            return det;
        }else{
            return 0;
        }
    }
    
    private void isiMatriks(){
        Scanner scanner = new Scanner(System.in);
        int a,b;
        for(a=0;a<this.baris;a++){
            for(b=0;b<this.kolom;b++){
                this.mtrx[a][b] = scanner.nextFloat();
            }
        }
    }
    
    private float[][] getTranspose(float[][] M){
        int row = M.length;
        int col = M[0].length;
        float[][] res = new float[col][row];
        
        if(M!=null){
            int a,b;
            for(a=0;a<col;a++){
                for(b=0;b<row;b++){
                    res[a][b] = M[b][a];
                }
            }
        }
        
        return res;
    }
    
    // private void debugarr(float[][] debugee){
    //     int a,b;
    //     System.out.println("======================");
    //     System.out.println("**  MATRIX DEBUG   ***");
    //     System.out.println("======================");
    //     for(a=0;a<debugee.length;a++){
    //         for(b=0;b<debugee[0].length;b++){
    //             System.out.print(debugee[a][b]+" ");
    //         }
    //         System.out.println("");
    //     }
        
    //     System.out.println("----END--DEBUG---------\n");
    // }
    
    
    /*  == KODE TIDAK TERPAKAI (TAPI SIAPA TAU NANTI KEPAKE HEHE) ==
    public void setToMinored(){
        if(this.isMatrixSquare()){
            if(!this.isMinor){
              this.mtrx = this.getMinor();
              this.isMinor = 1==1;
          }  
        }else{
            System.out.println("Matriks tidak bisa diminorkan");
        }
        
    }
    
    
    
    public void deMinorMatrix(){
        if(this.isMinor&&this.isCofactor){
            this.isMinor = false;
            this.isCofactor= false;
            this.mtrx = this.getKofaktor();
        }else if(this.isMinor){
            this.isMinor = false;
            this.mtrx = this.getMinor();
        }else{
            System.out.println("matriks sudah dalam kondisi semula");
        }
    }
    
    public void setToCofactored(){
        if(this.isMatrixSquare()){
                if(!this.isCofactor){
                this.mtrx=this.getKofaktor();
                this.isCofactor=2>1;
            }
        }else{
            System.out.println("Matriks tidak bisa dikofaktorkan");
        }
        
    }
    
    public void setToTransposed(){
        this.mtrx = this.getTranspose(this.mtrx);
        int temp = this.baris;
        this.baris = this.kolom;
        this.kolom = temp;
    }
    
    public void setToInversed(){
        if(this.isInversable()){
            this.mtrx = this.getInverse();
            this.isCofactor=false;
            this.isMinor = false;
        }else{
            System.out.println("matriks ga punya balikan");
        }
    } 
    */
}
