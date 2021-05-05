package org.ashina.ecommerce.sharedkernel.event.model.order;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.sharedkernel.event.model.DomainEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderCanceled extends DomainEvent {

    @Getter
    @Setter
    public static class Line {
        private String productId;
        private Integer quantity;
    }

    private String orderId;
    private List<Line> lines = new ArrayList<>();

    public void addLine(Line line) {
        lines.add(line);
    }
}
