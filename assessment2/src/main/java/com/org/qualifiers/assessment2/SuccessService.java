package com.org.qualifiers.assessment2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"success", "default"})
public class SuccessService implements ProductService {

    @Override
    public String product() {
        return "Product delivered Successfully!";
    }

}
