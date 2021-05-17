package com.cg.fda.service;
import java.util.List;
import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.domain.Order;

 

public interface OrderService {
    
    
    Order createOrder(Order order);
    Order updateOrderById(Integer orderId, Order orderDetails) throws IDNotFoundException;
    boolean deleteOrderById(Integer orderId) throws IDNotFoundException;
    List<Order> getAllOrder();

 

 

}