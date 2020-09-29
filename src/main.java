class main {
        public static void main(String[] args) {
                /*
                MatriksGauss n = new MatriksGauss(20, 4, true);
                float ress = n.RegresiLinierBerganda((float)50,(float)76,(float)29.3);
                System.out.println(ress);
                */

                
                MatriksGauss n = new MatriksGauss(10, 2, true);
                double coba1 = n.Interpolasi((float) 5.80); // 25 Mei = 5 + (25/31)
                double coba2 = n.Interpolasi((float) 8.96); //8 + (30/31)
                double coba3 = n.Interpolasi((float) 9.5); // 9 + (15/30)

                System.out.println(coba1);
                System.out.println(coba2);
                System.out.println(coba3);
                
                
                
                
                /* 
                MatriksGauss n = new MatriksGauss(3, 2, true);
                float coba1 = n.Interpolasi((float) 9.2);
                System.out.println(coba1);
                */



                /*
                MatriksGauss n = new MatriksGauss(7, 2, true);
                float coba1 = n.Interpolasi((float) 0.2);
                float coba2 = n.Interpolasi((float) 0.55);
                float coba3 = n.Interpolasi((float) 0.85);
                float coba4 = n.Interpolasi((float) 1.28);

                System.out.println(coba1);
                System.out.println(coba2);
                System.out.println(coba3);
                System.out.println(coba4);

                */
                
               MatriksGauss M1 = new MatriksGauss(3,4,true);
               M1.getGaussJordan().tampilinMatriks();
               M1.solusiGauss();
        }
}