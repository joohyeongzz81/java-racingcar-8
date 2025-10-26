package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    void 전진_테스트() {
        Car car = new Car("pobi");
        
        car.move(4);
        
        assertThat(car.getPosition()).isEqualTo(1);
    }
    
    @Test
    void 정지_테스트() {
        Car car = new Car("pobi");
        
        car.move(3);
        
        assertThat(car.getPosition()).isEqualTo(0);
    }
    
    @Test
    void 여러번_전진_테스트() {
        Car car = new Car("pobi");
        
        car.move(4);
        car.move(5);
        car.move(9);
        
        assertThat(car.getPosition()).isEqualTo(3);
    }
    
    @Test
    void 경계값_테스트() {
        Car car = new Car("pobi");
        
        car.move(0);
        car.move(9);
        
        assertThat(car.getPosition()).isEqualTo(1);
    }
}