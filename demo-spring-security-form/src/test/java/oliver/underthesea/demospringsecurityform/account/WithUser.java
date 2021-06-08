package oliver.underthesea.demospringsecurityform.account;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.security.test.context.support.WithMockUser;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "oliver", roles = "USER")
public @interface WithUser {
}
