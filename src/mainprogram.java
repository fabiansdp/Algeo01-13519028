import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//program utama tubes algeo
public class mainprogram {
    static public ArrayList<Matriks> gudangMatriks;

    public static  void header(){
        System.out.println("selamat datang di Program MATRIKZZZ\n");
        System.out.println("APLIKASI INI DIBIKIN OLEH:");
        System.out.println("1. Hafid Abi Daniswara (13519028) ");
        System.out.println("2. Fabian Savero Diaz Pranoto (13519140)");
        System.out.println("3. M. Alfandavi Aryo Utomo (13519211) ");
        System.out.println();
    }
    public static  void penutup(){
        System.out.println("====================================");
        System.out.println("Makasih udah pake program kita");
        System.out.println("semoga bisa barokah dan bermanfaat");
        System.out.println("====================================");
    }

    public static void MenuUtama(){
        System.out.println("===MENU INPUT EDIT MATRIKS===");
        System.out.println("1. Input Matriks Baru");
        System.out.println("2. Lihat Matriks");
        System.out.println("3. Ubah Matriks");
        System.out.println("4. Ekspor Matriks");
        System.out.println("\n===MENU OPERASI MATRIKS===");
        System.out.println("5. Sistem Persamaan Linear");
        System.out.println("6. Determinan Matriks");
        System.out.println("7. Interpolasi Polinom");
        System.out.println("8. Regresi Linear berganda");
        System.out.println("9. Matriks Balikan / inverse");
        System.out.println("\n===JALAN UNTUK KELUAR===");
        System.out.println("98. INFORMASI MENU");
        System.out.println("99. KELUAR");
    }

