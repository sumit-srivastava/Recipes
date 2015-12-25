package com.java.se7.string.recipes;

import java.util.Comparator;

/**
 * Created by vf-root on 2/13/15.
 */
public class LanguageComparator implements Comparator<Language>{

    public enum SortParameter {
        CODE_ASCENDING, CODE_DESCENDING, QUALITY_ASCENDING, QUALITY_DESCENDING, ORDER_ASCENDING, ORDER_DESCENDING
    }

    private SortParameter[] parameters;

    private LanguageComparator(SortParameter[] parameters) {
        this.parameters = parameters;
    }

    public static Comparator<Language> getComparator(SortParameter... sortParameters) {
        return new LanguageComparator(sortParameters);
    }

    public int compare(Language lang1, Language lang2) {
        int comparison;
        double difference;
        for (SortParameter parameter : parameters) {
            switch (parameter) {
                case CODE_ASCENDING:
                    comparison = lang1.getCode().compareToIgnoreCase(lang2.getCode());
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case CODE_DESCENDING:
                    comparison = lang2.getCode().compareToIgnoreCase(lang1.getCode());
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case QUALITY_ASCENDING:
                    comparison = new Double(lang1.getQuality()).compareTo(lang2.getQuality());
                    if (comparison != 0.0) {
                        return comparison;
                    }
                    break;
                case QUALITY_DESCENDING:
                    comparison = new Double(lang2.getQuality()).compareTo(lang1.getQuality());
                    if (comparison != 0.0) {
                        return comparison;
                    }
                    break;
                case ORDER_ASCENDING:
                    comparison = new Integer(lang1.getOrder()).compareTo(new Integer(lang2.getOrder()));
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case ORDER_DESCENDING:
                    comparison = new Integer(lang2.getOrder()).compareTo(new Integer(lang1.getOrder()));
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;

            }
        }
        return 0;
    }



}
