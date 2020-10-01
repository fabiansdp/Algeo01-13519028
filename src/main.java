class main {
        public static void main(String[] args) {
                                
                /*
                MatriksGauss n = new MatriksGauss(4, 2, true);
                double coba1 = n.Interpolasi((double) 1.2); // 25 Mei = 5 + (25/31)
                System.out.println(coba1);
                */

                /*
                MatriksGauss n = new MatriksGauss(20, 4, true);
                double ress = n.RegresiLinierBerganda((double)50,(double)76,(double)29.3);
                System.out.println(ress);
                */
                

                /*
                MatriksGauss n = new MatriksGauss(10, 2, true);
                double coba1 = n.Interpolasi((double) 5.80); // 25 Mei = 5 + (25/31)
                double coba2 = n.Interpolasi((double) 8.96); //8 + (30/31)
                double coba3 = n.Interpolasi((double) 9.5); // 9 + (15/30)

                System.out.println(coba1);
                System.out.println(coba2);
                System.out.println(coba3);
                */
                /*
                MatriksGauss asu = new MatriksGauss(3, 3, true);
                double tempik = asu.getDeterminanLokalV2(asu);
                System.out.println(tempik);
                */
                
                
                /* 
                MatriksGauss n = new MatriksGauss(3, 2, true);
                double coba1 = n.Interpolasi((double) 9.2);
                System.out.println(coba1);
                */
                /*
                MatriksGauss n = new MatriksGauss(12, 10, true);
                System.out.println("========= Bentuk gauss =========");
                
                n.getGaussJordan().tampilinMatriks();
                */



        
                MatriksGauss n = new MatriksGauss(7, 2, true);
                double coba1 = n.Interpolasi((double) 0.2);
                double coba2 = n.Interpolasi((double) 0.55);
                double coba3 = n.Interpolasi((double) 0.85);
                double coba4 = n.Interpolasi((double) 1.28);

                System.out.println(coba1);
                System.out.println(coba2);
                System.out.println(coba3);
                System.out.println(coba4);

        

        }
}