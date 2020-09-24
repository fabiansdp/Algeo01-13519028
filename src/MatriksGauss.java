// package tubesalgeo;

/**
 * MatriksGauss
 */
public class MatriksGauss extends Matriks {
    public MatriksGauss(int baris, int kolom) {
        super(baris,kolom);
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
        return this;
    }

    // Solusi untuk Eliminasi Gauss
    

    // Solusi untuk Eliminasi Gauss Jordan
    public void solusiGaussJordan() {
        for (int i = 0; i<baris; i++) {
            float x = this.mtrx[i][baris]/this.mtrx[i][i];
            System.out.println("Solusi X"+(i)+":");
            System.out.printf("%.2f\n", x);
        }
    }

    private void swap(int i, int j) {
        for (int k=0; k<this.kolom; k++) {
            float temp = this.mtrx[i][k];
            this.mtrx[i][k] = this.mtrx[j][k];
            this.mtrx[j][k] = temp;
        }
    }

    private float abs(float num) {
        if (num < 0) {
            return num*-1;
        } else {
            return num;
        }
    }
}