/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author TNO
 */
public class GetDataUtils {
    public static String formatToVietnamCurrency(int amount) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        return currencyFormatter.format(amount);
    }

    public static int parseVietnamCurrency(String amount) {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        try {

            Number number = currencyFormatter.parse(amount);

            return number.intValue();
        } catch (ParseException e) {
            e.printStackTrace();

            return 0;
        }
    }
}
