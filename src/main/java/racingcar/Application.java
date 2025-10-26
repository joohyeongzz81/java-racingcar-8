package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = inputCarNames();
        int roundCount = inputRoundCount();
        
        RacingGame game = new RacingGame(carNames, roundCount);
        game.start();
    }
    
    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return InputValidator.parseCarNames(input);
    }
    
    private static int inputRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return InputValidator.parseRoundCount(input);
    }
}