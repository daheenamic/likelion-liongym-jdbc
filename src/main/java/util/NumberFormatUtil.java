package util;

import java.text.DecimalFormat;

/**
 * 숫자 변환 공통 Util
 * @author dahee
 * @since 25.09.17
 */
public class NumberFormatUtil {
    public static String CurrencyFormat(int price) {
        DecimalFormat df = new DecimalFormat("#,###"); // 3자리마다 구분자
        return df.format(price);
    }
}
