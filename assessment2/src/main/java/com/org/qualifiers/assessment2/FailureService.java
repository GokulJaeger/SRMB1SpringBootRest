package com.org.qualifiers.assessment2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Failure")
public class FailureService implements ProductService {

    @Override
    public String product() {
        return "Product failed to deliver!";
    }

}
