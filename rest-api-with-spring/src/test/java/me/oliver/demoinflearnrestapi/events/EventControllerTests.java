package me.oliver.demoinflearnrestapi.events;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * {@literal @WebMvcTest} 웹과 관련된 빈들이 모두 등록이 되고 테스트에서 MockMvc를 주입받아서 쉽게 사용 가능 MockMvc을 만들면 Mocking 되어
 * 있는 DispatcherServlet을 상대로 가짜 요청을 만들어서 DispatcherServlet을 보내고 응답을 확인할 수 있는 Test를 만들 수 있음
 * 웹과 관련된것만 등록을 해주기 때문에 slicing test라고 부름. 즉 모든 빈들을 등록해서 만드는 것이 아니라 웹과 관련된 빈들만 만들어서 사용하기 때문에
 * Test가 빠름, 하지만 이 자체로 단위 테스트다라고 보기에는 어려움, 또한 DispatcherServlet, EventControll 이러한 것들이 포함되어서 테스트하는것이라
 * 단위 테스트라고 보기에는 어려움. ---> 왜 사용하느냐 하면 여러가지 테스트를 편리하게 작성해서 사용할 수 있음
 * MockMvc 는 웹 서버를 띄우지 않기 때문에 조금 더 빠르고, 하지만 DispatcherServlet을 만들기 때문에 단위 테스트보다 빠르지는 않음
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTests {

  @Autowired
  MockMvc mockMvc;

  /**
   * Mapping Jackson Json이 의존성으로 들어가 있으면
   * 스프링 부트를 사용하면 ObjectMapper가 임의의 빈으로 등록이 되어있음.
   */
  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void creatEvent() throws Exception {
    Event event = Event.builder()
        .name("Spring")
        .description("REST API Development with Spring")
        .beginEnrollmentDateTime(LocalDateTime.of(2020, 10, 28, 11, 57))
        .closeEnrollmentDateTime(LocalDateTime.of(2020, 10, 29, 11, 57))
        .beginEventDateTime(LocalDateTime.of(2020, 10, 30, 11, 57))
        .endEventDateTime(LocalDateTime.of(2020, 10, 31, 11, 57))
        .basePrice(100)
        .maxPrice(200)
        .limitOfEnrollment(100)
        .location("강남역 D2 스타텁 팩토리")
        .build();

    mockMvc.perform(post("/api/events/")
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaTypes.HAL_JSON)
          .content(objectMapper.writeValueAsString(event))) // Jackson Json으로 변경하여 요청 본문에 넣어
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("id").exists())
        ;
  }
}
