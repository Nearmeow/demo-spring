package com.example.demo;

import com.example.demo.dto.MessageDtoRequest;
import com.example.demo.dto.MessageDtoResponse;
import com.example.demo.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {

	@Autowired
	private MessageService messageService;

	@Test
	void addMessageTest() {
		MessageDtoRequest messageDtoRequest = new MessageDtoRequest("message");
		MessageDtoResponse response = messageService.addMessage(messageDtoRequest);

		assertAll(
				() -> assertNotNull(response),
				() -> assertTrue(response.getId() > 0),
				() -> assertEquals("message", response.getMessage())
		);
	}

}
