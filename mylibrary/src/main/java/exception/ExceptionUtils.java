package exception;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import commonUtils.TimeUtils;
import file.FilePathUtils;
import file.FileUtils;

/**
 * Created by Flyhooo on 2016/12/20 08:52
 * 操作异常日志
 */

public class ExceptionUtils {


    /**
     * 写入异常信息
     *
     * @param ex
     */
    public static void writeExc(Throwable ex) {
        StringBuffer sb = new StringBuffer();
        //还可添加设备以及用户信息

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);

        String fileName = TimeUtils.getCurrentTimeInString(TimeUtils.STRING_FORMAT) + ".txt";

        FileUtils.writeFile(FilePathUtils.getLogCachePath(), fileName, sb.toString());
    }


}
