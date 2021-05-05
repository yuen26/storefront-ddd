package org.ashina.ecommerce.order.application.rest.controller;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.order.application.command.AddProductToCartCommand;
import org.ashina.ecommerce.order.application.command.DeleteCartLineCommand;
import org.ashina.ecommerce.order.application.command.UpdateCartLineCommand;
import org.ashina.ecommerce.order.application.query.model.GetCartQuery;
import org.ashina.ecommerce.order.application.query.model.GetCartView;
import org.ashina.ecommerce.order.application.rest.dto.AddProductToCartDto;
import org.ashina.ecommerce.order.application.rest.dto.UpdateCartLineDto;
import org.ashina.ecommerce.sharedkernel.command.gateway.CommandGateway;
import org.ashina.ecommerce.sharedkernel.query.gateway.QueryGateway;
import org.ashina.ecommerce.sharedkernel.security.SecurityContextHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final QueryGateway queryGateway;
    private final CommandGateway commandGateway;

    @GetMapping("/api/v1/carts")
    public ResponseEntity<GetCartView> getCart() throws Exception {
        GetCartQuery query = newGetCartQuery();
        GetCartView view = (GetCartView) queryGateway.execute(query);
        return new ResponseEntity<>(view, HttpStatus.OK);
    }

    private GetCartQuery newGetCartQuery() {
        GetCartQuery query = new GetCartQuery();
        query.setCustomerId(SecurityContextHelper.currentCustomerId());
        query.setHasValidate(true);
        return query;
    }

    @PostMapping("/api/v1/carts/add-product")
    public ResponseEntity<Void> addProduct(@Valid @RequestBody AddProductToCartDto dto) throws Exception {
        AddProductToCartCommand command = newAddProductToCartCommand(dto);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private AddProductToCartCommand newAddProductToCartCommand(AddProductToCartDto dto) {
        AddProductToCartCommand command = new AddProductToCartCommand();
        command.setCustomerId(SecurityContextHelper.currentCustomerId());
        command.setProductId(dto.getProductId());
        command.setQuantity(dto.getQuantity());
        return command;
    }

    @PutMapping("/api/v1/carts/lines")
    public ResponseEntity<Void> updateLine(@Valid @RequestBody UpdateCartLineDto dto) throws Exception {
        UpdateCartLineCommand command = newUpdateCartLineCommand(dto);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private UpdateCartLineCommand newUpdateCartLineCommand(UpdateCartLineDto dto) {
        UpdateCartLineCommand command = new UpdateCartLineCommand();
        command.setCustomerId(SecurityContextHelper.currentCustomerId());
        command.setProductId(dto.getProductId());
        command.setQuantity(dto.getQuantity());
        return command;
    }

    @DeleteMapping("/api/v1/carts/lines/{productId}")
    public ResponseEntity<Void> deleteLine(@PathVariable String productId) throws Exception {
        DeleteCartLineCommand command = newDeleteCartLineCommand(productId);
        commandGateway.send(command);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private DeleteCartLineCommand newDeleteCartLineCommand(String productId) {
        DeleteCartLineCommand command = new DeleteCartLineCommand();
        command.setProductId(productId);
        return command;
    }

}
