package exception;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;


/**
 * Created by Flyhooo on 2016/12/13 11:38
 * 未捕获异常处理
 */

public class UnCacheExceptionHandler implements Thread.UncaughtExceptionHandler {


    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static UnCacheExceptionHandler INSTANCE = new UnCacheExceptionHandler();
    private Context mContext;

    private UnCacheExceptionHandler() {
    }

    public static UnCacheExceptionHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (!handleException(ex) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    private boolean handleException(final Throwable ex) {
        if (ex == null) {
            return false;
        }
        ex.printStackTrace();

        new Thread() {
            @Override
            public void run() {
                Looper.prepare();

                ExceptionUtils.writeExc(ex);//记录异常日志

                Toast.makeText(mContext, "程序异常,即将退出.", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }
}