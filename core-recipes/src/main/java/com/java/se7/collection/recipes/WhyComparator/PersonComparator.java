package com.java.se7.collection.recipes.WhyComparator;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    public static Comparator<Person> getComparator(SortParameter... sortParameters) {
        return new PersonComparator(sortParameters);
    }

    public enum SortParameter {
        ID_ASCENDING, ID_DESCENDING, NAME_ASCENDING,
        NAME_DESCENDING, ADDRESS_ASCENDING, ADDRESS_DESCENDING
    }

    private SortParameter[] parameters;

    private PersonComparator(SortParameter[] parameters) {
        this.parameters = parameters;
    }

    public int compare(Person o1, Person o2) {
        int comparison;
        for (SortParameter parameter : parameters) {
            switch (parameter) {
                case ID_ASCENDING:
                    comparison = o1.getId() - o2.getId();
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case ID_DESCENDING:
                    comparison = o2.getId() - o1.getId();
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case NAME_ASCENDING:
                    comparison = o1.getName().compareTo(o2.getName());
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case NAME_DESCENDING:
                    comparison = o2.getName().compareTo(o1.getName());
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case ADDRESS_ASCENDING:
                    comparison = o1.getAddress().compareTo(o2.getAddress());
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
                case ADDRESS_DESCENDING:
                    comparison = o2.getAddress().compareTo(o1.getAddress());
                    if (comparison != 0) {
                        return comparison;
                    }
                    break;
            }
        }
        return 0;
    }
}
