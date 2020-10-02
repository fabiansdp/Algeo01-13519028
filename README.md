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
Untuk ekspor file, file akan diletakkan di file folder 'test', dan akan automatis ditambah setelah program diberhentikan.
Untuk impor file pastikan file sudah ditaruh di folder 'test'. untuk input file gunakan menu 1->2 lalu ketikkan nama filenya saja tanpa dot txt.
ex = test1.txt -> hanya tuliskan test1

Untuk input file txt pastikan tidak ada enter yang kosong atau kolom yang kurang, contoh sebagai berikut :

Contoh 1 (benar) <br>
1 2 3 4       {line 1} <br>
5 6 7 8       {line 2}<br>

Contoh 2 (benar)<br>
1 2           {line 1}<br>

Contoh 3 (benar)<br>
1 2 -3        {line 1}<br>
9.5 9 9       {line 2}<br>
0 0.1 0       {line 3}<br>

Contoh  4 (salah, pada baris 2 kurang 1 elemen)<br>
1 2 3         {line 1}<br>
9 8           {line 2}<br>
9 8 7         {line 3}<br>

Contoh 5 (salah, ada enter kosong)<br>
1 2 3          {line 1}<br>
44 32 111      {line 2}<br>
{empty line}   {line 3}<br>
