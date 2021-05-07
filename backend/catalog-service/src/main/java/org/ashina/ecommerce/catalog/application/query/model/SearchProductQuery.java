package org.ashina.ecommerce.catalog.application.query.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.query.model.Query;

import javax.validation.constraints.Min;

@Data
public class SearchProductQuery extends Query {

    private String keyword;

    @Min(0)
    private Integer page;

    @Min(1)
    private Integer size;
}
