package com.gsc.apod;

import android.os.Build;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final String BUILD_TAG = "TAGS";
    private static final String BUILD_TAG_TEST_KEYS = "test-keys";
    private static final String BUILD_TAG_RELEASE_KEYS = "release-keys";

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testIsRooted() {
        SplashScreen instance = new SplashScreen();
        Assert.assertFalse(instance.isDeviceRooted());
    }
}