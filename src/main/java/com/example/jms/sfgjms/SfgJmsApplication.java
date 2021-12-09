package com.example.jms.sfgjms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgJmsApplication {

	public static void main(String[] args) throws Exception {

		// configure activeMq server
		// now we have configure the activemq server in local using docker container that's why we are commenting this
		// we can remove the dependicies aswell because there is no use of this
//		ActiveMQServer server= ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
//				.setPersistenceEnabled(false)
//				.setJournalDirectory("target/data/journal")
//				.setSecurityEnabled(false)
//				.addAcceptorConfiguration("invm","vm://1"));
//
//		server.start();


		SpringApplication.run(SfgJmsApplication.class, args);
	}

}
