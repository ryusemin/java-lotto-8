package lotto.exception;

public final class ErrorMessage {

    private ErrorMessage() {}

    // --- 금액 관련 ---
    public static final String INVALID_AMOUNT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    public static final String INVALID_AMOUNT_FORMAT = "[ERROR] 숫자 형식의 금액을 입력하세요.";

    // --- 로또 번호 관련 ---
    public static final String INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 중복된 번호가 있습니다.";
    public static final String INVALID_RANGE = "[ERROR] 로또 번호는 1~45 사이여야 합니다.";
    public static final String INVALID_FORMAT = "[ERROR] 형식에 맞게 입력하세요. 예) 1,2,3,4,5,6";

    // --- 보너스 번호 관련 ---
    public static final String DUPLICATE_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String INVALID_BONUS_FORMAT = "[ERROR] 형식에 맞게 입력하세요. 예) 7";
}
