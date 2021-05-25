package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.model.UserExample;
import life.majiang.community.provider.GithubProvider;
import life.majiang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * 第三方登录授权
 * @ClassName AuthorizeController
 * @Description TODO
 * @date 2021/5/11 22:42
 * @Version 1.0
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private  String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;


    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO).split("&")[0].split("=")[1];
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());

        if (githubUser != null && githubUser.getId()!=null){
            //登录成功
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccount(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setAvatarUrl(githubUser.getAvatar_url());
            userService.createOrUpdate(user);
            System.out.println(githubUser);

            UserExample userExample = new UserExample();
            userExample.createCriteria().andAccountEqualTo(user.getAccount());


            List<User> users = userMapper.selectByExample(userExample);
            user.setId(userMapper.selectByExample(userExample).get(0).getId());
            //user.setId(userMapper.findByAccountId(user.getAccount()).getId());
            response.addCookie(new Cookie("token",token));
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
