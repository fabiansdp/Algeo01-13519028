# Tugas Besar 1 Aljabar Linier dan Geometri

## Kontributor
- Hafid Abi Daniswara           (13519028)
- Fabian Savero Diaz Pranoto    (13519140)
- M. Alfandavi Aryo Utomo       (13519211)

## Penjelasan Program
Aplikasi sederhana untuk melakukan penyimpanan, input, output, dan pengeditan matriks.
Selain itu, aplikasi ini juga bisa melakukan operasi pada matriks seperti:
1. Mencari Determinan
2. Mencari Invers
3. Mencari solusi dari Sistem Persamaan Linear
4. Mencari Interpolasi
5. Melakukan regresi linear berganda

Fitur lain dari aplikasi ini adalah:
1. Dapat read matriks dari file
2. Dapat ekspor matriks ke file

## Ekspor dan Impor File TXT External
Untuk ekspor file, file akan diletakkan di file folder 'test' dan akan otomatis ditambah setelah program diberhentikan.
Untuk impor file pastikan file sudah ditaruh di folder 'test'. Untuk input file gunakan menu 1->2 lalu ketikkan nama filenya saja tanpa dot txt.
Contoh : test1.txt(Salah), seharusnya hanya test1.

Untuk input file txt pastikan tidak ada enter yang kosong atau kolom yang kurang, contoh sebagai berikut :

### Contoh 1 (Benar)
```
1 2 3 4       
5 6 7 8
```  

### Contoh 2 (Benar)
```
1 2
```           

### Contoh 3 (Benar)
```
1 2 -3        
9.5 9 9       
0 0.1 0 
```     

### Contoh  4 (Salah, pada baris 2 kurang 1 elemen)
```
1 2 3         
9 8           
9 8 7        
```

### Contoh 5 (Salah, ada enter kosong)
```
1 2 3          
44 32 111      
{Empty Line}  
```

## Cuplikan Program
### Kompilasi Program
Untuk menjalankan program masukkan *command* sebagai berikut :
```bash
cd bin
java mainprogram
```
### Menu Utama
Setelah program berhasil di-*run*, akan muncul menu utama sebagai berikut :
```bash
===MENU INPUT EDIT MATRIKS===
1. Input Matriks Baru
2. Lihat Matriks
3. Ubah Matriks
4. Ekspor Matriks

===MENU OPERASI MATRIKS===
5. Sistem Persamaan Linear
6. Determinan Matriks
7. Interpolasi Polinom
8. Regresi Linear berganda
9. Matriks Balikan / inverse

===JALAN UNTUK KELUAR===
98. INFORMASI MENU
99. KELUAR
```
### Input Matriks
Untuk menginput sebuah matriks, pilih nomor 1 di menu utama. Jika memilih input manual akan muncul tampilan sebagai berikut :
```bash
Ketikan 1 untuk menambah matriks by input user
Ketikan 2 untuk input matriks dari file txt
Ketikkan 0 untuk batal
Masukkan pilihan anda = 1
berapa baris yang anda mau ? 
berapa kolom yang anda mau ? 
```
Jika memilih input text akan muncul tampilan sebagai berikut :
```bash
Ketikan 1 untuk menambah matriks by input user
Ketikan 2 untuk input matriks dari file txt
Ketikkan 0 untuk batal
Masukkan pilihan anda = 2
Masukkan nama file (tanpa dot txt) = 
```

### Lihat, Ubah dan Ekspor Matriks
Untuk melihat matriks yang telah di-input dapat memilih nomor 2 di menu utama. Untuk mengubah matriks yang telah di-input dapat memilih nomor 3 di menu utama. Untuk mengekspor matriks yang telah di-input dapat memilih nomor 4 di menu utama.

### Operasi Matriks
Dapat dilakukan melakukan operasi matriks SPL dengan meng-input nomor 5, mencari determinan dengan meng-input nomor 6, interpolasi polinom dengan meng-input nomor 7, regresi linear berganda dengan meng-input nomor 8, dan mencari invers suatu matriks dengan meng-input nomor 9.<br>
Tampilan SPL :
```bash
Pilih Metode persamaan linear
1. Eliminasi Gauss
2. Eliminasi Gauss-Jordan
3. Metode matriks balikan
4. Kaidah Crammer
pilihan anda =
```
Tampilan Determinan :
```bash
pilih metode determinan matriks
1. metode reduksi baris
2. metode ekspansi kofaktor
pilihan anda =
```
Tampilan Interpolasi Polinom :
```bash
masukkan id matriks yang mau diinterpolasikan
id matriks mulai dari 0 s.d 0
jawaban anda = 
input nilai x = 
Hasil interpolasi f(x) adalah = 
pilihan anda =
```
Tampilan Regresi Linear Berganda :
```bash
masukkan id matriks yang mau di double reglin
id matriks mulai dari 0 s.d 0
jawaban anda = 
input nilai x1 = 
input nilai x2 = 
input nilai x3 = 
```
Tampilan Invers :
```bash
pilih metode Invers matriks
1. metode adjoin
2. metode baris elementer
pilihan anda =
```

### End Program
Untuk mengakhiri program, input angka 99 pada terminal. Akan muncul pesan sebagai berikut :
```bash
====================================
makasih udah pake program kita
semoga bisa barokah dan bermanfaat
====================================
```

## Laporan
Laporan untuk tugas ini dapat diakses [di sini](doc/LaporanTugasBesar1-AljabarLineardanGeometri.pdf).