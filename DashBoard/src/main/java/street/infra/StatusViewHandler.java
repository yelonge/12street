package street.infra;

import street.domain.*;
import street.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusViewHandler {

    @Autowired
    private StatusRepository statusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            Status status = new Status();
            // view 객체에 이벤트의 Value 를 set 함
            status.setOrderId(String.valueOf(ordered.getId()));
            status.setCurStatus("주문됨");
            // view 레파지 토리에 save
            statusRepository.save(status);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_CREATE_2 (@Payload OrderCanceled orderCanceled) {
        try {

            if (!orderCanceled.validate()) return;

            // view 객체 생성
            Status status = new Status();
            // view 객체에 이벤트의 Value 를 set 함
            status.setOrderId(String.valueOf(orderCanceled.getId()));
            status.setCurStatus("주문취소됨");
            // view 레파지 토리에 save
            statusRepository.save(status);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenStockReduced_then_UPDATE_1(@Payload StockReduced stockReduced) {
        try {
            if (!stockReduced.validate()) return;
                // view 객체 조회

                List<Status> statusList = statusRepository.findByItemId(String.valueOf(stockReduced.getId()));
                for(Status status : statusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    status.setQty(status.getQty() - stockReduced.getQty());
                // view 레파지 토리에 save
                statusRepository.save(status);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenStockIncreased_then_UPDATE_2(@Payload StockIncreased stockIncreased) {
        try {
            if (!stockIncreased.validate()) return;
                // view 객체 조회

                List<Status> statusList = statusRepository.findByItemId(String.valueOf(stockIncreased.getId()));
                for(Status status : statusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    status.setQty(status.getQty() + stockIncreased.getQty());
                // view 레파지 토리에 save
                statusRepository.save(status);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenShipped_then_UPDATE_3(@Payload Shipped shipped) {
        try {
            if (!shipped.validate()) return;
                // view 객체 조회

                List<Status> statusList = statusRepository.findByOrderId(shipped.getOrderId());
                for(Status status : statusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    status.setCurStatus("배송됨");
                // view 레파지 토리에 save
                statusRepository.save(status);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_4(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                List<Status> statusList = statusRepository.findByOrderId(String.valueOf(orderCanceled.getId()));
                for(Status status : statusList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    status.setCurStatus("배송취소됨");
                // view 레파지 토리에 save
                statusRepository.save(status);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

