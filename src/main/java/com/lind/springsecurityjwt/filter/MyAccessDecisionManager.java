package com.lind.springsecurityjwt.filter;

import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

  /**
   * 判定是否拥有权限的决策方法.
   *
   * @param authentication   是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
   * @param object           包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
   * @param configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
   * @throws AccessDeniedException
   * @throws InsufficientAuthenticationException
   */
  @Override
  public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
    if(configAttributes==null){
      return;
    }
    Iterator<ConfigAttribute> iterator = configAttributes.iterator();
    while (iterator.hasNext()){
      ConfigAttribute c = iterator.next();
      String needPerm = c.getAttribute();
      for(GrantedAuthority ga : authentication.getAuthorities()) {
        // 匹配用户拥有的ga 和 系统中的needPerm
        if(needPerm.trim().equals(ga.getAuthority())) {
          return;
        }
      }
    }
    throw new AccessDeniedException("抱歉，您没有访问权限");
  }

  @Override
  public boolean supports(ConfigAttribute attribute) {
    return true;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }
}
