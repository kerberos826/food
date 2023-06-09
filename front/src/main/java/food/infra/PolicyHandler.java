package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    FrontEndRepository frontEndRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='StatusUpdated'"
    )
    public void wheneverStatusUpdated_LoadStatusChange(
        @Payload StatusUpdated statusUpdated
    ) {
        StatusUpdated event = statusUpdated;
        System.out.println(
            "\n\n##### listener LoadStatusChange : " + statusUpdated + "\n\n"
        );

        // Sample Logic //
        FrontEnd.loadStatusChange(event);
    }
}
