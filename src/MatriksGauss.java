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
            float pivotMax = this.mtrx[pivotIdx][k];

            // Cari nilai max yg lebih besar buat ditukar 
            // jika ada
            for (int i = k+1; i<baris; i++) {
                if (abs(this.mtrx[i][k])>pivotMax) {
                    pivotMax = this.mtrx[i][k];
                }
            }

            if (this.mtrx[k][pivotIdx]==0) {
                System.out.println("Matriks gaada penyelesaiaan");
                return this;
            }

            // Tukar barisan
            if (pivotIdx != k) {
                swap(k, pivotIdx);
            }

            // Ubah menjadi matriks eselon baris
            for (int i= k+1; i<baris; i++) {
                float ratio = this.mtrx[i][k]/this.mtrx[k][k];

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
        float ratio;

        for (int i = 0; i<baris; i++) {
            // Mencari leading coefficient jika baris pertama
            // variabel pertama 0
            if (this.mtrx[i][i]==0) {
                int c = 1;
                while (((i+c)<baris) && (this.mtrx[i+c][i]==0)) {
                    c++;
                }
                if ((i+c)==baris) {
                    System.out.println("Tidak bisa diubah");
                    return this;
                }
                swap(i, i+c);
                this.tampilinMatriks();
                System.out.println("");
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
        // Ubah ke matriks eselon baris
        this.getGaussMatriks();

        // Array buat simpan jawaban
        int jmlhVar = this.baris;
        float[] arrJawab = new float[jmlhVar];

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
        // Ubah ke versi matriks eselon baris tereduksi
        this.getGaussJordan();

        for (int i = 0; i<baris; i++) {
            float x = this.mtrx[i][baris]/this.mtrx[i][i];
            System.out.println("Solusi X"+(i)+":");
            System.out.printf("%.2f\n", x);
        }
    }

    /*FUNGSI-FUNGSI PRIVATE YANG TIDAK DIPAKAI DI MAIN.JAVA */
    // Fungsi tukar baris
    private void swap(int i, int j) {
        for (int k=0; k<this.kolom; k++) {
            float temp = this.mtrx[i][k];
            this.mtrx[i][k] = this.mtrx[j][k];
            this.mtrx[j][k] = temp;
        }
    }

    // Fungsi bilangan mutlak
    private float abs(float num) {
        if (num < 0) {
            return num*-1;
        } else {
            return num;
        }
    }

    // Fungsi cari bilangan utama setiap baris
    private float getLeadCoef(int i) {
        boolean found = false;
        int kolom = this.kolom;
        float leadCoef = 0;
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
            float leadCoef = this.getLeadCoef(i);
            if (leadCoef!=0) {
                for (int j = 0; j<kolom; j++) {
                    this.mtrx[i][j] = this.mtrx[i][j]/leadCoef;
                }
            }
        }       
    }
}