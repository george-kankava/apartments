package com.apart.ge.apartments.repository;


import com.apart.ge.apartments.enums.PropertyType;
import com.apart.ge.apartments.model.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer> {


    Property getPropertyByIdAndPropertyType(Integer id, PropertyType propertyType);
}
