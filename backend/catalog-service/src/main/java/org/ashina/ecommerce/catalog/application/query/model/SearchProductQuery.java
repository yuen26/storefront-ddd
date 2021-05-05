package org.ashina.ecommerce.catalog.application.query.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.query.model.Query;

import javax.validation.constraints.Positive;

@Data
public class SearchProductQuery extends Query {

    private String keyword;

    @Positive
    private Integer page;

    @Positive
    private Integer size;
}
