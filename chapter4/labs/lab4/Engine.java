package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */
public class Engine {

    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)
    private String type;
    private String power;
    private boolean state;
    
    
    
    // TODO: 생성자를 정의하세요.
    public Engine() {

    }
    public Engine(String type, String power, boolean state) {
        this.type = type;
        this.power = power;
        this.state = state;
    }

    public Engine(String type, String power) {
        this.type = type;
        this.power = power;
        this.state = false;
    }




    // TODO: 엔진을 시작하는 메소드를 정의하세요.
    public void startEngine() {
        System.out.println("엔진 시작됨");
        setState(true);
    }
    
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.
    public void stopEngine() {
        System.out.println("엔진 끔");
        setState(false);
    }
    
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
    public void checkEngineState(){
        if  (getState()){
            System.out.println("현재 엔진 가동되어 있음");
        }else{
            System.out.println("현재 엔진 가동되어 있지 않음");
        }
    }
    
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.
    public void getEngineInfo() {
        System.out.println("엔진 타입 : " + type );
        System.out.println("엔진 출력: " + power );
        checkEngineState();
    }
    
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}