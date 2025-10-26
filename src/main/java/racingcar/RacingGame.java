package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    
    private final List<Car> cars;
    private final int roundCount;
    
    public RacingGame(List<String> carNames, int roundCount) {
        this.cars = createCars(carNames);
        this.roundCount = roundCount;
    }
    
    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
    
    public void start() {
        System.out.println("\n실행 결과");
        
        for (int i = 0; i < roundCount; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
        
        announceWinners();
    }
    
    private void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            car.move(randomValue);
        }
    }
    
    private void announceWinners() {
        List<String> winners = findWinners();
        OutputView.printWinners(winners);
    }
    
    private List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return findCarsAtPosition(maxPosition);
    }
    
    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
    
    private List<String> findCarsAtPosition(int position) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}