

package com.cg.fda.service;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.fda.domain.Order;
import com.cg.fda.exception.IDNotFoundException;
import com.cg.fda.repository.OrderRepository;

 

 

 

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @MockBean
    private OrderRepository orderRepository;
    @Test
    void createOrder() {
        Order order=new Order();
        order.setorderId(1);
        order.setUserName("Sandhya");
        order.setUserPhone("9121393187");
        order.setUserEmailId("chatu@gmail.com");
        order.setUserAddress("Tirupathi");
               Mockito.when(orderRepository.save(order)).thenReturn(order);
        assertThat(orderService.createOrder(order)).isEqualTo(order);
            
        }
    @Test
    void deleteOrderTest() throws IDNotFoundException {
        Order order=new Order();
        order.setorderId(1);
        order.setUserName("Sandhya");
        order.setUserPhone("9121393187");
        order.setUserEmailId("chatu@gmail.com");
        order.setUserAddress("Tirupathi");
        Assert.assertTrue(orderRepository.findById(3).isEmpty());                     
    }    
    @Test
    void getAllOrder() throws IDNotFoundException {
        Order order=new Order();
        order.setorderId(1);
        order.setUserName("Sandhya");
        order.setUserPhone("9121393187");
        order.setUserEmailId("chatu@gmail.com");
        order.setUserAddress("Tirupathi");
        List<Order> orderlist = new ArrayList<>();
        Mockito.when(orderRepository.findAll()).thenReturn(orderlist);
        assertThat(orderService.getAllOrder()).isEqualTo(orderlist);
        
    }

 

 

}