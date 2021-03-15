package com.tr.task.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tr.task.dto.ErrorDetail;
import com.tr.task.dto.ServiceResult;
import com.tr.task.exceptions.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(value = { IllegalArgumentException.class, EmptyResultDataAccessException.class })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> illegalArgumentExceptionHadler(RuntimeException ex) {
		return ResponseEntity.ok(ex.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ServiceResult<?> handleMethodArgumentNotValidExcepiton(MethodArgumentNotValidException mValidException,
			BindingResult bindingResult) {

		List<FieldError> fieldErrors = mValidException.getFieldErrors();

		List<ErrorDetail> errorDetails = new ArrayList<>();

		if (fieldErrors != null && fieldErrors.size() > 0) {
			fieldErrors.forEach(fieldError -> errorDetails.add(new ErrorDetail(fieldError.getCode(),
					fieldError.getField(),
					messageSource.getMessage(fieldError.getDefaultMessage(), null, LocaleContextHolder.getLocale()))));
		}

		return new ServiceResult<>(errorDetails);
	}

	@ExceptionHandler(BadCredentialsException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ServiceResult<?> handleBadCredentialsException(BadCredentialsException ex) {
		List<ErrorDetail> errorDetails = new ArrayList<>();
		errorDetails
				.add(new ErrorDetail(messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale())));
		return new ServiceResult<>(errorDetails);
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ServiceResult<?> handleBusinessException(BusinessException ex) {
		List<ErrorDetail> errorDetails = new ArrayList<>();
		errorDetails.add(new ErrorDetail(
				messageSource.getMessage(ex.getMessage(), ex.getArgs(), LocaleContextHolder.getLocale())));
		return new ServiceResult<>(errorDetails);
	}
	

}
