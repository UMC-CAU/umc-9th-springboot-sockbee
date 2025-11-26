package com.example.umc9th.global.resolver;

import com.example.umc9th.global.annotation.PageParam;
import com.example.umc9th.global.apiPayload.code.error.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    private static final int PAGE_SIZE = 10;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageParam.class) && Pageable.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        PageParam pageParam = parameter.getParameterAnnotation(PageParam.class);
        String queryParamName = pageParam != null ? pageParam.value() : "page";
        String rawValue = webRequest.getParameter(queryParamName);
        int page = parseAndValidatePage(rawValue);
        return PageRequest.of(page - 1, PAGE_SIZE);
    }

    private int parseAndValidatePage(String rawValue) {
        try {
            int page = Integer.parseInt(rawValue);
            if (page < 1) {
                throw new GeneralException(GeneralErrorCode.BAD_REQUEST);
            }
            return page;
        } catch (NumberFormatException ex) {
            throw new GeneralException(GeneralErrorCode.BAD_REQUEST);
        }
    }
}

