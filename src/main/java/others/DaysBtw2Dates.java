package others;

/**
 * Created by lanxiao on 29/04/15.
 */
public class DaysBtw2Dates {
    static private class Date {
        int year, month, day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    private int getJDN(Date date) {
        int a = (14 - date.month) / 12;
        int y = date.year + 4800 - a;
        int m = date.month + 12 * a - 3;
        int jdn = date.day + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045;
        return jdn;
    }

    public int daysJDN(Date d1, Date d2) {
        return getJDN(d1) - getJDN(d2);
    }

    static public void main(String[] args) {
        Date date1 = new Date(2015, 2, 25);
        Date date2 = new Date(2014, 2, 23);
        DaysBtw2Dates daysBtw2Dates = new DaysBtw2Dates();
        System.out.println(daysBtw2Dates.daysJDN(date1, date2));
    }
}
