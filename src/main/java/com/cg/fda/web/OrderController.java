package com.cg.fda.web;
import java.util.List;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.domain.Order;
import com.cg.fda.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

 

@Api(value = "OrderController", description = "REST Api's related to Food Cart and Order Entity!!!!")
@RestController
@RequestMapping("/api/v2")
@Validated
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
public class OrderController {
    
    public static final Logger logger = Logger.getLogger("OrderController.class");
    
    @Autowired
    private OrderService orderService;
    
    
    
    @PostMapping("/Order")
    public Order createOrder(@RequestBody Order order) {
        logger.info("Creating Order!");
        return orderService.createOrder(order);
    }
    
    @ApiOperation(value = "Updating specific Order in the System ", response = Order.class)
    @PutMapping("/Order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value="id") Integer orderId,
            @RequestBody Order order) throws IDNotFoundException{
        logger.info("Updating order!");
        Order orderFound= orderService.updateOrderById(orderId, order);
        return ResponseEntity.ok(orderFound);
    }
    
    @ApiOperation(value = "Delete specific Order in the System ", response = Order.class)
    @DeleteMapping("/Order/{id}")    
    public ResponseEntity<String> deleteOrder(@PathVariable(value="id") Integer orderId) throws IDNotFoundException{
        orderService.deleteOrderById(orderId);
        logger.info("Deleting Order!");
        String result= "Order with Id : "+orderId+" Deleted Successfully!";
        return ResponseEntity.ok(result);
           
    }  
    
    @ApiOperation(value = "Get list of Order in the System ", response = Iterable.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"), 
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/Order")
    public List<Order> getAllOrder() {
        logger.info("Get all order details");
        return orderService.getAllOrder();
    } }