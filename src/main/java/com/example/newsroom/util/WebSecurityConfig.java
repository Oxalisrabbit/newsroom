//package com.example.newsroom.util;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
///**
// * 登录配置 博客出处：http://www.cnblogs.com/GoodHelper/
// *
// */
//@Configuration
//public class WebSecurityConfig extends WebMvcConfigurationSupport {
//
//    /**
//     * 登录session key
//     */
//    public final static String SESSION_USERNAME = "username";
//    public final static String SESSION_ROLE = "role";
//    public final static String SESSION_ID = "id";
//
//    @Bean
//    public SecurityInterceptor getSecurityInterceptor() {
//        return new SecurityInterceptor();
//    }
//
//
//
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
//
//        // 排除配置
//        addInterceptor.excludePathPatterns("/");
//        addInterceptor.excludePathPatterns("/error");
//
//        addInterceptor.excludePathPatterns("/common/**");
//        addInterceptor.excludePathPatterns("/search/**");
//        addInterceptor.excludePathPatterns("/file/**");
//
//        addInterceptor.excludePathPatterns("/**/*.css");
//        addInterceptor.excludePathPatterns("/**/*.map");
//        addInterceptor.excludePathPatterns("/**/*.js");
//
//        // 拦截配置
//        addInterceptor.addPathPatterns("/**");
//    }
//
//    private class SecurityInterceptor extends HandlerInterceptorAdapter {
//
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            HttpSession session = request.getSession();
//            if (session.getAttribute(SESSION_USERNAME) != null && session.getAttribute(SESSION_ROLE) != null && session.getAttribute(SESSION_ID) != null) {
//                return true;
//            }
//
//            System.out.println(request.getRequestURI());
//            // 跳转登录
//            String url = "/";
//            response.sendRedirect(url);
//            return false;
//        }
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//}