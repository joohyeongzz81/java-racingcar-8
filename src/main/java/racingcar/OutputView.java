package racingcar;

import java.util.List;

public class OutputView {
    private static final String POSITION_MARKER = "-";
    
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }
    
    private static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + createPositionString(car.getPosition()));
    }
    
    private static String createPositionString(int position) {
        return POSITION_MARKER.repeat(position);
    }
    
    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}