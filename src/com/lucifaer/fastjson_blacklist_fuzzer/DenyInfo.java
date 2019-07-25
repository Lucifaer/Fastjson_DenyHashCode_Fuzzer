package com.lucifaer.fastjson_blacklist_fuzzer;

import java.util.ArrayList;
import java.util.List;

public class DenyInfo {
    public String version;
    public static List<DenyInfoItem> known;
    public static List<DenyInfoItem> unknown;

    public DenyInfo(String version) {
        this.version = version;
        known = new ArrayList<DenyInfoItem>();
        unknown = new ArrayList<DenyInfoItem>();
    }

    public static class DenyInfoItem {
        public Long hash;
        public String denyClass;

        public DenyInfoItem(Long hash, String denyClass) {
            this.hash = hash;
            this.denyClass = denyClass;
        }
    }
}
