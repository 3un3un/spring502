package exam01;

public class Ex03 {
    public static void main(String[] args) {

        try (MyResouce my = new MyResouce()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
