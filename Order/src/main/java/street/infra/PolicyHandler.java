package street.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import street.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import street.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired OrderRepository orderRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StockIncreased'")
    public void wheneverStockIncreased_UpdateStockCount(@Payload StockIncreased stockIncreased){

        StockIncreased event = stockIncreased;
        System.out.println("\n\n##### listener UpdateStockCount : " + stockIncreased + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ShipCanceled'")
    public void wheneverShipCanceled_UpdateStockCount(@Payload ShipCanceled shipCanceled){

        ShipCanceled event = shipCanceled;
        System.out.println("\n\n##### listener UpdateStockCount : " + shipCanceled + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Shipped'")
    public void wheneverShipped_UpdateStockCount(@Payload Shipped shipped){

        Shipped event = shipped;
        System.out.println("\n\n##### listener UpdateStockCount : " + shipped + "\n\n");


        

        // Sample Logic //

        

    }


}


