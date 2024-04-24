package fr.esgi.customer.beans;


import java.util.Arrays;
import java.util.Optional;

public enum ClientType {
    COMPANYNAME("Raison Social"),
    TOWN("Ville");

    private ClientType(String designation) {
        this.designation = designation;
    }

    private final String designation;

    public String getDesignation() {
        return designation;
    }

    public static Optional<ClientType> getByDesignation(String designation) {
        return Arrays.stream(values())
                .filter(propertyType -> propertyType.designation.equals(designation))
                .findAny();
    }

}
