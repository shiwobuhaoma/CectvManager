package com.cec.tv.realm;

import com.cec.tv.dao.PermissionMapper;
import com.cec.tv.dao.RoleMapper;
import com.cec.tv.dao.UserMapper;
import com.cec.tv.model.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyShiroRelam extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("用户权限配置。。。。。。。。。。");
        //访问@RequirePermission注解的url时触发
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userName  = (String)principals.getPrimaryPrincipal();
        Set<String> roles = roleMapper.queryRolesByUserName(userName);
        Set<String> permissions = permissionMapper.queryPermissionByUserName(userName);
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    //验证用户登录信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("验证用户登录信息");
        String username = (String)token.getPrincipal();
        System.out.println("登录用户名： "+username);
        System.out.println(token.getCredentials());
        //从数据库查询出User信息及用户关联的角色，权限信息，以备权限分配时使用
        User user = userMapper.findUserByName(username);
        if(null == user) {return null;}
        System.out.println("username: "+user.getUsername()+" ; password : "+user.getUserpwd());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getUserpwd(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }
}