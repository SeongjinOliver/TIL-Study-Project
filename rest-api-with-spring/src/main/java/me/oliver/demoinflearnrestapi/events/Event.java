package me.oliver.demoinflearnrestapi.events;

import java.time.LocalDateTime;
import lombok.Builder;

/**
 * @{literal @Builder} Builder annotation을 사용 하면 컴파일 시점에 Builder 관련 코드를 실행 시킴
 * lombok : compile 시점에 어노테이션으로 특정 코드를 추가할 수 있게 도와 주는 java library
 */
@Builder
public class Event {

  private int id;
  private String name;
  private String description;
  private LocalDateTime beginEnrollmentDateTime;
  private LocalDateTime closeEnrollmentDateTime;
  private LocalDateTime beginEventDateTime;
  private LocalDateTime endEventDateTime;
  private String location; // (optional) 이게 없으면 온라인 모임
  private int basePrice; // (optional)
  private int maxPrice; // (optional)
  private int limitOfEnrollment;
  private boolean offline;
  private boolean free;
  private EventStatus eventStatus;
}
