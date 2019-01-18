package com.rui.boo.shiro;

import com.rui.boo.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author rui
 * @Date 2019-01-17 21:36
 **/
public class AuthRealm extends AuthorizingRealm {

    /**
     * 授权
     * 授权的方法是在碰到<shiro:hasPermission>标签的时候调用的,
     * 它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,
     * 如果有,里面的内容显示,如果没有,里面的内容不予显示
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User user = (User) principals.fromRealm(this.getClass().getName()).iterator().next();

        Set<String> permissions = new HashSet<>();
        // TODO 将用户的权限装到permissions中

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return null;
    }

    /**
     * 认证、登录
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String userName = usernamePasswordToken.getUsername();

        // TODO 根据userName查询用户信息
        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");

        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
        // 带盐值的对象
        //SimpleAuthenticationInfo(Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName)
    }
}
