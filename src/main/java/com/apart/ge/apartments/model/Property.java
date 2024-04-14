package com.apart.ge.apartments.model;

import com.apart.ge.apartments.enums.PropertyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)@Document(collation = "property")
public class Property {

    @Id
    private String id;

    private PropertyType type;

    private String name;

    @DBRef
    private Address address;

    private PropertyType propertyType;
}
