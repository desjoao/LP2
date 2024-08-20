class CopiaArray_2{
    public static void main(String[] args){
        char[] copiaDe = {'d', 'e', 's', 'c', 'a', 'f', 'e', 'i', 'n', 'a', 'd', 'o'};
        char[] copiaPara = java.util.Arrays.copyOfRange(copiaDe, 3, 12);
        System.out.println(new String(copiaPara));
    }
}
