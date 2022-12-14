package street.domain;

import street.domain.*;
import street.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class ShipCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String orderStatus;
    private List<String> itemId;
    private String address;
    private String email;
    private Integer qty;

    public ShipCanceled(Ship aggregate){
        super(aggregate);
    }
    public ShipCanceled(){
        super();
    }
}
