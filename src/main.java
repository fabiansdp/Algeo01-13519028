class main {
        public static void main(String[] args) {
               MatriksGauss M1 = new MatriksGauss(3,4,true);
               M1.getGaussJordan().tampilinMatriks();
               M1.solusiGauss();
        }
}