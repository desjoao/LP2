public class Example2 {
    public static void main(String[] args){
        Example1 e1 = new Example1();
	e1.openBag();
	System.out.println("The flavor is...");
        e1.setFlavor("Churrasco");
        System.out.println(e1.getFlavor());
    }
}


