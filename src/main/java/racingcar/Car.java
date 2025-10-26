package racingcar;

public class Car {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int MOVE_DISTANCE = 1;
    
    private final String name;
    private int position;
    
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }
    
    public void move(int randomValue) {
        if (randomValue >= FORWARD_THRESHOLD) {
            position += MOVE_DISTANCE;
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
}