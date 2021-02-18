package com.amdocs.test.reports.constant;

public final class Constants {

    public static final String INSTANTIATION_NOT_ALLOWED = "Instantiation not allowed";
    public static final int TRANSFER_MAX_SIZE = 1512300000;
    public static final int BUFFER_SIZE = 4096;

    private Constants() {
        throw new IllegalStateException(INSTANTIATION_NOT_ALLOWED);
    }
}