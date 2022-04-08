public class Main {
    
    public static void main(String[] args) {
        IMDBReader reader = new IMDBReader();
        System.out.println(reader.getTop250());
    }
}
