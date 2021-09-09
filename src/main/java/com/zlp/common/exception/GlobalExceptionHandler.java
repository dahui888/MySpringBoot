package com.zlp.common.exception;

import com.zlp.common.api.Result;
import com.zlp.common.api.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.Objects;

/**
 * 全局异常处理器
 * 
 * @author admin
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 未知异常
	 * @param e 异常
	 * @return
	 */          
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public Result<String> handleGlobalException(Exception e) {

		log.error("全局异常信息 message={},e={}", e.getMessage(), e);
		return Result.failed(ResultCode.UNKNOWN_EXCEPTION);
	}
	


	/**
	 * validation Exception
	 * @param exception
	 * @return
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({ MethodArgumentNotValidException.class, BindException.class })
	public Result handleBodyValidException(MethodArgumentNotValidException exception) {

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.error("参数绑定异常,ex = {}", fieldErrors.get(0).getDefaultMessage());
		return Result.failed(fieldErrors.get(0).getDefaultMessage());
	}



	/**
	 * 自定义异常
	 */
	@ExceptionHandler(value = CustomException.class)
	public Result processException(CustomException e) {

		log.error("位置=:{} -> 错误信息=:{}", e.getMethod() ,e.getLocalizedMessage());
		ResultCode resultCode = ResultCode.getByCode(e.getCode());
		return Result.failed(Objects.requireNonNull(resultCode));

	}

	/**
	 * 参数格式错误
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public Result methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {

		log.error("错误信息{}", e.getLocalizedMessage());
		return Result.failed(ResultCode.ARGUMENT_TYPE_MISMATCH);
	}

	/**
	 * 参数格式错误
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Result httpMessageNotReadable(HttpMessageNotReadableException e) {

		log.error("错误信息:{}", e.getLocalizedMessage());
		return Result.failed(ResultCode.FORMAT_ERROR);
	}

	/**
	 * 请求方式不支持
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Result httpReqMethodNotSupported(HttpRequestMethodNotSupportedException e) {

		log.error("错误信息:{}", e.getLocalizedMessage());
		return Result.failed(ResultCode.REQ_METHOD_NOT_SUPPORT);
	}

}
