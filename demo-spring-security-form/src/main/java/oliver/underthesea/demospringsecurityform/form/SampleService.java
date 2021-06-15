package oliver.underthesea.demospringsecurityform.form;

import java.util.Collection;
import oliver.underthesea.demospringsecurityform.account.Account;
import oliver.underthesea.demospringsecurityform.account.AccountContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 사용자의 권한을 여러개 갖을 수 있음
 * Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
 */
@Service
public class SampleService {

  public void dashboard() {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    Object principal = authentication.getPrincipal();
//    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//    Object credentials = authentication.getCredentials();
//    boolean authenticated = authentication.isAuthenticated();
    // Thread Local Class 사용해서  account 정보 가져옴
    Account account = AccountContext.getAccount();
    System.out.println("===================");
    System.out.println(account.getUsername());
  }
}
