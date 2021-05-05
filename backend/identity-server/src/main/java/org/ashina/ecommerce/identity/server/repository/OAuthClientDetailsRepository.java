package org.ashina.ecommerce.identity.server.repository;

import org.ashina.ecommerce.identity.server.model.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, String> {
}
