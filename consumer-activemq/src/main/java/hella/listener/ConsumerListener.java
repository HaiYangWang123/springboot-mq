package hella.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @Auth hywang
 * @Email hywang2017@qq.com
 * @Date 2018/3/4
 */
@Component
public class ConsumerListener {

    @JmsListener(destination ="${queue}")
    public void  getMessage(final TextMessage text, Session session){

        try {
            text.acknowledge();
            System.out.println("consumer get the message:"+text.getText());
        }catch (Exception e){
            //// 此不可省略 重发信息使用
            try {
                session.recover();
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        }

    }
}
