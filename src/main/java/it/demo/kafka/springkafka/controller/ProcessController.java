package it.demo.kafka.springkafka.controller;

import it.demo.kafka.springkafka.bean.Flight;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProcessController {

	@Autowired
	@Qualifier("inputToKafka")
	MessageChannel channel;

	private static final Log logger = LogFactory.getLog(ProcessController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/publish")
	public @ResponseBody Flight getTrainsJson(Flight flightRequest) {

		logger.info("Flight: " + flightRequest);

		channel.send(MessageBuilder.withPayload(flightRequest)
				.setHeader("topic", flightRequest.getNumber()).build());

		return flightRequest;
	}
}
