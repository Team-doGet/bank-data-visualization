package site.doget.controller;

import site.doget.common.ApiResponse;

import java.util.Map;

public interface Controller {

    ApiResponse<?> process(String requestURI, Map<String, String> paramMap);
}
