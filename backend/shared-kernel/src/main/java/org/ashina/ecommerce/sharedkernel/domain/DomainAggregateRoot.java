package org.ashina.ecommerce.sharedkernel.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class DomainAggregateRoot<ID extends Serializable> extends DomainEntity<ID> {

    protected LocalDateTime created;
    protected LocalDateTime updated;

    public DomainAggregateRoot(ID id) {
        super(id);
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }
}
