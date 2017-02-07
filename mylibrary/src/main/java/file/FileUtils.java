package file;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import log.CM_Log;

/**
 * Created by Flyhooo on 2016/12/20 09:05
 */

public class FileUtils {

    public static void writeFile(String path, String fileName, String content) {
        try {
            File file = new File(path, fileName);
            file.createNewFile();
            file.setWritable(Boolean.TRUE);
            //第二个参数意义是说是否以append方式添加内容
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(content);
            bw.flush();
            CM_Log.l_e("写入成功：" + path + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
