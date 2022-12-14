package street.domain;

import street.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class StockIncreased extends AbstractEvent {

    private Long id;
    private Integer qty;
}
