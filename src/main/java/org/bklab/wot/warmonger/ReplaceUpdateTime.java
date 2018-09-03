package org.bklab.wot.warmonger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

@SuppressWarnings("unused")
public class ReplaceUpdateTime {
    private String nowTimeString = (new SimpleDateFormat("yyyy年 MM月 dd日 HH:mm:ss E")).format(new Date());

    public static ReplaceUpdateTime create() {
        return new ReplaceUpdateTime();
    }

    private void replace(File file) {
        try {
            String ws = FileUtils.readFileToString(file, "UTF-8");
            String regex;
            if (!ws.contains("周一") && !ws.contains("周二") && !ws.contains("周三") && !ws.contains("周四") && !ws.contains("周五") && !ws.contains("周六") && !ws.contains("周日")) {
                regex = "[0-9]{4}[年 ]{2}[0-9]{2}[月 ]{2}[0-9]{2}[日 ]{2}[0-9:]{8}[a-zA-Z ]{4}";
            } else {
                regex = "[0-9]{4}[年 ]{2}[0-9]{2}[月 ]{2}[0-9]{2}[日 ]{2}[0-9:]{8}[ 周一二三四五六日]{3}";
            }

            String res = ws.replaceAll(regex, this.nowTimeString);
            FileUtils.writeByteArrayToFile(file, res.getBytes(StandardCharsets.UTF_8));
        } catch (IOException var5) {
            System.out.println("Replace time error:" + file.getAbsolutePath());
            var5.printStackTrace();
        }

    }

    public void replaceServerStatus(String message) {
        File warmonger = new File("/data/wwwroot/default/wot/warmonger.html");
        try {
            String ws = FileUtils.readFileToString(warmonger, "UTF-8");
            String regex = "<span id=server-status>.*</span>";
            String result = ws.replaceAll(regex, "<span id=server-status>" + message + "</span>");
            FileUtils.writeByteArrayToFile(warmonger, result.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void doReplace() {
        this.replace(new File("/data/wwwroot/default/wot/warmonger.html"));
        this.replace(new File("/data/wwwroot/default/wot/dl/index.html"));
    }
}
