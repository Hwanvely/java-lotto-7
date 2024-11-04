package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private final static Pattern NUMBER_ONLY_PATTERN = Pattern.compile("\\d+");
    private final static Pattern LOTTO_NUMBERS_FORMAT = Pattern.compile("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+");
    private static final String LOTTO_NUMBERS_DELIMITER = ",";

    public long promptAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Long.parseLong(input);
    }

    public List<Integer> promptWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateLottoNumbersFormat(input);
        return Arrays.stream(input.split(LOTTO_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public int promptBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!NUMBER_ONLY_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자를 입력하셔야 합니다");
        }
    }

    private void validateLottoNumbersFormat(String input) {
        if (!LOTTO_NUMBERS_FORMAT.matcher(input).matches()) {
            throw new IllegalArgumentException("로또번호 형식과 맞지 않습니다");
        }
    }
}
