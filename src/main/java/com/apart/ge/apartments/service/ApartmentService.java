package com.apart.ge.apartments.service;

import com.apart.ge.apartments.enums.PropertyType;
import com.apart.ge.apartments.model.Property;
import com.apart.ge.apartments.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartmentService {

    private PropertyRepository propertyRepository;

    public ApartmentService() {

    }

    @Autowired
    public ApartmentService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Property getApartment(Integer id) {
        return propertyRepository.getPropertyByIdAndPropertyType(id, PropertyType.APARTMENT);
    }

    public Property createProperty(Property property) {
        return null;
    }

    public void save(Property existingProperty) {
    }
}
