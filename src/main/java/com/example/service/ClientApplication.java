package com.example.service;


import com.example.service.proto.HelloRequest;
import com.example.service.proto.SimpleGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	ApplicationRunner clientRunner(@GrpcClient("helloService")SimpleGrpc.SimpleBlockingStub simpleBlockingStub){
		return new ApplicationRunner(){

			@Override
			public void run(ApplicationArguments args) throws Exception {
				System.out.println(simpleBlockingStub.sayHello(HelloRequest.newBuilder().setName("Tom Cruise").build()));
			}
		};
	}
}



