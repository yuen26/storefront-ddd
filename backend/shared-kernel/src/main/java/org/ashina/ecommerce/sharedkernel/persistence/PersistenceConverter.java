package org.ashina.ecommerce.sharedkernel.persistence;

public interface PersistenceConverter<D, P> {

    default P mapToPersistentObject(final D domainEntity) {
        throw new UnsupportedOperationException();
    }

    default D mapToDomainEntity(final P persistentObject) {
        throw new UnsupportedOperationException();
    }

}
