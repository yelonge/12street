package street.domain;

import street.domain.Ordered;
import street.domain.OrderCanceled;
import street.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    
    
    
    
    private String orderStatus;
    
    
    
    @ElementCollection
    
    private List<String> itemId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String email;
    
    
    
    
    
    private Integer qty;

    @PostPersist
    public void onPostPersist(){


        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }



    public void 취소(){
    }



}
