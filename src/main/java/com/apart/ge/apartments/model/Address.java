package com.apart.ge.apartments.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collation = "address")
public class Address {

    @Id
    private String id;
    private String street;
    private String streetNumber;
    private String city;

    private String country;
}
