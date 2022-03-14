package pl.javaskills.creditapp.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactDataTest {

    @Test
    @DisplayName("should set Optional.empty correspondence address, when home address is the same")
    public void test1(){
        //given & when
        ContactData contactData = ContactData.Builder.create()
                .withCorrespondenceAddress(new Address("Wrocławska", "Wrocław", "50-500", "Dolnyslask", "24/5"))
                .withHomeAddress(new Address("Wrocławska", "Wrocław", "50-500", "Dolnyslask", "24/5"))
                .build();

        //then
        Assertions.assertTrue(contactData.getCorrespondenceAddress().isEmpty());
    }

    @Test
    @DisplayName("should set Optional.of correspondence address, when home address is NOT the same")
    public void test2(){
        //given & when
        final Address correspondenceAddress = new Address("Komandorska", "Krakow", "50-500", "Dolnyslask", "24/5");
        final Address homeAddress = new Address("Wrocławska", "Wrocław", "50-500", "Dolnyslask", "24/5");
        ContactData contactData = ContactData.Builder.create()
                .withCorrespondenceAddress(correspondenceAddress)
                .withHomeAddress(homeAddress)
                .build();

        //then
        Assertions.assertTrue(contactData.getCorrespondenceAddress().isPresent());
        Assertions.assertEquals(correspondenceAddress, contactData.getCorrespondenceAddress().get());
    }
}
