package street.domain;

import street.domain.*;
import street.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class StockIncreased extends AbstractEvent {

    private Long id;
    private Integer qty;
}


