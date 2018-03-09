package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void test1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/dto1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"property1\":\"prop1\",\"property3\":\"prop3\"}")));

		mvc.perform(MockMvcRequestBuilders.get("/dto2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content()
						.string(equalTo("{\"property1\":\"prop1\",\"property2\":\"prop2\",\"property3\":\"prop3\"}")));
	}
}
