package com.lucifaer.fastjson_blacklist_fuzzer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class HashCodeFuzzer {
    public List<String> jarClassList;

    public HashCodeFuzzer() {
        jarClassList = new ArrayList<String>();
    }

    public void fuzz(String filepath) {
        for (File f : getJarFile(filepath)) {
            try {
                readJarFile(f);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        DenyInfo denyInfo = new DenyInfo("unknow");
        denyInfo.known = new ArrayList<>();
        denyInfo.unknown = new ArrayList<>();

        final long BASIC = 0xcbf29ce484222325L;
        final long PRIME = 0x100000001b3L;

        List<Long> unknowList = new ArrayList<Long>();
        DenyList denyList = new DenyList();
        DenyInfo itemList = denyList.initDenyList();
        denyList.knownClass.addAll(jarClassList);

        for (DenyInfo.DenyInfoItem item : itemList.unknown) {
            unknowList.add(item.hash);
        }

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/Users/lucifaer/Desktop/classlist.txt"));
            for (String s : denyList.knownClass) {
                out.write(s+"\n");
            }
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }



        for (String keyword : denyList.knownClass) {
            final long h3 = (((((BASIC ^ keyword.charAt(0))
                    * PRIME)
                    ^ keyword.charAt(1))
                    * PRIME)
                    ^ keyword.charAt(2))
                    * PRIME;

            Long hash = h3;
            for (int i = 3; i< keyword.length(); ++i) {
                hash ^= keyword.charAt(i);
                hash *= PRIME;
            }
            if (unknowList.contains(hash)) {
                DenyInfo.known.add(new DenyInfo.DenyInfoItem(hash, keyword));
                System.out.println(String.format("Find(%d, %s);", hash, keyword));
                unknowList.remove(hash);
            }
        }


    }

    public List<File> getJarFile(String filepath) {
        List<File> fileList = new ArrayList<File>();
        File file = new File(filepath);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().endsWith(".jar");
            }
        });
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            }
            else if (f.isDirectory()) {
                fileList.addAll(getJarFile(f.getAbsolutePath()));
            }
        }
        return fileList;
    }

    public void readJarFile(File jarFile) throws Exception{
        JarFile jarFile1 = new JarFile(jarFile.getAbsolutePath());
        Enumeration enumeration = jarFile1.entries();
        while (enumeration.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) enumeration.nextElement();
            String name = jarEntry.getName();
            if (name.endsWith(".class")) {
                jarClassList.add(name.replace(".class", "").replace("/", "."));
            }
        }
    }
}
