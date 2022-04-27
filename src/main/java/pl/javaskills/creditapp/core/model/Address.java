package pl.javaskills.creditapp.core.model;

import pl.javaskills.creditapp.core.annotation.NotNull;

public class Address {

    @NotNull
    private final String street;
    @NotNull
    private final String city;
    @NotNull
    private final String zipCode;
    @NotNull
    private final String state;
    @NotNull
    private final String houseNumber;

    public Address(String street, String city, String zipCode, String state, String houseNumber) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        Address address = (Address) o;
        return street.equalsIgnoreCase(address.street) &&
                city.equalsIgnoreCase(address.city) &&
                zipCode.equalsIgnoreCase(address.zipCode) &&
                state.equals(address.state) &&
                houseNumber.equals(address.houseNumber);
    }
}
