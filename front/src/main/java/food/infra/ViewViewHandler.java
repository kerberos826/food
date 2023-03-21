package food.infra;

import food.config.kafka.KafkaProcessor;
import food.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ViewViewHandler {

    @Autowired
    private ViewRepository viewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            View view = new View();
            // view 객체에 이벤트의 Value 를 set 함
            view.setOrderid(String.valueOf(orderPlaced.getId()));
            // view 레파지 토리에 save
            viewRepository.save(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenStatusUpdated_then_UPDATE_1(
        @Payload StatusUpdated statusUpdated
    ) {
        try {
            if (!statusUpdated.validate()) return;
            // view 객체 조회

            List<View> viewList = viewRepository.findByOrderid(
                String.valueOf(statusUpdated.getId())
            );
            for (View view : viewList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                view.setStatus(statusUpdated.getStatus());
                // view 레파지 토리에 save
                viewRepository.save(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
