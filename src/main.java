class main {
        public static void main(String[] args) {
                MatriksGauss m = new MatriksGauss(3, 4, true);
                m.getGaussJordan().tampilinMatriks();
                m.solusiGaussJordan();
        }
}