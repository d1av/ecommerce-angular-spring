package com.davi.shop.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class InstantUtils {
    private InstantUtils() {
    }

    // 9 casas = NANOSECONDS
    // 6 casa = MICROSECONDS
    public static Instant now() {
	return Instant.now().truncatedTo(ChronoUnit.MICROS);
    }

    public static Date dateNow() {
	return Date.from(now());
    }
}