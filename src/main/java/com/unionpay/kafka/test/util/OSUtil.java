package com.unionpay.kafka.test.util;

/**
 * date: 2017/09/13 15:25.
 * author: Yueqi Shi
 */
public class OSUtil {
    private static final String OS_WINDOWS = "windows";

    private static final String OS_LINUX = "linux";

    private static final String WINDOWS_REMOTE_CMD = "calc.exe";

    private static final String LINUX_REMOTE_CMD = "touch test.txt";

    /**
     * if os is windows
     * @return
     */
    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains(OS_WINDOWS);
    }

    /**
     * if os is linux
     * @return
     */
    private static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains(OS_LINUX);
    }

    /**
     * get remote invoke command.
     * different os has different command.
     * @return
     */
    public static String getRemoteCmd() {
        if (isWindows()) {
            return WINDOWS_REMOTE_CMD;
        }

        if (isLinux()) {
            return LINUX_REMOTE_CMD;
        }

        return "";
    }
}
