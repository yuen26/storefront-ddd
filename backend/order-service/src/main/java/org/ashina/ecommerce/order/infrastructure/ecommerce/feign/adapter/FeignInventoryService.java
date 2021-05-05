package org.ashina.ecommerce.order.infrastructure.ecommerce.feign.adapter;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.order.infrastructure.ecommerce.InventoryService;
import org.ashina.ecommerce.order.infrastructure.ecommerce.feign.client.InventoryClient;
import org.ashina.ecommerce.order.infrastructure.ecommerce.model.Stock;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FeignInventoryService implements InventoryService {

    private final InventoryClient inventoryClient;

    @Override
    public Map<String, Integer> getStocks(List<String> productIds) {
        List<Stock> stocks = inventoryClient.getStocks(productIds);
        return stocks
                .stream()
                .collect(Collectors.toMap(Stock::getProductId, Stock::getQuantity));
    }
}
