package org.ashina.ecommerce.identity.server.repository;

import org.ashina.ecommerce.identity.server.entity.OAuthClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthClientDetailsRepository extends MongoRepository<OAuthClient, String> {
}
