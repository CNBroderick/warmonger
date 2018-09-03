package org.bklab.wot.warmonger.tools;

import java.text.DecimalFormat;

@SuppressWarnings("unused")
public class FileSizeUtils {
    public FileSizeUtils() {
    }

    public static String fileSize(int size) {
        if ((double) size > Math.pow(2.0D, 30.0D)) {
            return (new FileSizeUtils()).getGB(size);
        } else if ((double) size > Math.pow(2.0D, 20.0D)) {
            return (new FileSizeUtils()).getMB(size);
        } else {
            return (double) size > Math.pow(2.0D, 10.0D) ? (new FileSizeUtils()).getKB(size) : size + "B";
        }
    }

    private String getKB(int size) {
        return this.formatDecimal((double) size * 1.0D / Math.pow(2.0D, 10.0D)) + "KB";
    }

    private String getMB(int size) {
        return this.formatDecimal((double) size * 1.0D / Math.pow(2.0D, 20.0D)) + "MB";
    }

    private String getGB(int size) {
        return this.formatDecimal((double) size * 1.0D / Math.pow(2.0D, 30.0D)) + "GB";
    }

    private String formatDecimal(double d) {
        return (new DecimalFormat("0.00")).format(d) + "";
    }
}
