package com.rui.boo.shiro;

import com.rui.boo.service.MenuService;
import com.rui.boo.service.RoleService;
import com.rui.boo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * 自定义realm
 * @Author rui
 * @Date 2019-05-20 21:55
 **/
public class BooRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

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
        info.setRoles(roleService.getRoleCodesByUseId(authUser.getUserId()));
        info.setStringPermissions(menuService.getPermsByUserId(authUser.getUserId()));

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

        AuthUser user = userService.getAuthUserByAcc(username);

        if(user == null) {
            throw new AuthenticationException("用户不存在");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());

        return info;
    }
}
