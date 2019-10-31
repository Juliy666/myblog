package cn.juliy.myblog.config;

import cn.juliy.myblog.entity.UserEntity;
import cn.juliy.myblog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 * @author lenovo
 *
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权逻辑");
		System.out.println("执行授权逻辑");
		System.out.println("执行授权逻辑");
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		//添加资源的授权字符串，硬编码
		/*info.addStringPermission("admin:publish");*/

		//到数据库查询当前登录用户的授权字符串,这里再查一次数据库是为了一开始入库的时候一般都是加密的（这里我还没有做加密，以后做加密了这里可以不用改业务）
		//获取当前登录用户
		Subject subject = SecurityUtils.getSubject();
		UserEntity userEntity = (UserEntity)subject.getPrincipal();
		UserEntity dbuser = userService.getById(userEntity.getId());
		System.out.println("dbuser"+dbuser);
		info.addStringPermission(dbuser.getPerms());
		return info;
	}


	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		String username = token.getUsername();
		String password = String.valueOf(token.getPassword());
		UserEntity userEntity = userService.login(username,password);
		if(userEntity==null){
			//用户名不存在
			return null;//shiro底层会抛出UnKnowAccountException
		}

		//2.判断密码
		return new SimpleAuthenticationInfo(userEntity,userEntity.getPassword(),"");
	}

}
