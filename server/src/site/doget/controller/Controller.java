package site.doget.controller;

import site.doget.common.ApiResponse;

import java.util.Map;

public interface Controller {

    ApiResponse<?> process(Map<String, String> paramMap);
}
