package com.api.utils;

import java.util.Random;

public class Helper {
    public static int generateRandomRoomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}

