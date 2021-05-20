package me.oliver.java8to11.Optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;

public class App {

  public static void main(String[] args) {

    List<OnlineClass> springClasses = new ArrayList<>();
    springClasses.add(new OnlineClass(1, "spring boot", true));
    springClasses.add(new OnlineClass(2, "spring data jpa", true));
    springClasses.add(new OnlineClass(3, "spring mvc", false));
    springClasses.add(new OnlineClass(4, "spring core", false));
    springClasses.add(new OnlineClass(5, "rest api development", false));

    OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);

    /**
     * 아래와 같은 코드는 에러를 만들기 쉬운 코드이다. 왜? null을 체크하는 것을 잊고 구현 안할 수 있기 때문이다.
     * 근본적으로 매번 우리는 null 체크를 할수 없다 왜? 사람이기 때문에 실수를 하기 때문이다.
     * 두번째 문제는 getter에서 null을 리턴하는것 자체가 문제이다. 자바 8 이전에는 별다른 대안이 없었다.
     * 이 경우는 에러를 넘기는 경우로 해결할 수 있었다. 로직을 처리할 때 에러를 처리하는 것은 그렇게 좋은 습관이 아니다.
     */
//    Progress progress = spring_boot.getProgress();
//    if(progress != null) {
//      System.out.println(progress.getStudyDuration());
//    }
//    Duration studyDuration = spring_boot.getProgress().get().getStudyDuration();
//    System.out.println(studyDuration);

    /**
     * Optional 2번째 강좌
     */
    Optional<OnlineClass> optional = springClasses.stream()
        .filter(oc -> oc.getTitle().startsWith("spring"))
        .findFirst();

    boolean present = optional.isPresent();
    System.out.println(present);

    // 값이 있을 경우에는 상관없는데 값이 비어 있을 경우에는 runtimeException이 발생한다.
    OnlineClass onlineClass = optional.get();
    System.out.println(onlineClass.getTitle());

    // filter는 optional로 나옴
    Optional<OnlineClass> onlineClass1 = optional.filter(oc -> !oc.isClosed());

    // map도 optional로 나옴
    Optional<Integer> integer = optional.map(OnlineClass::getId);
    System.out.println(integer.isPresent());

    // 꺼내는 타입 자체가 optional이면 flatMap을 사용해라
    Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);

//     XXXX
//    Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
//    Optional<Progress> progress2 = progress1.orElse(Optional.empty());

  }

}
