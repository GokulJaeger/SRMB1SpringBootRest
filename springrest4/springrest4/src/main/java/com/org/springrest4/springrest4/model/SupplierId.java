package com.org.springrest4.springrest4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class SupplierId implements Serializable {
    public SupplierId(Object id, Object id2) {
    }

    @Column(name = "goodsId")
    private Integer bookId;

    @Column(name = "vendorId")
    private Integer vendorId;
}
