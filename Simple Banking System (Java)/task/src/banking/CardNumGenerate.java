package banking;

import java.util.Random;

public class CardNumGenerate {
    private CardNumGenerate() {
    }

    static long GenerateCardNum() {
        long number;
        Random random = new Random();
        // Card number should start with 400000 and next 9 digits can be random
        number = 400_000_000_000_000L + random.nextLong(1_000_000_000L);
        String cardNumString = String.valueOf(number);
        int checkDigit = calcCheckDigitLuhn(cardNumString);
        String accoutIdString = cardNumString.concat(String.valueOf(checkDigit));
        return Long.parseLong(accoutIdString);
    }

    static int calcCheckDigitLuhn(String cardNumString) {

        int numSumLuhn = calcNumSumLuhn(cardNumString);

        for (int i = 0; i < 10; i++) {
            if ((numSumLuhn + i) % 10 == 0) {
                return i;
            }
        }
        throw new IllegalStateException("No matching value found");
    }

    static int calcNumSumLuhn(String numString) {

        int sum = 0;
        for (int i = 0; i <= numString.length() - 1; i++) {
            int digit = Character.getNumericValue(numString.charAt(i));
            if (i % 2 == 0) {
                digit = 2 * digit;
            }
            if (digit > 9) {
                digit -= 9;
            }
            sum += digit;
        }

        return sum;
    }
}
