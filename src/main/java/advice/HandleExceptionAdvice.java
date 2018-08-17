package advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionAdvice {
	@ExceptionHandler(value=Exception.class)
	public String handleException() {
		System.out.println("global.....");
		return "error";
	}
}
