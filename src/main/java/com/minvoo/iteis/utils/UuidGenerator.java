package com.minvoo.iteis.utils;

import java.util.UUID;

public class UuidGenerator {

    /**
     * Generates UUID and converts it to String
     * @return String
     */
    public static String generateUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
