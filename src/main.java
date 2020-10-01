class main {
        public static void main(String[] args) {
               MatriksGauss M1 = new MatriksGauss(4,4,true);
               System.out.println(M1.getDetRowReduced());
               M1.tampilinMatriks();
        }
}