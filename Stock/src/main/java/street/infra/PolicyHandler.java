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
    @Autowired StockRepository stockRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Shipped'")
    public void wheneverShipped_UpdateStock(@Payload Shipped shipped){

        Shipped event = shipped;
        System.out.println("\n\n##### listener UpdateStock : " + shipped + "\n\n");


        

        // Sample Logic //
        Stock.updateStock(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ShipCanceled'")
    public void wheneverShipCanceled_UpdateStock(@Payload ShipCanceled shipCanceled){

        ShipCanceled event = shipCanceled;
        System.out.println("\n\n##### listener UpdateStock : " + shipCanceled + "\n\n");


        

        // Sample Logic //
        Stock.updateStock(event);
        

        

    }

}


