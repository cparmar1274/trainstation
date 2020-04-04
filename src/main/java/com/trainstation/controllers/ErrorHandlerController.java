/*
 * package com.trainstation.controllers;
 * 
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.boot.web.servlet.error.ErrorController; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * @Controller public class ErrorHandlerController implements ErrorController {
 * 
 * @GetMapping("/error") public @ResponseBody String getError(HttpServletRequest
 * request,HttpServletResponse response) { return
 * response.getStatus()+" - Something went wrong!"; }
 * 
 * @Override public String getErrorPath() { return "/error"; } }
 */