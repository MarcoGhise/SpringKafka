package it.demo.kafka.springkafka.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.integration.kafka.support.ConsumerConfiguration;
import org.springframework.integration.kafka.support.KafkaConsumerContext;

import com.yammer.metrics.Metrics;

public class KafkaConsumerStarter implements ApplicationContextAware
{
	private ApplicationContext appContext;
	
	private SourcePollingChannelAdapter kafkaInboundChannelAdapter;
	
	private KafkaConsumerContext kafkaConsumerContext;

	public void initIt() throws Exception
	{
		kafkaInboundChannelAdapter = appContext.getBean("kafka-inbound-channel-adapter", SourcePollingChannelAdapter.class);
		kafkaInboundChannelAdapter.start();
				
		kafkaConsumerContext = appContext.getBean("consumerContext", KafkaConsumerContext.class);
	}

	public void cleanUp() throws Exception
	{
		if (kafkaInboundChannelAdapter != null)
		{
			kafkaInboundChannelAdapter.stop();
		}
		
		Thread.sleep(1000);
		
		Metrics.defaultRegistry().shutdown();
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.appContext = applicationContext;
	}
	
}
