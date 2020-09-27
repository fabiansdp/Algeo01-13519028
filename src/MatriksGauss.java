// package tubesalgeo;

/**
 * MatriksGauss
 */
public class MatriksGauss extends Matriks {
    // Deklarasi
    public MatriksGauss(int baris, int kolom, boolean isi) {
        super(baris,kolom,isi);
    }

    // ALgoritma Gauss Elimination
    public Matriks getGaussMatriks() {
        int baris = this.baris;
        int kolom = this.kolom;

        for (int k = 0; k<baris; k++) {
            // Inisialisasi nilai dan index untuk ditukar
            int pivotIdx = k;
            double pivotMax = this.mtrx[pivotIdx][k];

            // Cari nilai max yg lebih besar buat ditukar 
            // jika ada
            for (int i = k+1; i<baris; i++) {
                if (abs(this.mtrx[i][k])>pivotMax) {
                    pivotMax = this.mtrx[i][k];
                }
            }

            if (this.mtrx[k][pivotIdx]==0) {
                return this;
            }

            // Tukar barisan
            if (pivotIdx != k) {
                swap(k, pivotIdx);
            }

            // Ubah menjadi matriks eselon baris
            for (int i= k+1; i<baris; i++) {
                double ratio = this.mtrx[i][k]/this.mtrx[k][k];

                for (int j=k+1; j<kolom; j++) {
                    this.mtrx[i][j] = this.mtrx[i][j] - (ratio*this.mtrx[k][j]);
                }
                this.mtrx[i][k] = 0;
            }
        }

        this.bagiLeadCoef();

        return this;
    }

    // Algoritma Gauss-Jordan Elimination
    public Matriks getGaussJordan() {
        int baris = this.baris;
        int kolom = this.kolom;
        double ratio;

        for (int i = 0; i<baris; i++) {
            // Mencari leading coefficient jika baris pertama
            // variabel pertama 0
            if (this.mtrx[i][i]==0) {
                int c = 1;
                while (((i+c)<baris) && (this.mtrx[i+c][i]==0)) {
                    c++;
                }
                if ((i+c)==baris) {
                    return this;
                }
                swap(i, i+c);
            }
            
            // Mengubah menuju matriks eselon baris tereduksi
            for (int j = 0; j<baris; j++) {
                if (i!=j) {
                    ratio = this.mtrx[j][i]/this.mtrx[i][i];

                    for (int k=0; k<kolom; k++) {
                        this.mtrx[j][k] = this.mtrx[j][k] - this.mtrx[i][k]*ratio;
                    } 
                }
            }
        }
        this.bagiLeadCoef();

        return this;
    }

    // Solusi untuk Eliminasi Gauss
    public void solusiGauss() {
        // Array buat simpan jawaban
        int jmlhVar = this.baris;
        double[] arrJawab = new double[jmlhVar];

        for (int i = jmlhVar-1; i>=0; i--) {
            // Konstanta setiap persamaan
            arrJawab[i] = this.mtrx[i][jmlhVar];

            for (int j = i+1; j<jmlhVar; j++) {
                arrJawab[i] = arrJawab[i] - this.mtrx[i][j]*arrJawab[j];
            }
        }

        for (int i = 0; i<jmlhVar; i++) {
            System.out.println("Solusi X"+(i)+":");
            System.out.printf("%.2f\n", arrJawab[i]);
        }
    }

    // Solusi untuk Eliminasi Gauss Jordan
    public void solusiGaussJordan() {
        for (int i = 0; i<baris; i++) {
            double x = this.mtrx[i][baris]/this.mtrx[i][i];
            System.out.println("Solusi X"+(i)+":");
            System.out.printf("%.2f\n", x);
        }
    }

    // Fungsi copy matriks
    public MatriksGauss copyMatriks(MatriksGauss M){
        MatriksGauss temp = new MatriksGauss(M.baris,M.kolom,false);
        for (int i=0; i<M.baris; i++) {
            for (int j=0; j<M.kolom; j++) {
                temp.mtrx[i][j] = M.mtrx[i][j];
            }
        }
        return temp;
    }

    // Fungsi ambil matriks koefisien
    // Input berupa matriks augmented
    public MatriksGauss getCoefMtrx(MatriksGauss M) {
        MatriksGauss hasil = new MatriksGauss(M.baris,M.kolom-1,false);
        for (int i = 0; i<M.baris; i++) {
            for (int j = 0; j<M.kolom-1; j++) {
                hasil.mtrx[i][j] = M.mtrx[i][j];
            }
        }
        return hasil;
    }

    /*FUNGSI-FUNGSI PRIVATE YANG TIDAK DIPAKAI DI MAIN.JAVA */
    // Fungsi tukar baris
    private void swap(int i, int j) {
        for (int k=0; k<this.kolom; k++) {
            double temp = this.mtrx[i][k];
            this.mtrx[i][k] = this.mtrx[j][k];
            this.mtrx[j][k] = temp;
        }
    }

    // Fungsi bilangan mutlak
    private double abs(double num) {
        if (num < 0) {
            return num*-1;
        } else {
            return num;
        }
    }

    // Fungsi cari bilangan utama setiap baris
    private double getLeadCoef(int i) {
        boolean found = false;
        int kolom = this.kolom;
        double leadCoef = 0;
        int j = 0;

        while ((!found) && (j<kolom)) {
            if (this.mtrx[i][j]!=0) {
                leadCoef = this.mtrx[i][j];
                found = true;
            } else {
                j++;
            }
        }

        return leadCoef;
    }

    // Bagi leadCoef
    private void bagiLeadCoef() {

        for (int i = 0; i<baris; i++) {
            double leadCoef = this.getLeadCoef(i);
            if (leadCoef!=0) {
                for (int j = 0; j<kolom; j++) {
                    this.mtrx[i][j] = this.mtrx[i][j]/leadCoef;
                }
            }
        }       
    }

    // Fungsi cari index kolom lead koefisien suatu baris
    private int idxLeadCoef(int i) {
        int j = 0;

        while (j<this.kolom) {
            if (this.mtrx[i][j] != 0) {
                return j;
            } else {
                j++;
            }
        }

        return j;
    }

    // Fungsi untuk menentukan apakah suatu baris matriks hanya berisi 0
    private boolean isBaris0(int i) {
        boolean isNol = true;
        int j = 0;

        while ((isNol) && (j<this.kolom)) {
            if (this.mtrx[i][j]!=0) {
                isNol = false;
            } else {
                j++;
            }
        }

        return isNol;
    }

    /* Fungsi untuk menentukan tipe matriks: 
     1 = solusi unik 
     2 = banyak solusi
     3 = tidak ada solusi
    */
    private int getType() {
        int i = this.baris-1;

        if (!isBaris0(i) && (i>=0)) {
            // Jika lead coef di kolom terakhir
            if (idxLeadCoef(i)==this.kolom-1) {
                return 3;
            } else {
                for (int j=idxLeadCoef(i)+1; j<this.kolom-1; j++) {
                    if (this.mtrx[i][j]!=0) {
                        return 2;
                    }
                }
            }
        } else {
            i--;
        }
        return 1;
    }
}