package pl.javaskills.creditapp.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("familyMembers should be sorted by age desc")
    public void test(){
        //given
        final FamilyMember john = new FamilyMember("John", 18);
        final FamilyMember jane = new FamilyMember("Jane", 40);
        final FamilyMember susie = new FamilyMember("Susie", 5);
        List<FamilyMember> familyMemberList = Arrays.asList(john, jane, susie);

        //when
        Person person = NaturalPerson.Builder.create()
                .withFamilyMembers(familyMemberList)
                .build();

        //then
        assertNotNull(person.getFamilyMemberList());
        assertTrue(person.getFamilyMemberList().size()==3);
        assertEquals(jane, person.getFamilyMemberList().get(0));
        assertEquals(john, person.getFamilyMemberList().get(1));
        assertEquals(susie, person.getFamilyMemberList().get(2));
    }

}