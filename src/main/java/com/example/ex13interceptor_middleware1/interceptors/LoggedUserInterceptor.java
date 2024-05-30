package com.example.ex13interceptor_middleware1.interceptors;

import com.example.ex13interceptor_middleware1.users.models.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class LoggedUserInterceptor implements HandlerInterceptor {

    List<User> users = new ArrayList<>(Arrays.asList(new User(1, "gi", "ge"), new User(2, "ga", "gu")));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String userIdString = request.getHeader("userId");
    if (userIdString == null)
        return true;
    long userId = Long.parseLong(userIdString);
        Optional<User> user = users.stream().filter(singlUser ->{return singlUser.getId() == userId;}).findFirst();
        user.ifPresent(value -> request.setAttribute("LoggedUserInterceptor-user", value));
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
