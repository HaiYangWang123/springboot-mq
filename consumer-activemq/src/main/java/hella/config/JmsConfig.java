package hella.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Auth hywang
 * @Email hywang2017@qq.com
 * @Date 2018/3/4
 */
public class JmsConfig {
    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value("${spring.activemq.user}")
    private String brokerUserName;
    @Value("${spring.activemq.password}")
    private String brokerPassWord;
    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setPassword(brokerUserName);
        connectionFactory.setUserName(brokerPassWord);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        //进行持久化配置  1:非持久化  2:持久化
        //template.setDeliveryDelay(1);
        //客户签收模式
        //template.setSessionAcknowledgeMode(4);
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        //设置链接数
        factory.setConcurrency("1-10");
        //重连间隔时间
        //factory.setRecoveryInterval(1000L);
        //factory.setSessionAcknowledgeMode(4);
        return factory;
    }

}
