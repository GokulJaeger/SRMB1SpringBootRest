package com.org.springrest4.springrest4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {
    @EmbeddedId
    private SupplierId id;

    @ManyToOne
    @MapsId("goodsId")
    @JoinColumn(name = "goodsId")
    private Goods book;

    @ManyToOne
    @MapsId("supplierId")
    @JoinColumn(name = "supplierId")
    private Vendor publisher;

    @Column(name = "supplyDate")
    private Date supplyDate;

    public Supplier(Goods book, Vendor publisher, Date supplyDate) {
        this.id = new SupplierId(book.getId(), publisher.getId());
        this.book = book;
        this.publisher = publisher;
        this.supplyDate = supplyDate;
    }
}
