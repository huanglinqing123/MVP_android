package mvp.com.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

    /*
     * 获取该应用的根目录
     */
    public static String getAppPath() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return "";
        }
        File sdRoot = Environment.getExternalStorageDirectory();
        File file = new File(sdRoot.getAbsolutePath() + "/haozhangfu");
        if (!file.exists()) file.mkdir();
        return file.getAbsolutePath();
    }

    /*
     * 获取缓存合同的位置
     */
    public static String getHTPath() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return "";
        }
        File file = new File(getAppPath() + "/合同");
        if (!file.exists()) file.mkdir();
        return file.getAbsolutePath();
    }

    /*
        引导页图片
     */
    public static String getPagePath() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return "";
        }
        File file = new File(getAppPath() + "/page");
        if (!file.exists())
            file.mkdir();
        return file.getAbsolutePath();
    }

    /*
    引导页图片
    */
    public static String getAudioPath() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return "";
        }
        File file = new File(getAppPath() + "/audio");
        if (!file.exists()) file.mkdir();
        return file.getAbsolutePath();
    }

    /*
    引导页图片
    */
    public static String getTmpPath() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return "";
        }
        File file = new File(getAppPath() + "/temp");
        if (!file.exists()) file.mkdir();
        return file.getAbsolutePath();
    }

    /*
     *  获取某个路径的size
     */
    public static long getFileSize(File f) {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
