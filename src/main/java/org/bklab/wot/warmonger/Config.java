package org.bklab.wot.warmonger;

import java.io.File;

@SuppressWarnings("unused")
public class Config {
    private static final String ABSOLUTE_BASE_WINDOWS;
    private static final String ABSOLUTE_BASE_LINUX;
    static final String ABSOLUTE_BASE;
    static final String WARMONGER_MODS = "Warmonger_Mods";
    static final String BASE_DIRECTORY;
    static final String WARMONGER_MODS_VERSION = "0.9.22.0.1";
    static final String DWLIST;
    static final String DWLIST_URL = "http://wbp.guazihe.com/0tkbox/dwbp.js";
    static final String LIST;
    static final String LIST_URL = "http://list.guazihe.com/0tkmod/9358125E64D4248B.js";
    static final String GBOX_PATH;
    static final String NEWJS = "http://list.guazihe.com/0tkmod/new.js";
    static final String BeijingServerPem = "/broderick/privatekey/Broderick_CVM_Beijing.pem";
    static final String BeijingServerPpk = "/broderick/privatekey/Broderick_CVM_Beijing.ppk";

    Config() {
    }

    private static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("windows")) {
            isWindowsOS = true;
        }

        return isWindowsOS;
    }

    static {
        ABSOLUTE_BASE_WINDOWS = "D:" + File.separator + "Broderick Gaming" + File.separator;
        ABSOLUTE_BASE_LINUX = "/data/wwwroot/default/wot/p" + File.separator;
        ABSOLUTE_BASE = isWindowsOS() ? ABSOLUTE_BASE_WINDOWS : ABSOLUTE_BASE_LINUX;
        BASE_DIRECTORY = ABSOLUTE_BASE + "Warmonger_Mods" + File.separator;
        DWLIST = ABSOLUTE_BASE + "gbox" + File.separator + "Dwlist.lst";
        LIST = ABSOLUTE_BASE + "gbox" + File.separator + "list.lst";
        GBOX_PATH = ABSOLUTE_BASE + "gbox";
    }
}
