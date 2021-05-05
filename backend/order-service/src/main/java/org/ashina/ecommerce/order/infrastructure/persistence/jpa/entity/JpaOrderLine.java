package org.ashina.ecommerce.order.infrastructure.persistence.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_lines")
@Getter
@Setter
public class JpaOrderLine extends JpaBaseEntity {

    @Id
    private String id;

    private String productId;

    private Integer productPrice;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private JpaOrder order;
}
