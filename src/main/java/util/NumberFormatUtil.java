package util;

import java.text.DecimalFormat;

public class NumberFormatUtil {
    public static String CurrencyFormat(int price) {
        DecimalFormat df = new DecimalFormat("#,###"); // 3자리마다 구분자
        return df.format(price);
    }
}
