/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package tubesalgeo;

import static java.lang.Math.pow;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Hafid Abi Daniswara
 */
public class Matriks {
    int baris;
    int kolom;
    double determinan;
    double[][] mtrx;
    //boolean isMinor = false;
    //boolean isCofactor = false;

    /* KONSTRUKTOR */
    public Matriks(int baris, int kolom, boolean diIsiJuga){
        this.baris  = baris;
        this.kolom = kolom;
        this.mtrx = new double[baris][kolom];
        if(diIsiJuga){
            isiMatriks();
            this.determinan = this.getDeterminanLokal(mtrx);
        }
    }
    
    public Matriks(int baris, int kolom, double determinan){
        this.baris  = baris;
        this.kolom = kolom;
        this.mtrx = new double[baris][kolom];
        this.determinan = determinan;
    }
    
    /* CLASS RESET*/
    public void resetMatriks(int baris,int kolom){
        this.baris = baris;
        this.kolom = kolom;
        this.mtrx = new double[baris][kolom];
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
    
    public double getElement(int row,int col){
        return this.mtrx[row][col];
    }
    
    public void setElement(int row, int col, double value){
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
                    res.mtrx[i][j] += M1.mtrx[i][k] * M2.mtrx[k][j];
                }
            }
        }
        res.determinan = getDeterminan();
        return res;
    }
    public double SumKolom (int i){
        double temp = 0;
        for (int j = 0; j < this.baris;j++){
            temp += this.mtrx[j][i];
        }
        return temp;
    }

    public Matriks KaliKolom (int i,int j){
        Matriks res = new Matriks(this.baris, 1, false);
        for (int k = 0; k < res.baris; k++){
            res.mtrx[k][0] = this.mtrx[k][i] * this.mtrx[k][j];
        }
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
    
    public double getDeterminan(){
        if(this.isMatrixSquare()){
            this.determinan = this.getDeterminanLokal(this.mtrx);
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
    
    /* CRAMER */
    public Matriks Cramer (int size){
        Matriks M2 = new Matriks(this.baris, this.kolom-1,this.determinan);
        
        for (int i = 0; i < M2.baris;i++){
            for (int j = 0; j < M2.baris;j++){
                M2.mtrx[i][j] = this.mtrx[i][j];
            }
        }
        
        double D = M2.getDeterminan();
        
        if (size == 2){
            Matriks Mx = new Matriks(this.baris, this.kolom-1,this.determinan);
            Matriks My = new Matriks(this.baris, this.kolom-1,this.determinan);
            for (int i = 0; i < M2.baris;i++){
                for (int j = 0; j < M2.baris;j++){
                    if (j!=0){
                        Mx.mtrx[i][j] = this.mtrx[i][j];
                    }
                    if (j!=1){
                        My.mtrx[i][j] = this.mtrx[i][j];
                    }
                    
                }
            }

            for (int i = 0; i < M2.baris;i++){
                Mx.mtrx[i][0] = this.mtrx[i][3];
                My.mtrx[i][1] = this.mtrx[i][3];
            }
            double Dx = Mx.getDeterminan();
            double Dy = My.getDeterminan();
            double resX = Dx/D;
            double resY = Dy/D;
            Matriks Hasil = new Matriks(1, 2,1);
            Hasil.mtrx[0][0] = resX;
            Hasil.mtrx[0][1] = resY;
            return Hasil;
            
        }
        else if (size == 3){
            Matriks Mx = new Matriks(this.baris, this.kolom-1,this.determinan);
            Matriks My = new Matriks(this.baris, this.kolom-1,this.determinan);
            Matriks Mz = new Matriks(this.baris, this.kolom-1,this.determinan);
            for (int i = 0; i < M2.baris;i++){
                for (int j = 0; j < M2.baris;j++){
                    if (j!=0){
                        Mx.mtrx[i][j] = this.mtrx[i][j];
                    }
                    if (j!=1){
                        My.mtrx[i][j] = this.mtrx[i][j];
                    }
                    if (j!=2){
                        Mz.mtrx[i][j] = this.mtrx[i][j];
                    }
                    
                }
            }

            for (int i = 0; i < M2.baris;i++){
                Mx.mtrx[i][0] = this.mtrx[i][3];
                My.mtrx[i][1] = this.mtrx[i][3];
                Mz.mtrx[i][2] = this.mtrx[i][3];
            }

            double Dx = Mx.getDeterminan();
            double Dy = My.getDeterminan();
            double Dz = Mz.getDeterminan();
            double resX = Dx/D;
            double resY = Dy/D;
            double resZ = Dz/D;
            Matriks Hasil = new Matriks(1, 3,1);
            Hasil.mtrx[0][0] = resX;
            Hasil.mtrx[0][1] = resY;
            Hasil.mtrx[0][2] = resZ;
            return Hasil;

        }
        else{
            System.out.println("Silahkan gunakan metode lain");
        }
        return this;


    }

    /* INTERPOLASI */
    public double Interpolasi(double num){
        double hasil = 0;
        MatriksGauss res = new MatriksGauss(this.baris, this.baris+1, false);
        for (int i = 0; i < res.baris;i++){
            for (int j= 0 ; j < res.kolom; j++){
                if (j==0){
                    res.mtrx[i][j] = 1;
                }
                else if (j == this.baris){
                    res.mtrx[i][j] = this.mtrx[i][1];
                }
                else{
                    res.mtrx[i][j] = (double) Math.pow(this.mtrx[i][0],j);
                }
                

            }
        }
        double[] temp = res.solusiGaussV2();
        for (int k = 0; k < res.baris;k++){
            hasil += (temp[k] * (Math.pow(num, k)));
        }

        return hasil;
    }




    /* REGRESI LINEAR BERGANDA */
    public double RegresiLinierBerganda(double x1,double x2,double x3){
        double hasil = 0;
        MatriksGauss res = new MatriksGauss(this.kolom, this.kolom+1, false);
        for (int a = 0; a < res.baris; a++){
            if (a==0){
                for (int b = 0; b < res.kolom;b++){
                    if (b==0){
                        res.mtrx[a][b] = this.baris;
                    }
                    else if (b==res.kolom-1){
                        res.mtrx[a][b] = SumKolom(0);
                    }
                    else{
                        res.mtrx[a][b] = SumKolom(b); 
                    }
                }
            }
            else{
                for (int c = 0; c < res.kolom;c++){
                    if (c==0){
                        res.mtrx[a][c] = SumKolom(a);
                    }
                    else if (c==res.kolom-1){
                        Matriks temp = KaliKolom(a, 0);
                        res.mtrx[a][c] = temp.SumKolom(0);
                    }
                    else{
                        Matriks temp = KaliKolom(a, c);
                        res.mtrx[a][c] = temp.SumKolom(0);
                    }
                }
            }
        }
        double[] temp = res.solusiGaussV2();

        double temp1,temp2,temp3,temp4,temp5;
        temp1 = res.mtrx[0][0];
        temp2 = res.mtrx[0][1];
        temp3 = res.mtrx[0][2];
        temp4 = res.mtrx[0][3];
        temp5 = res.mtrx[0][4];
        temp1 += 1;
        temp2 += x1;
        temp3 += x2;
        temp4 += x3;

        double newtemp5 = (temp[0] * temp1) + (temp[1]*temp2)+(temp[2]*temp3)+(temp[3]*temp4);
        hasil = newtemp5-temp5;


        return hasil;
    }
    


    /* DAPUR INTERNAL, BIAR GA DIPAKE AMA PUBLIK */
    
    private double[][] getMatriksNonSejajar(int i, int j){
        
        int a,b; int countRow=0,countCol=0;
        int brs = this.baris;
        int kol = this.kolom;
        double[][] temp = new double[brs-1][kol-1];
        
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
    
    private double getDeterminanLokal(double[][] Mat){
        int brs = Mat.length;
        int kol = Mat[0].length;
        //System.out.println(brs+" "+kol);
        if((brs==kol)&&brs==2&&kol==2){
            double r = (Mat[0][0]*Mat[1][1])-(Mat[0][1]*Mat[1][0]);
            return r;
        }else if(brs==kol){
            double[][] newarr = new double[brs-1][kol-1];
            double det =0;
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
                
                double detsementara= (double) pow(-1,x)*Mat[0][x]*this.getDeterminanLokal(newarr);
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
                this.mtrx[a][b] = scanner.nextDouble();
            }
        }
    }
    
    private double[][] getTranspose(double[][] M){
        int row = M.length;
        int col = M[0].length;
        double[][] res = new double[col][row];
        
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
    
    // private void debugarr(double[][] debugee){
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
