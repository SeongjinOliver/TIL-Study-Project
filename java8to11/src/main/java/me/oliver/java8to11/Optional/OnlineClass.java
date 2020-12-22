package me.oliver.java8to11.Optional;

import java.util.Optional;
import javax.swing.text.html.Option;

public class OnlineClass {

  private Integer id;

  private String title;

  private boolean closed;

  public Progress progress;

  public OnlineClass(Integer id, String title, boolean closed) {
    this.id = id;
    this.title = title;
    this.closed = closed;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  /**
   * Optional은 return type으로만 쓰는것이 권장사항이다.
   * null일 수 있는 값은 ofNullable로 감싸는것이 좋다.
   * of로 하면 nullPointerException 예외가 발생한다.
   * @return
   */
  public Optional<Progress> getProgress() {
    return Optional.empty();
  }

  public void setProgress(Progress progress) {
    this.progress = progress;
  }

  //public Optional<Progress> getProgress() {
//    return Optional.empty();
//  }

}
