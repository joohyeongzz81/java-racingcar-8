package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;
    
    public static List<String> parseCarNames(String input) {
        List<String> names = Arrays.asList(input.split(","));
        
        for (String name : names) {
            validateCarName(name);
        }
        
        return names;
    }
    
    private static void validateCarName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
        
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
    
    public static int parseRoundCount(String input) {
        try {
            int count = Integer.parseInt(input);
            validateRoundCount(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
    
    private static void validateRoundCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}