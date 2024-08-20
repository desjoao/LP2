class CopiaArray {
    public static void main(String[] args) {
        char[] copiaDe = { 'd', 'e', 's', 'c', 'a', 'f', 'e', 'i', 'n', 'a', 'd', 'o'};
        char[] copiaPara = new char[9];

        System.arraycopy(copiaDe, 3, copiaPara, 0, 9);
        System.out.println(new String(copiaPara));
    }
}
