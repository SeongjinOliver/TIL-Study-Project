package me.oliver.demoinflearnrestapi.events;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @{literal @Builder} Builder annotation을 사용 하면 컴파일 시점에 Builder 관련 코드를 실행 시킴 lombok : compile 시점에
 * 어노테이션으로 특정 코드를 추가할 수 있게 도와 주는 java library
 * @{literal @EqualsAndHashCode} of="id"라고 준 이유는 equals와 haashcode를 구현할 때 모든 아래의 필드(변수)를 사용 나중에 객체간의
 * 연관관계가 있을 때 서로 상호 참조 하는 관계가 되면 equals와 hashcode 구현한 코드 안에서 stckOverFlow가 발생 할 수 있음, 그리고 다른
 * entity와의 연관관계를 만들면 좋지 않음 -> 서로간의 매서드를 호출하다가 stackOverFlow가 발생할 수 있음
 *
 * lombok 에노테이션은 메타 에노테이션으로 사용할 수 없음
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
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
