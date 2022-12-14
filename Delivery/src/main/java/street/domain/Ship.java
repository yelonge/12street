package street.domain;

import street.domain.Shipped;
import street.domain.ShipCanceled;
import street.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Ship_table")
@Data

public class Ship  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String orderStatus;
    
    
    
    @ElementCollection
    
    private List<String> itemId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String email;
    
    
    
    
    
    private Integer qty;

    @PostPersist
    public void onPostPersist(){


        Shipped shipped = new Shipped(this);
        shipped.publishAfterCommit();



        ShipCanceled shipCanceled = new ShipCanceled(this);
        shipCanceled.publishAfterCommit();

    }

    public static ShipRepository repository(){
        ShipRepository shipRepository = DeliveryApplication.applicationContext.getBean(ShipRepository.class);
        return shipRepository;
    }




    public static void ship(Ordered ordered){

        /** Example 1:  new item 
        Ship ship = new Ship();
        repository().save(ship);

        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(ship->{
            
            ship // do something
            repository().save(ship);


         });
        */

        
    }
    public static void cancel(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Ship ship = new Ship();
        repository().save(ship);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(ship->{
            
            ship // do something
            repository().save(ship);


         });
        */

        
    }


}
