package hello.servlet.web.frontController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {
  /**
   * 해당 핸들러에 대해 지원이 가능한지 유무를 판별하여 리턴한다.
   * @param handler
   * @return
   */
  boolean supports(Object handler);

  /**
   * 프론트 컨트롤러가 아닌 핸들러가 직접 컨트롤러들을 호출한다.
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws ServletException
   * @throws IOException
   */
  ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}