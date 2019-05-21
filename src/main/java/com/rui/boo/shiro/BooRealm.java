package com.rui.boo.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Objects;

/**
 * 自定义realm
 * @Author rui
 * @Date 2019-05-20 21:55
 **/
public class BooRealm extends AuthorizingRealm {

    /**
     * 权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AuthUser authUser = (AuthUser) this.getAvailablePrincipal(principals);

        if(Objects.isNull(authUser)) {
            throw new AuthorizationException("用户未授权");
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setRoles();// TODO set roles
//        info.setStringPermissions(); // TODO set perms

        return info;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();

        if(Objects.isNull(username)) {
            throw new AuthenticationException("登录认证已失效");
        }

        AuthUser user = null; // todo 查询db获取用户信息

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());

        return info;
    }
}