    public static void MenuPilihan(int choice){
        Scanner sc = new Scanner(System.in);
        if(choice==1){
            System.out.println("Ketikan 1 untuk menambah matriks by input user");
            System.out.println("Ketikan 2 untuk input matriks dari file txt");
            System.out.println("Ketikkan 0 untuk batal");
            System.out.print("Masukkan pilihan anda = ");
            int opsi = sc.nextInt();

            if(opsi==1){
                int baris, kolom;
                System.out.print("berapa baris yang anda mau ? "); baris =sc.nextInt();
                System.out.print("\nberapa kolom yang anda mau ? "); kolom =sc.nextInt();
                Matriks baru = new Matriks(baris,kolom,true);
                gudangMatriks.add(baru);
            }else if(opsi==2){
                System.out.print("Masukkan nama file (tanpa dot txt) = ");
                String flname = sc.next();
                IOFile io = new IOFile(flname);
                Matriks baru = io.getMatriks();
                if(!(baru.getBaris()==0 || baru.getKolom()==0)){
                    gudangMatriks.add(baru);
                }
            }
        }else if(choice==2){
            if(gudangMatriks.size()>0){
                int idx;
                System.out.println("Masukkan id matriks yang ingin anda lihat");
                System.out.println("id valid adalah mulai dari 0 sampai "+(gudangMatriks.size()-1));
                System.out.print("jawaban anda = "); idx = sc.nextInt();
                if(idx>=0 && idx<=(gudangMatriks.size()-1)){
                    System.out.println("dibawah adalah matriks dengan id "+idx);
                    gudangMatriks.get(idx).tampilinMatriks();
                    System.out.println();
                }else{
                    System.out.println("indeks yang anda masukkan out of range, silahkan ulangi lagi");
                    System.out.println("================================ \n\n");
                    MenuPilihan(2);
                }
            }else{
                System.out.println("maaf kami belum menerima masukan matriks, jadi ga ada yang bisa ditampilin");
            }
        }else if(choice==3){
            if(gudangMatriks.size()>0){
                int idx;
                System.out.println("Masukkan id matriks yang ingin anda ubah");
                System.out.println("id valid adalah mulai dari 0 sampai "+(gudangMatriks.size()-1));
                System.out.println("untuk batal silahkan masukkan id yang salah");
                System.out.print("jawaban anda = "); idx = sc.nextInt();
                if(idx>=0 && idx<=(gudangMatriks.size()-1)){
                    System.out.println("mengubah matriks dengan id "+idx);
                    gudangMatriks.get(idx).resetMatriks();
                    System.out.println();
                }else{
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else{
                System.out.println("maaf kami belum menerima masukan matriks, jadi ga ada yang bisa diubah");
            }
        }else if(choice==4){
            if(gudangMatriks.size()>0){
                int idx;
                System.out.println("Masukkan id matriks yang ingin anda ubah");
                System.out.println("id valid adalah mulai dari 0 sampai "+(gudangMatriks.size()-1));
                System.out.println("untuk batal silahkan masukkan id yang salah");
                System.out.print("jawaban anda = "); idx = sc.nextInt();

                if(idx>=0 && idx<=(gudangMatriks.size()-1)){
                    String saveFileName;
                    System.out.println("anda akan ekspor matriks dengan id "+idx);
                    System.out.println("preview matriks");
                    gudangMatriks.get(idx).tampilinMatriks();
                    System.out.print("\nSimpan di file dengan nama (tidak usah pake dot txt)= ");
                    saveFileName = sc.next();
                    if(IOFile.writeMatriks(gudangMatriks.get(idx),saveFileName)){
                        System.out.println("\nMatriks Berhasil diekspor dengan nama file "+saveFileName+".txt");
                    }else{
                        System.out.println("\nMaaf Matriks gagal diekspor!!!");
                    }
                }else{
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else {
                System.out.println("maaf kami belum menerima masukan matriks, jadi ga ada yang bisa diekspor");
            }

        }else if(choice==5){
            if(gudangMatriks.size()>0){
                System.out.println("masukkan id matriks yang mau dicari SPLnya");
                System.out.println("id matriks mulai dari 0 s.d "+(gudangMatriks.size()-1));
                System.out.print("jawaban anda = ");
                int idx = sc.nextInt();
                if(idx>=0&&idx<gudangMatriks.size()){
                    System.out.println("Pilih Metode persamaan linear");
                    System.out.println("1. Eliminasi Gauss");
                    System.out.println("2. Eliminasi Gauss-Jordan");
                    System.out.println("3. Metode matriks balikan");
                    System.out.println("4. Kaidah Crammer");
                    int pil;
                    System.out.print("pilihan anda = ");
                    pil = sc.nextInt();
                    while (pil<1||pil>4){
                        System.out.println("menu metode salah, ulangi lagi = ");
                        pil = sc.nextInt();
                    }
                    menuPersLinear(pil,idx);
                }else{
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else{
                System.out.println("maaf kami belum menerima masukan matriks, jadi ga ada yang bisa dicari splnya");
            }


        }else if(choice==6){
            if(gudangMatriks.size()>0){
                System.out.println("masukkan id matriks yang mau dicari Determinanya");
                System.out.println("id matriks mulai dari 0 s.d "+(gudangMatriks.size()-1));
                System.out.print("jawaban anda = ");
                int idx = sc.nextInt();
                if(idx>=0&&idx<=gudangMatriks.size()-1){
                    System.out.println("pilih metode determinan matriks");
                    System.out.println("1. metode reduksi baris");
                    System.out.println("2. metode ekspansi kofaktor");
                    int pil;
                    System.out.print("pilihan anda = ");
                    pil = sc.nextInt();
                    while (pil<1||pil>2){
                        System.out.println("menu metode salah, ulangi lagi = ");
                        pil = sc.nextInt();
                    }
                    menuDeterminan(pil,idx);
                }else {
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else {
                System.out.println("maaf tidak ada matriks, sehingga nda ada yang bisa dicari determinanya");
            }

        }else if(choice==7){
            if(gudangMatriks.size()>0){
                System.out.println("masukkan id matriks yang mau diinterpolasikan");
                System.out.println("id matriks mulai dari 0 s.d "+(gudangMatriks.size()-1));
                System.out.print("jawaban anda = ");
                int idx = sc.nextInt();
                if(idx>=0&&idx<=gudangMatriks.size()-1){
                    Matriks m = new Matriks(gudangMatriks.get(idx).getBaris(),gudangMatriks.get(idx).getKolom(),0);
                    if(m.isMatrixSquare()){m.getDeterminan();}
                    for(int x=0;x<m.baris;x++){
                        for(int y=0; y<m.kolom;y++){
                            m.setElement(x,y,gudangMatriks.get(idx).getElement(x,y));
                        }
                    }
                    System.out.print("input nilai x = ");
                    double x = sc.nextDouble();
                    DecimalFormat df = new DecimalFormat("##.##");
                    System.out.println("Hasil interpolasi f(x) adalah = "+df.format(m.Interpolasi(x)));

                }else {
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else {
                System.out.println("maaf tidak ada matriks, sehingga nda ada yang bisa dicari determinanya");
            }
        }else if(choice==8){
            if(gudangMatriks.size()>0){
                System.out.println("masukkan id matriks yang mau di double reglin");
                System.out.println("id matriks mulai dari 0 s.d "+(gudangMatriks.size()-1));
                System.out.print("jawaban anda = ");
                int idx = sc.nextInt();
                if(idx>=0&&idx<=gudangMatriks.size()-1){
                    Matriks m = new Matriks(gudangMatriks.get(idx).getBaris(),gudangMatriks.get(idx).getKolom(),0);
                    if(m.isMatrixSquare()){m.getDeterminan();}
                    for(int x=0;x<m.baris;x++){
                        for(int y=0; y<m.kolom;y++){
                            m.setElement(x,y,gudangMatriks.get(idx).getElement(x,y));
                        }
                    }
                    double x1,x2,x3;
                    System.out.print("input nilai x1 = "); x1=sc.nextDouble();
                    System.out.print("input nilai x2 = "); x2=sc.nextDouble();
                    System.out.print("input nilai x3 = "); x3=sc.nextDouble();
                    System.out.println("\nHasil dari regresi linear berganda adalah = "+m.RegresiLinierBerganda(x1,x2,x3));
                }else {
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else {
                System.out.println("maaf tidak ada matriks, sehingga nda ada yang bisa dicari determinanya");
            }
        }else if(choice==9){
            if(gudangMatriks.size()>0){
                System.out.println("masukkan id matriks yang mau dibalik");
                System.out.println("id matriks mulai dari 0 s.d "+(gudangMatriks.size()-1));
                System.out.print("jawaban anda = ");
                int idx = sc.nextInt();
                if(idx>=0&&idx<=gudangMatriks.size()-1){
                    System.out.println("pilih metode Invers matriks");
                    System.out.println("1. metode adjoin");
                    System.out.println("2. metode baris elementer");
                    int pil;
                    System.out.print("pilihan anda = ");
                    pil = sc.nextInt();
                    while (pil<1||pil>2){
                        System.out.println("menu metode salah, ulangi lagi = ");
                        pil = sc.nextInt();
                    }
                    menuInversMatriks(pil,idx);
                }else {
                    System.out.println("indeks yang anda masukkan out of range, anda akan dikembalikan ke menu utama");
                    System.out.println("================================ \n\n");
                }
            }else {
                System.out.println("maaf tidak ada matriks, sehingga nda ada yang bisa dicari determinanya");
            }
        }else if(choice==97){

        }else if(choice==98){
            MenuUtama();
        }
    }

    public static void menuInversMatriks(int choice, int index){
        DecimalFormat df = new DecimalFormat("##.##");
        Matriks mt = gudangMatriks.get(index);
        if(choice==1){
            if(mt.isMatrixSquare() && mt.getDeterminan()!=0){
                System.out.println("Adjoin Matriks");
                mt.getAdjoin().tampilinMatriks();
                System.out.println("\nDeterminan Matriks = "+df.format(mt.getDeterminan()));
                System.out.println("\nInversnya adalah");
                mt.getInverse().tampilinMatriks();

                mauNyimpen(mt.getInverse(),"Apakah anda mau menyimpan matriks solusi Matriks?");
            }else{
                System.out.println("matriks tidak ada determinan karena bukan persegi atau det =0");
            }
        }else if(choice==2){
            Matriks hasil = new Matriks(mt.getBaris(),mt.getKolom(),0);
            if(!(mt.isMatrixSquare() && mt.getDeterminan()!=0)){
                System.out.println("matriks tidak ada determinan karena bukan persegi atau det =0");
            }else{
                hasil.getDeterminan();
                Matriks barru = new Matriks(mt.getBaris(),mt.getKolom()*2,0);
                for (int j = 0; j<barru.baris; j++) {
                    for (int k=0; k<barru.kolom; k++) {
                        if(k<mt.getKolom()){
                            barru.setElement(j,k,mt.getElement(j,k));
                        }else{
                            if(j==k-mt.getKolom()){
                                barru.setElement(j,k,1);
                            }else {
                                barru.setElement(j,k,0);
                            }
                        }
                    }
                }
                System.out.println("Matriks sebelum di invers dengan baris elementer");
                barru.tampilinMatriks();
                MatriksGauss mgs = new MatriksGauss(barru);
                Matriks result = mgs.getInversGJ();
                System.out.println("\nHasil matriks Invers final adalah");
                result.tampilinMatriks();
                mauNyimpen(result,"Apakah anda mau menyimpan matriks solusi Matriks?");
            }
        }
    }

    public static void menuPersLinear(int choice,int index){
        MatriksGauss matga = new MatriksGauss(gudangMatriks.get(index));
        if(choice==1){
            System.out.println("solusi dengan persamaan gauss saja");
            matga.getGaussMatriks().tampilinMatriks();
            System.out.println();
            matga.solusiGauss();

            if(matga.getKolom()>0&&matga.getBaris()>0){
                mauNyimpen(matga.getGaussMatriks(),"Apakah anda mau menyimpan matriks solusi Gauss ?");
            }
        }else if(choice==2){
            System.out.println("solusi dengan persamaan gauss jordan");
            matga.getGaussJordan().tampilinMatriks();
            System.out.println();
            matga.solusiGaussJordan();

            if(matga.getKolom()>0&&matga.getBaris()>0){
                mauNyimpen(matga.getGaussJordan(),"Apakah anda mau menyimpan matriks solusi Gauss Jordan?");
            }
        }else if(choice==3){
            Matriks m1 = new Matriks(matga.getBaris(),matga.getKolom()-1,0);
            Matriks m2 = new Matriks(matga.getBaris(),1,0);
            for(int xx=0;xx<m1.getBaris();xx++){
                for(int yy=0;yy<m1.getKolom();yy++){
                    m1.setElement(xx,yy,matga.getElement(xx,yy));
                    if(yy==0){
                        m2.setElement(xx,yy,matga.getElement(xx,matga.getKolom()-1));
                    }
                }
            }

            m1.tampilinMatriks();
            System.out.println("\n "+m1.baris+" "+m1.getDeterminan());
            m2.tampilinMatriks();

            if(m1.getKolom()==m1.getBaris()){
                m1.getDeterminan();
                m1 = m1.getInverse();
                Matriks result = m1.KaliMatriks(m1,m2);

                System.out.println("solusi dengan metode ini adalah\n");
                for(int xx=0;xx<result.getBaris();xx++){
                    System.out.println("solusi X"+xx+" : "+result.getElement(xx,0));
                }

                mauNyimpen(result,"Apakah anda mau menyimpan matriks solusi SPL?");
            }else{
                System.out.println("tidak bisa diselesaikan dengan metode ini, gunakan metode lain");
            }
        }else if(choice==4){
            System.out.println("solusi dengan persamaan crammer");
            Matriks cramer = matga.Cramer(matga.baris);
            for(int x=0;x<cramer.getKolom();x++){
                System.out.println("solusi X"+(x+1)+" = "+cramer.getElement(0,x));
            }

            if(cramer.getKolom()>0 && cramer.getBaris()>0){
                mauNyimpen(cramer,"Apakah anda mau menyimpan matriks solusi crammer?");
            }
        }
    }

    public static void menuDeterminan(int choice,int index){
        DecimalFormat df = new DecimalFormat("##.##");
        if(choice==1){
            MatriksGauss m = new MatriksGauss(gudangMatriks.get(index));
            if(gudangMatriks.get(index).isMatrixSquare()){
                double dett = m.getDetRowReduced();
                System.out.println("determinan adalah = "+df.format(dett));
            }else {
                System.out.println("Tidak ada determinan dalam matriks ini (col != row)");
            }
        }else if(choice==2){
            if(gudangMatriks.get(index).isMatrixSquare()){
                System.out.println("Solusi Determinan dengan metode ekspansi kofaktor");
                System.out.println("Matriks awal");
                gudangMatriks.get(index).tampilinMatriks();
                System.out.println("\nMatriks minor");
                gudangMatriks.get(index).getMinor().tampilinMatriks();
                System.out.println("\nMatriks Kofaktor");
                gudangMatriks.get(index).getKofaktor().tampilinMatriks();

                System.out.println("\nDeterminan dari matriks adalah = "+df.format(gudangMatriks.get(index).getDeterminan()));
            }else{
                System.out.println("Tidak ada determinan dalam matris ini (col != row)");
            }
        }
    }

    public static void mauNyimpen(Matriks mat,String teks){
        Scanner sc = new Scanner(System.in);
        int choice;
        if(teks.equalsIgnoreCase("")){
            System.out.println("Apakah anda mau menyimpan matriks ini ?");
        }else{
            System.out.println(teks);
        }
        System.out.println("1. Ya, tapi tidak usah di ekspor ke txt");
        System.out.println("2. Ya, Sekalian ekspor ke txt juga");
        System.out.println("3. Ngga ah");
        System.out.print("pilihan anda = "); choice = sc.nextInt();

        if(choice<1 || choice>3){
            System.out.println("pilihan salah, ulangi lagi");
            mauNyimpen(mat,teks);
        }else{
            if(choice==1){
                gudangMatriks.add(mat);
                System.out.println("matriks berhasil disimpen dengan id "+(gudangMatriks.size()-1));
            }else if(choice==2){
                gudangMatriks.add(mat);
                String finame;
                System.out.print("simpan matriks di txt dengan nama (tidak usah pake dot txt) = ");
                finame = sc.next();
                System.out.println("matriks berhasil disimpen dengan id "+(gudangMatriks.size()-1));
                if( IOFile.writeMatriks(mat,finame)){
                    System.out.println("matriks berhasil juga disimpan di file "+finame+".txt");
                }else{
                    System.out.println("maaf file gagal disimpan");
                }

            }
        }
    }

    public static void main(String[] args){
        int menuu;
        Scanner sc = new Scanner(System.in);

        gudangMatriks = new ArrayList<>();
        header();
        MenuUtama();
        System.out.print("\nPilihan Anda = ");
        menuu = sc.nextInt();
        while(menuu!=99){
            MenuPilihan(menuu);
            System.out.println("Hint: gunakan 98 untuk informasi menu dan 99 untuk keluar");
            System.out.print("\nmasukkan menu pilihanmu lagi = ");
            menuu = sc.nextInt();

        }
        penutup();
    }
}
