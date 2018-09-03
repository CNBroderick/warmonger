package org.bklab.wot.warmonger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        while (true) {
            if (FileModifyListener.create().checkModifying()) {
                ReplaceUpdateTime.create().replaceServerStatus("正在更新中");
                DownloadMods.create().start();
            }
            try {
                AtomicInteger sleepTime = new AtomicInteger(1000 * new Random().nextInt(600));
                ReplaceUpdateTime.create().replaceServerStatus("已最新，下一次检测时间："
                        + new SimpleDateFormat("HH:mm:ss").format(
                        new Date(new Date().getTime() + sleepTime.get())) + "。");
                Thread.sleep(sleepTime.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
