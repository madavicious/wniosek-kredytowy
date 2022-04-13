package pl.javaskills.creditapp.core.model;

import java.util.Comparator;

public class FamilyMemberNameComparator implements Comparator<FamilyMember> {

    @Override
    public int compare(FamilyMember o1, FamilyMember o2){
        return o1.getName().compareTo(o2.getName());
    }
}
