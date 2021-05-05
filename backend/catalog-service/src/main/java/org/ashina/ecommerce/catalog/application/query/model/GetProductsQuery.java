package org.ashina.ecommerce.catalog.application.query.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.query.model.Query;

import java.util.Collection;

@Data
public class GetProductsQuery extends Query {

    private Collection<String> ids;

}
