package org.ashina.ecommerce.inventory.application.query.model;

import lombok.Data;
import org.ashina.ecommerce.sharedkernel.query.model.Query;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetStocksQuery extends Query {

    @NotEmpty
    private List<String> productIds;

}
