package street.domain;

import street.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Shipped extends AbstractEvent {

    private Long id;
    private String orderId;
    private String order_status;
    private ItemId itemId;
    private String address;
    private String email;
    private Integer qty;
}
