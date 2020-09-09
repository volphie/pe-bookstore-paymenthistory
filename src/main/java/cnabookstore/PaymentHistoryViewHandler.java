package cnabookstore;

import cnabookstore.config.kafka.KafkaProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentHistoryViewHandler {


    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayed_then_CREATE_1 (@Payload Payed payed) {
        try {
            if (payed.isMe()) {
                // view 객체 생성
                PaymentHistory paymentHistory = new PaymentHistory();
                // view 객체에 이벤트의 Value 를 set 함
                // view 레파지 토리에 save
                BeanUtils.copyProperties(payed, paymentHistory);
                paymentHistoryRepository.save(paymentHistory);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentFailed_then_CREATE_2 (@Payload PaymentFailed paymentFailed) {
        try {
            if (paymentFailed.isMe()) {
                // view 객체 생성
                PaymentHistory paymentHistory = new PaymentHistory();
                // view 객체에 이벤트의 Value 를 set 함
                // view 레파지 토리에 save
                BeanUtils.copyProperties(paymentFailed, paymentHistory);
                paymentHistoryRepository.save(paymentHistory);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentFailed_then_UPDATE_1(@Payload PaymentFailed paymentFailed) {
        try {
            if (paymentFailed.isMe()) {
                // view 객체 조회
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}