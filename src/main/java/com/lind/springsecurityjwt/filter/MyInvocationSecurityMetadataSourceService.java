package com.lind.springsecurityjwt.filter;

import com.lind.springsecurityjwt.model.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {


  private HashMap<String, Collection<ConfigAttribute>> map = null;

  /**
   * 加载权限表中所有权限
   */
  public void loadResourceDefine() {
    map = new HashMap<>();
    Collection<ConfigAttribute> array;
    ConfigAttribute cfg;
    //获取数据库的权限表的所有数据，用来和当前用户的权限作比对，这里的url就是需要被权限管理的url，其它url只要登陆就可以访问
    List<Permission> permissions = Arrays.asList(
        new Permission("/index", "首页", "home"),
        new Permission("/user/list", "用户列表", "userList"),
        new Permission("/user/add", "用户添加", "userAdd"),
        new Permission("/user/delete", "用户删除", "userDel")
        // new Permission("/hello", "欢迎") //如果不希望对/hello做权限限制，需要把它注释掉
    );
    for (Permission permission : permissions) {
      array = new ArrayList<>();
      cfg = new SecurityConfig(permission.getTitle());
      //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
      array.add(cfg);
      //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
      map.put(permission.getUrl(), array);
    }

  }

  /**
   * 判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
   *
   * @param object
   * @return
   * @throws IllegalArgumentException
   */
  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    if (map == null) {
      loadResourceDefine();
    }
    //object 中包含用户请求的request 信息
    HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    AntPathRequestMatcher matcher;
    String resUrl;
    for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
      resUrl = iter.next();
      matcher = new AntPathRequestMatcher(resUrl);
      if (matcher.matches(request)) {
        return map.get(resUrl);
      }
    }
    return null;
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }
}
