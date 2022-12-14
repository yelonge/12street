package street.domain;

import street.domain.*;
import street.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Shipped extends AbstractEvent {

    private Long id;
    private String orderId;
    private String orderStatus;
    private List<String> itemId;
    private String address;
    private String email;
    private Integer qty;

    public Shipped(Ship aggregate){
        super(aggregate);
    }
    public Shipped(){
        super();
    }
}
