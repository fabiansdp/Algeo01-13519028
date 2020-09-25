class main {
        public static void main(String[] args) {
                Matriks m = new Matriks(3, 4, true);
                Matriks n = m.Cramer(m, 3);
                n.tampilinMatriks();
        }
}