package clothingstore.com.example.demo.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration
public abstract class AbstractControllerTest {

    protected ObjectMapper objectMapper = new ObjectMapper();
    protected MockMvc mockMvc;
    protected MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(), MediaType.APPLICATION_JSON_UTF8.getSubtype());

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    protected void registerController(Object controller) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    protected String ToJSON(Object object) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(object);
    }

}
