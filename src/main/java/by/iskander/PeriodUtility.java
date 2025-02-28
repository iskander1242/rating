package by.iskander;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.temporal.IsoFields;

@UtilityClass
public class PeriodUtility {

    int getYear(LocalDate date) {
        return date.get(IsoFields.WEEK_BASED_YEAR);
    }

    int getHalfOfYear(LocalDate date) {
        return (date.getMonthValue() <= 6) ? 1 : 2;
    }

    int getQuarterOfYear(LocalDate date) {
        return (date.getMonthValue() - 1) / 3 + 1;
    }

    int getWeekOfYear(LocalDate date) {
        return date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
    }

    int getDayOfMonth(LocalDate date) {
        return date.getDayOfMonth();
    }
}
