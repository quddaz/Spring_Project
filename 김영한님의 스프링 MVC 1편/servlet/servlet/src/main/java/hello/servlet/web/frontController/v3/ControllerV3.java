package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;

import java.util.Map;
import java.util.Objects;

public interface ControllerV3 {
  ModelView process(Map<String, String> paramMap);

}
