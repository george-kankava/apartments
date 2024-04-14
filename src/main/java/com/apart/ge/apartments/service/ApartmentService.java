package com.apart.ge.apartments.service;

import com.apart.ge.apartments.model.Property;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartmentService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String service() {
        return "public void service()";
    }

    public Property getApartment(Integer id) {
        return null;
    }
}
