package hello.servlet.web.frontController.v5;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyHandlerAdapter;
import hello.servlet.web.frontController.MyView;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5",urlPatterns = "/front-contrlloer/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
  //모든 컨트롤러 지원을 위해 Object형이다.
  private final Map<String, Object> handlerMappingMap;
  private final List<MyHandlerAdapter> handlerAdapters;
  @Autowired
  public FrontControllerServletV5(Map<String, Object> myHandlerController, List<MyHandlerAdapter> myHandlerAdapters) {
    handlerMappingMap = myHandlerController;
    handlerAdapters = myHandlerAdapters;
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Object handler = getHandler(request);
    if (handler == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    MyHandlerAdapter adapter= getHandlerAdapter(handler);

    ModelView mv = adapter.handle(request, response, handler);
    MyView view = viewResolver(mv.getViewName());
    view.render(mv.getModel(), request, response);
  }

  private MyHandlerAdapter getHandlerAdapter(Object handler) {
    for (MyHandlerAdapter adapter : handlerAdapters) {
      if(adapter.supports(handler)){
        return adapter;
      }
    }
    throw  new IllegalArgumentException("handler adapter을 찾을 수 없습니다. handler="+ handler);
  }

  private Object getHandler(HttpServletRequest request) {
    String requestURI = request.getRequestURI();
    return handlerMappingMap.get(requestURI);
  }
  private MyView viewResolver(String viewName) {
    return new MyView("/WEB-INF/views/" + viewName + ".jsp");
  }
}
