package com.holo.chatmod.utils;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    public static boolean nullCheck() {
        return (Wrapper.INSTANCE.player() == null || Wrapper.INSTANCE.world() == null);
    }

    public static int random(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
