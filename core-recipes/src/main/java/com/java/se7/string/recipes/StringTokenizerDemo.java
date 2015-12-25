package com.java.se7.string.recipes;

import java.util.*;

/**
 * Created by vf-root on 2/16/15.
 */
public class StringTokenizerDemo {

    public static void main(String[] args){
        processAcceptLanguage("zh, en-us;q=0.1, en;q=0.6, pt_br;q=0.1, *;q=0.6, es;q=0.7, gr", "de");
    }

//    private static void processAcceptLanguage(){
//        String headerString = "zh, en-us;q=0.8, en;q=0.6";
//        Language language;
//        List<Language> langsList = new ArrayList<Language>();
//        int order = 0;
//        if (StringUtils.isNotBlank(headerString)){
//            StringTokenizer languageTokenizer = new StringTokenizer(headerString, ",");
//
//            while (languageTokenizer.hasMoreTokens()){
//                language = new Language();
//                StringTokenizer st = new StringTokenizer(languageTokenizer.nextToken(), ";");
//                if (st.countTokens() == 2){
//                    language.setCode(st.nextToken());
//                    String quality = st.nextToken();
//                    if (quality.contains("=")){
//                        String[] values = quality.split("=");
//                        language.setQuality(Double.valueOf(values[1]));
//                    }
//                }
//                else {
//                    language.setCode(st.nextToken());
//                }
//                order ++;
//                langsList.add(language);
//            }
//        }
//        System.out.println("languages: " + langsList.size());
//    }

    private static void processAcceptLanguage(String headerStr, String opco){
        String headerString = headerStr;
        StringTokenizer languageTokenizer = new StringTokenizer(headerString, ",");
        Language langObject;
        int order = 0;
        List<Language> langList = new ArrayList<Language>();
        while (languageTokenizer.hasMoreTokens()){
            String language = languageTokenizer.nextToken().trim();
            int qValueIndex = language.indexOf(';');
            int qIndex = language.indexOf('q');
            int equalIndex = language.indexOf('=');
            Double qValue = new Double(1);

            if (qValueIndex > -1 && qValueIndex < qIndex && qIndex < equalIndex){
                String qValueStr = language.substring(qValueIndex + 1);
                language = language.substring(0, qValueIndex);
                qValueStr = qValueStr.trim().toLowerCase();
                qValueIndex = qValueStr.indexOf('=');
                qValue = new Double(0);
                if (qValueStr.startsWith("q") && qValueIndex > -1){
                    qValueStr = qValueStr.substring(qValueIndex + 1);
                    try{
                        qValue = new Double(qValueStr.trim());
                    }catch (NumberFormatException nfe){
                    }
                }
            }
            if (language.equals("*")){
                language = opco;
            }
            if (language.contains("-") || language.contains("_")){
                int hyphenIndex = language.indexOf('-');
                if (hyphenIndex > -1){
                    language = language.split("-")[0];
                } else {
                    language = language.split("_")[0];
                }
            }
            order ++;
            langObject = new Language();
            langObject.setCode(language);
            langObject.setQuality(qValue);
            langObject.setOrder(order);
            langList.add(langObject);
        }
        Comparator<Language> cl = LanguageComparator.getComparator(LanguageComparator.SortParameter.QUALITY_DESCENDING,
            LanguageComparator.SortParameter.ORDER_ASCENDING);
        Collections.sort(langList, cl);

        for (Language lang: langList){
            System.out.print(lang.getCode() + " :: " + lang.getQuality() + " :: " + lang.getOrder() + "\n");
        }

    }
}
