package com.java.se7.string.recipes;

/**
 * Created by vf-root on 12/18/14.
 */
public class MainClass {

    public static void main(String[] args){
//        String pattern = "com(.)vodafone(.)global(.)cloud(.)opco(.)properties-(.*)[A-Z](.*)cfg";
//        String str = "com.vodafoneaglobal.cloud.opco.properties-DEFAULT.cfg";
//        String str2 = "com.vodafone.global.cloud.opco.properties-DE.cfg.old";

        String pattern = "com\\.vodafone\\.global\\.[a-z]*\\.opco\\.properties-[A-Z]*\\.cfg";
        String str = "com.vodafone.global.cloud.opco.properties-DEFAULT.cfg";
        String str2 = "com.vodafone.global.cloud.opco.properties-DE.cfg.old";

        System.out.println(StringMatcher.formatMatches(pattern, str));
        System.out.println(StringMatcher.formatMatches(pattern, str2));

        String pattern2 = "com\\.vodafone\\.global\\.[a-z]*\\.opco\\.(properties|translations)-DEFAULT\\.cfg";
        String str3 = "com.vodafone.global.cloud.opco.properties-DEFAULT.cfg";
        String str4 = "com.vodafone.global.cloud.opco.translations-DE.cfg";

        System.out.println(StringMatcher.formatMatches(pattern2, str3));
        System.out.println(StringMatcher.formatMatches(pattern2, str4));

        String pattern3 = "(apix|timeout|system|proxy)\\.properties";
        String str5 = "apix.properties";
        String str6 = "timeout.properties";
        String str7 = "system.properties";
        String str8 = "proxy.properties";
        String str9 = "abc.properties";

        System.out.println("\n\n");
        System.out.println(StringMatcher.formatMatches(pattern3, str5));
        System.out.println(StringMatcher.formatMatches(pattern3, str6));
        System.out.println(StringMatcher.formatMatches(pattern3, str7));
        System.out.println(StringMatcher.formatMatches(pattern3, str8));
        System.out.println(StringMatcher.formatMatches(pattern3, str9));
    }

}
