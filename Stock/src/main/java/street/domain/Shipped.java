package street.domain;

import street.domain.*;
import street.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Shipped extends AbstractEvent {

    private Long id;
    private String orderId;
    private String orderStatus;
    private Object itemId;
    private String address;
    private String email;
    private Integer qty;
}


