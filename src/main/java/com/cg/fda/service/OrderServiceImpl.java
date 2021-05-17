package com.cg.fda.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.domain.Order;
import com.cg.fda.repository.OrderRepository;

 

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

 

    

 

    @Autowired
    private OrderRepository orderRepository;

 

        public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

 

    public Order updateOrderById(@PathVariable Integer orderId,
            @RequestBody Order order) throws IDNotFoundException{
        Order orderFound = orderRepository.findById(orderId)
                    .orElseThrow(() -> new IDNotFoundException(
                            "OrderIdentifier : " + orderId + " not available!!!"));
        
        orderFound.setorderId(order.getOrderId());
        orderFound.setUserName(order.getUserName());
        orderFound.setUserPhone(order.getUserPhone());
        orderFound.setUserEmailId(order.getUserEmailId());
        orderFound.setUserAddress(order.getUserAddress());
        return orderRepository.save(orderFound);
    }
    
   
 

    public boolean deleteOrderById(@PathVariable Integer orderId) throws IDNotFoundException{
        Order order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new IDNotFoundException(
                            "OrderIdentifier : " + orderId + " not available!!!"));
        orderRepository.delete(order);
        return true;
    }
    
   

 

    public List<Order> getAllOrder() {
        return (List<Order>) orderRepository.findAll();
    }

 

    }