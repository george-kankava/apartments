package com.apart.ge.apartments.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartmentService {

    @Transactional(propagation = Propagation.REQUIRED)
    public String service() {
        return "public void service()";
    }
}
