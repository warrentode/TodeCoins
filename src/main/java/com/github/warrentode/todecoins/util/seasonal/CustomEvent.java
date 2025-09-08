package com.github.warrentode.todecoins.util.seasonal;

import java.time.LocalDate;
import java.time.MonthDay;

public class CustomEvent {
    private final String name;
    private final MonthDay start;
    private final MonthDay end;

    public CustomEvent(String name, MonthDay start, MonthDay end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public boolean isActiveToday() {
        MonthDay today = MonthDay.from(LocalDate.now());

        if (end == null) {
            // Single-day event
            return today.equals(start);
        }
        else {
            // Multi-day event
            // Handle wrap-around (e.g. 12-30 ~ 01-02)
            if (start.compareTo(end) <= 0) {
                return !today.isBefore(start) && !today.isAfter(end);
            }
            else {
                return !today.isBefore(start) || !today.isAfter(end);
            }
        }
    }
}