package street.domain;

import street.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String order_status;
    private List<String> itemId;
    private String address;
    private String email;
    private Integer qty;
}
