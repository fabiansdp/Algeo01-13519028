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
            // Inisialisasi nilai dan index untuk pivot
            int pivotIdx = k;
            float pivotMax = this.mtrx[pivotIdx][k];

            // Cari nilai max yg lebih besar buat pivot 
            // jika ada
            for (int i = k+1; i<baris; i++) {
                if (abs(this.mtrx[i][k])>pivotMax) {
                    pivotMax = this.mtrx[i][k];
                }
            }
            // 
            if (pivotIdx != k) {
                swap(k, pivotIdx);
            }

            if (this.mtrx[k][pivotIdx]==0) {
                System.out.println("Matriks gaada penyelesaiaan");
                return this;
            }

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

    // Algoritma Gauss Jordan
    // public Matriks getGaussJordan() {

    // }

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