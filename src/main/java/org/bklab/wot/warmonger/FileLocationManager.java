package org.bklab.wot.warmonger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class FileLocationManager {

    public void moving(String baseDirectory) {
        File baseDir = new File(baseDirectory);
        if (baseDir.exists()) {
            baseDir.delete();
        }

        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }

        File createTimeDir = new File(baseDir.getAbsolutePath() + File.separator + (new SimpleDateFormat("MM月dd日 更新插件")).format(new Date()));
        if (!createTimeDir.exists()) {
            createTimeDir.mkdirs();
        }

        try {
            this.copyFolder(new File(Config.BASE_DIRECTORY + "wbp"), createTimeDir);
            File copyRight = new File(baseDir.getAbsolutePath() + File.separator + "战争贩子专属坦克世界插件下载站.txt");
            if (copyRight.exists()) {
                copyRight.delete();
            }

            this.writeCopyRights(copyRight);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    private void copyFolder(File src, File dest) throws IOException {
        int length;
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }

            String[] files = src.list();
            String[] var4 = files;
            int var5 = files.length;

            for (length = 0; length < var5; ++length) {
                String file = var4[length];
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                this.copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }

    }

    public void writeCopyRights(File copyRights) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(copyRights));
            StringBuffer sb = new StringBuffer();
            char[] lineSeparator = "\r\n".toCharArray();
            sb.append("感谢为战争贩子效力过的朋友使用本站插件");
            sb.append("如遇到插件过期问题，也可在YY或者微信群内私聊站长已进行即使更新。").append(lineSeparator);
            sb.append("本站地址：https://broderick.cn/wot").append(lineSeparator);
            sb.append("更新日期: ").append((new SimpleDateFormat("yyyy年 MM月 dd日 HH:mm:ss")).format(new Date())).append(lineSeparator).append(lineSeparator);
            sb.append("内部插件，请勿共享!!!");
            bw.write(sb.toString());
            bw.close();
        } catch (IOException var5) {
        }

    }
}
