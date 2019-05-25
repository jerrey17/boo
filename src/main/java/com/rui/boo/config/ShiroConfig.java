package com.rui.boo.config;

import com.rui.boo.shiro.BooRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * @Author rui
 * @Date 2019-01-17 22:01
 **/
@SpringBootConfiguration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        return new BooRealm();
    }

//    @Bean
//    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        /**
//         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
//         * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
//         * 加入这项配置能解决这个bug
//         */
//        creator.setUsePrefix(true);
//
//        return creator;
//    }

    /**
     * shiro 拦截器
     *
     * @return
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        // 静态页面，允许匿名访问
        chain.addPathDefinition("/css/**", "anon");
        chain.addPathDefinition("/font/**", "anon");
        chain.addPathDefinition("/images/**", "anon");
        chain.addPathDefinition("/lay/**", "anon");
        chain.addPathDefinition("/sql/**", "anon");
        chain.addPathDefinition("/jquery-3.3.1.min.js", "anon");
        chain.addPathDefinition("/layui.all.js", "anon");
        chain.addPathDefinition("/layui.js", "anon");
        chain.addPathDefinition("/boo/js/**", "anon");
        chain.addPathDefinition("/boo/css/**", "anon");
        chain.addPathDefinition("/common/**", "anon");
        chain.addPathDefinition("/actuator/**", "anon");
        // 登录页面，允许匿名访问
        chain.addPathDefinition("/login", "anon");
        // 登录管理员角色权限
        chain.addPathDefinition("/admin/**", "authc, roles[admin]");

        // 其他路径都需要权限访问
        chain.addPathDefinition("/**", "authc");
//        chain.addPathDefinition("/**", "anon");
        return chain;
    }

    /**
     * FilterRegistrationBean
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean delegatingFilterProxy() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//        proxy.setTargetBeanName("shiroFilterFactoryBean");
//        proxy.setTargetFilterLifecycle(true);
//        filterRegistrationBean.setFilter(proxy);
////        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ERROR);
//        return filterRegistrationBean;
//    }

//    /**
//     * redis 管理session
//     *
//     * @param redisProperties
//     * @return
//     */
//    @Bean
//    public RedisManager redisManager(RedisProperties redisProperties) {
//        RedisManager redisManager = new RedisManager();
//        redisManager.setHost(redisProperties.getHost() + ":" + redisProperties.getPort());
//        redisManager.setPassword(redisManager.getPassword());
//        redisManager.setDatabase(2);
//        redisManager.setJedisPool(redisManager.getJedisPool());
//        redisManager.setTimeout(redisManager.getTimeout());
//        return redisManager;
//    }
//
//    /**
//     * 缓存 redis实现
//     *
//     * @param redisManager
//     * @return
//     */
//    @Bean
//    public CacheManager cacheManager(RedisManager redisManager) {
//        RedisCacheManager redisCacheManager = new RedisCacheManager();
//        redisCacheManager.setKeyPrefix("xsms:auth:session");
//        redisCacheManager.setRedisManager(redisManager);
//        return redisCacheManager;
//    }

}
