package oliver.underthesea.demospringsecurityform.account;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  AccountService accountService;

  @Test
  public void index_anonymous() throws Exception {
    mockMvc.perform(get("/").with(anonymous()))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithAnonymousUser
  public void index_anonymous2() throws Exception {
    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  public void index_user() throws Exception {
    mockMvc.perform(get("/").with(user("oliver").roles("USER")))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "oliver", roles = "USER")
  public void index_user2() throws Exception {
    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithUser
  public void index_user3() throws Exception {
    mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  public void index_admin() throws Exception {
    mockMvc.perform(get("/").with(user("admin").roles("ADMIN")))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  public void admin_user() throws Exception {
    mockMvc.perform(get("/admin").with(user("oliver").roles("USER")))
        .andDo(print())
        .andExpect(status().isForbidden());
  }

  @Test
  @WithMockUser(username = "oliver", roles = "USER")
  public void admin_user2() throws Exception {
    mockMvc.perform(get("/admin"))
        .andDo(print())
        .andExpect(status().isForbidden());
  }

  @Test
  @WithUser
  public void admin_user3() throws Exception {
    mockMvc.perform(get("/admin"))
        .andDo(print())
        .andExpect(status().isForbidden());
  }

  @Test
  public void admin_admin() throws Exception {
    mockMvc.perform(get("/admin").with(user("admin").roles("ADMIN")))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "oliver", roles = "ADMIN")
  public void admin_admin2() throws Exception {
    mockMvc.perform(get("/admin"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @Transactional
  public void login_success() throws Exception {
    String username = "oliver";
    String password = "123";
    Account user = this.createUser(username, password);
    mockMvc.perform(formLogin().user(username).password(password))
        .andExpect(authenticated());
  }

  @Test
  @Transactional
  public void login_success2() throws Exception {
    String username = "oliver";
    String password = "123";
    Account user = this.createUser(username, password);
    mockMvc.perform(formLogin().user(user.getUsername()).password(password))
        .andExpect(authenticated());
  }

  @Test
  @Transactional
  public void login_fail() throws Exception {
    String username = "oliver";
    String password = "123";
    Account user = this.createUser(username, password);
    mockMvc.perform(formLogin().user(username).password("12345"))
        .andExpect(unauthenticated());
  }

  private Account createUser(String username, String password) {
    Account account = new Account();
    account.setUsername(username);
    account.setPassword(password);
    account.setRole("USER");
    return accountService.createNew(account);
  }

}