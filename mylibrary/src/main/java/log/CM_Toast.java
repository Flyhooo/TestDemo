package log;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Flyhooo on 2016/12/15 16:11
 */

public class CM_Toast {


    private static Context _context;

    private static Toast toast;

    public static void init(Context context) {
        _context = context;
    }

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(_context,
                    message,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();

    }

    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(int message) {
        if (toast == null) {
            toast = Toast.makeText(_context,
                    message,
                    Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();

    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(_context,
                    message,
                    Toast.LENGTH_LONG);
        } else {
            toast.setText(message);
        }
        toast.show();

    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(int message) {
        if (toast == null) {
            toast = Toast.makeText(_context,
                    message,
                    Toast.LENGTH_LONG);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        if (toast == null) {
            toast = Toast.makeText(_context,
                    message,
                    duration);
        } else {
            toast.setText(message);
        }
        toast.show();

    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(int message, int duration) {
        if (toast == null) {
            toast = Toast.makeText(_context,
                    message,
                    duration);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

}
