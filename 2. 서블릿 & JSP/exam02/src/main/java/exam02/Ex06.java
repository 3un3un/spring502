package exam02;


public class Ex06 {
    public static void main(String[] args) {
        Student str1 = new Student(1000, "이름1", "과목1");
        Student str2 = new Student(1000, "이름1", "과목1");

        System.out.println(str1 == str2);
        System.out.println("equals : " + str1.equals(str2));
        System.out.println("str1 : " + System.identityHashCode(str1));
        System.out.println("str2 : " + System.identityHashCode(str2));


    }

}
