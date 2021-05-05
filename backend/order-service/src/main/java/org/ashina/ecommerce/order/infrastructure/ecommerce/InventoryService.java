package org.ashina.ecommerce.order.infrastructure.ecommerce;

import java.util.List;
import java.util.Map;

public interface InventoryService {

    Map<String, Integer> getStocks(List<String> productIds);

}
