package exam06;

public class Ex01 {
    public static void main(String[] args) {
        Transportation trans = Transportation.SUBWAY;

        //enum을 스위치로 사용할 때 상수명만 사용하는 것이 일반적
        //  -> switch 문에 이미 trans를 작성
        switch (trans){
            case SUBWAY :
            System.out.println("지하철!");
            break;
            case BUS :
            System.out.println("버스!");
            break;
            case TAXI :
            System.out.println("택시!");
            break;
        }

        /*
        if(trans == Transportation.SUBWAY) {
            System.out.println("지하철!");
        }    */
    }

}
