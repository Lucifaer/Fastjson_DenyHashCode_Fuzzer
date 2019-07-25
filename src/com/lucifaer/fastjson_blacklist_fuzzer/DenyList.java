package com.lucifaer.fastjson_blacklist_fuzzer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DenyList {
    public DenyInfo denyInfo;
    public List<String> knownClass;

    public DenyList() {
        knownClass = new ArrayList<String>(){
            {
                add("bsh");
                add("com.mchange");
                add("com.sun.");
                add("java.lang.Thread");
                add("java.net.Socket");
                add("java.rmi");
                add("javax.xml");
                add("org.apache.bcel");
                add("org.apache.commons.beanutils");
                add("org.apache.commons.collections.Transformer");
                add("org.apache.commons.collections.functors");
                add("org.apache.commons.collections4.comparators");
                add("org.apache.commons.fileupload");
                add("org.apache.myfaces.context.servlet");
                add("org.apache.tomcat");
                add("org.apache.wicket.util");
                add("org.apache.xalan");
                add("org.codehaus.groovy.runtime");
                add("org.hibernate");
                add("org.jboss");
                add("org.mozilla.javascript");
                add("org.python.core");
                add("org.springframework");
            }
        };
    }

    public DenyInfo initDenyList() {
        if (denyInfo == null) {
            denyInfo = new DenyInfo("unknow");
            denyInfo.known = new ArrayList<>();
            denyInfo.unknown = new ArrayList<DenyInfo.DenyInfoItem>() {
                {
                    add(new DenyInfo.DenyInfoItem(-8720046426850100497L, ""));
                    add(new DenyInfo.DenyInfoItem(-8165637398350707645L, ""));
                    add(new DenyInfo.DenyInfoItem(-8109300701639721088L, ""));
                    add(new DenyInfo.DenyInfoItem(-8083514888460375884L, ""));
                    add(new DenyInfo.DenyInfoItem(-7966123100503199569L, ""));
                    add(new DenyInfo.DenyInfoItem(-7921218830998286408L, ""));
                    add(new DenyInfo.DenyInfoItem(-7768608037458185275L, ""));
                    add(new DenyInfo.DenyInfoItem(-7766605818834748097L, ""));
                    add(new DenyInfo.DenyInfoItem(-6835437086156813536L, ""));
                    add(new DenyInfo.DenyInfoItem(-6179589609550493385L, ""));
                    add(new DenyInfo.DenyInfoItem(-5194641081268104286L, ""));
                    add(new DenyInfo.DenyInfoItem(-4837536971810737970L, ""));
                    add(new DenyInfo.DenyInfoItem(-4082057040235125754L, ""));
                    add(new DenyInfo.DenyInfoItem(-3935185854875733362L, ""));
                    add(new DenyInfo.DenyInfoItem(-2753427844400776271L, ""));
                    add(new DenyInfo.DenyInfoItem(-2364987994247679115L, ""));
                    add(new DenyInfo.DenyInfoItem(-2262244760619952081L, ""));
                    add(new DenyInfo.DenyInfoItem(-1872417015366588117L, ""));
                    add(new DenyInfo.DenyInfoItem(-1589194880214235129L, ""));
                    add(new DenyInfo.DenyInfoItem(-254670111376247151L, ""));
                    add(new DenyInfo.DenyInfoItem(-190281065685395680L, ""));
                    add(new DenyInfo.DenyInfoItem(33238344207745342L, ""));
                    add(new DenyInfo.DenyInfoItem(313864100207897507L, ""));
                    add(new DenyInfo.DenyInfoItem(1073634739308289776L, ""));
                    add(new DenyInfo.DenyInfoItem(1203232727967308606L, ""));
                    add(new DenyInfo.DenyInfoItem(1459860845934817624L, ""));
                    add(new DenyInfo.DenyInfoItem(1502845958873959152L, ""));
                    add(new DenyInfo.DenyInfoItem(3547627781654598988L, ""));
                    add(new DenyInfo.DenyInfoItem(3730752432285826863L, ""));
                    add(new DenyInfo.DenyInfoItem(3794316665763266033L, ""));
                    add(new DenyInfo.DenyInfoItem(4147696707147271408L, ""));
                    add(new DenyInfo.DenyInfoItem(4904007817188630457L, ""));
                    add(new DenyInfo.DenyInfoItem(5347909877633654828L, ""));
                    add(new DenyInfo.DenyInfoItem(5450448828334921485L, ""));
                    add(new DenyInfo.DenyInfoItem(5688200883751798389L, ""));
                    add(new DenyInfo.DenyInfoItem(5751393439502795295L, ""));
                    add(new DenyInfo.DenyInfoItem(5944107969236155580L, ""));
                    add(new DenyInfo.DenyInfoItem(6742705432718011780L, ""));
                    add(new DenyInfo.DenyInfoItem(7017492163108594270L, ""));
                    add(new DenyInfo.DenyInfoItem(7179336928365889465L, ""));
                    add(new DenyInfo.DenyInfoItem(7442624256860549330L, ""));
                    add(new DenyInfo.DenyInfoItem(8389032537095247355L, ""));
                    add(new DenyInfo.DenyInfoItem(8409640769019589119L, ""));
                    add(new DenyInfo.DenyInfoItem(8838294710098435315L, ""));
                }
            };
        }
        return denyInfo;
    }
}
