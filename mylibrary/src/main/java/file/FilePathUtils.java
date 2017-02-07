package file;

import android.os.Environment;

import java.io.File;

/**
 * Created by Flyhooo on 2016/12/15 16:39
 *
 * 系统文件路近配置
 * 根据需求再添加其他功能
 */
public class FilePathUtils {

    public static String rootPath = "";

    public static void init(String path) {
        rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + path + "/";
        File folder = new File(rootPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    /**
     * 图片缓存存放路径
     */
    public static String getImageCachePath() {
        String soundPath = rootPath + "imageCache/";
        File folder = new File(soundPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return soundPath;
    }

    /**
     * 应用更新存放路径
     */
    public static String getUpdateAPKPath() {
        String soundPath = rootPath + "apkUpdate/";
        File folder = new File(soundPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return soundPath;
    }

    /**
     * 二维码图片生成地址
     */
    public static String getQRCodeBitmapPath() {
        String soundPath = rootPath + "qrCodeCache/";
        File folder = new File(soundPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return soundPath;
    }

    /**
     * 文件缓存存放路径
     */
    public static String getFileCachePath() {
        String soundPath = rootPath + "fileCache/";
        File folder = new File(soundPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return soundPath;
    }

    /**
     * Log缓存存放路径
     */
    public static String getLogCachePath() {
        String soundPath = rootPath + "logCache/";
        File folder = new File(soundPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return soundPath;
    }

    /**
     * 递归删除文件和文件夹
     *
     * @param file 要删除的根目录
     */
    public static void RecursionDeleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] childFile = file.listFiles();
            if (childFile == null || childFile.length == 0) {
                file.delete();
                return;
            }
            for (File f : childFile) {
                RecursionDeleteFile(f);
            }
            file.delete();
        }
    }


}
