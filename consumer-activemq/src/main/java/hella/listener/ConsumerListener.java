package hella.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @Auth hywang
 * @Email hywang2017@qq.com
 * @Date 2018/3/4
 */
@Component
public class ConsumerListener {

    @JmsListener(destination ="${queue}" )
    public void   getMessage(Message message){

        try {
            if(message instanceof TextMessage) {

                TextMessage textMessage = (TextMessage)message;
                String   messageData = textMessage.getText();
                System.out.println("consumer get message:"+messageData);
            }


        }catch (Exception e){

        }

    }
}
