package com.erensayar.CourseOtomation.error.exception;

import static com.erensayar.CourseOtomation.error.exception.ExceptionConstants.INTERNAL_SERVER_ERROR_CODE;
import static com.erensayar.CourseOtomation.error.exception.ExceptionConstants.INTERNAL_SERVER_ERROR_MESSAGE;

public class InternalServerErrorException extends BaseException {

    private static final String ERROR_CODE = INTERNAL_SERVER_ERROR_CODE;
    private static final String ERROR_MESSAGE = INTERNAL_SERVER_ERROR_MESSAGE;

    public InternalServerErrorException() {
        super(ERROR_CODE, ERROR_MESSAGE);
    }

    public InternalServerErrorException(final String errCode, final String errorMessage) {
        super(errCode, errorMessage);
    }

}