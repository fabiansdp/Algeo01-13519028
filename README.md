# Tubes1Algeo

aplikasi sederhana untuk melakukan penyimpanan, input, output, dan pengeditan matriks
selain itu aplikasi ini juga bisa melakukan operasi pada matriks seperti:
1. cari determinan
2. cari invers
3. cari solusi dari sistem persamaan linear
4. mencari interpolasi
5. melakukan regresi linear berganda

fitur lain dari aplikasi ini adalah:
1. bisa read matriks dari file
2. bisa ekspor matriks ke file

untuk ekspor file, file akan diletakkan di file folder 'test', dan akan automatis ditambah setelah program diberhentikan
untuk impor file pastikan file sudah ditaruh di folder 'test'. untuk input file gunakan menu 1->2 lalu ketikkan nama filenya saja tanpa dot txt
ex = test1.txt -> hanya tuliskan test1

untuk input file txt pastikan tidak ada enter yang kosong atau kolom yang kurang, misal 

contoh 1 (benar) <br>
1 2 3 4       {line 1} <br>
5 6 7 8       {line 2}<br>

contoh 2 (benar)<br>
1 2           {line 1}<br>

contoh 3 (benar)<br>
1 2 -3        {line 1}<br>
9.5 9 9       {line 2}<br>
0 0.1 0       {line 3}<br>

contoh  4 (salah, pada baris 2 kurang 1 elemen)<br>
1 2 3         {line 1}<br>
9 8           {line 2}<br>
9 8 7         {line 3}<br>

contoh 5 (salah, ada enter kosong)<br>
1 2 3          {line 1}<br>
44 32 111      {line 2}<br>
{empty line}   {line 3}<br>
