package jtechlog.springconverter;

import java.time.LocalDate;
import java.util.Objects;

public class GasHour {

    private LocalDate date;

    private int hour;

    public GasHour(LocalDate date, int hour) {
        if (hour < 0 || hour > 25) {
            throw new IllegalArgumentException("Invalid hour: " + hour);
        }
        this.date = date;
        this.hour = hour;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public static GasHour parse(String s) {
        // Pl. "2015-01-01 1."
        if (s == null || s.length() < 13 || s.length() > 14) {
            throw new IllegalArgumentException("Invalid length");
        }
        LocalDate date = LocalDate.parse(s.substring(0, 10));
        if (s.charAt(s.length() - 1) != '.' || s.charAt(10) != ' ') {
            throw new IllegalArgumentException("Invalid characters");
        }
        int hour = Integer.parseInt(s.substring(s.indexOf(' ') + 1, s.indexOf('.')));
        return new GasHour(date, hour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasHour gasHour = (GasHour) o;
        return Objects.equals(hour, gasHour.hour) &&
                Objects.equals(date, gasHour.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, hour);
    }

    @Override
    public String toString() {
        return date.toString() + " " + hour + ".";
    }
}
