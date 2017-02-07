package log;

import android.util.Log;


/**
 * Created by Flyhooo on 2016/12/15 16:11
 */

public class CM_Log {

    private static final String TAG = "ETSPos_Android";


    /**
     * Log.e
     *
     * @param msg
     */
    public static void l_e(String msg) {
        if (CM_Config.IS_DEBUG) {
            Log.e(TAG, msg);
        }
    }

    /**
     * Log.e
     *
     * @param tag
     * @param msg
     */
    public static void l_e(String tag, String msg) {
        if (CM_Config.IS_DEBUG) {
            Log.e(tag, msg);
        }
    }

}
