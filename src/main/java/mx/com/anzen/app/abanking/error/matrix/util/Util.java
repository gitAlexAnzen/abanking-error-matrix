/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.error.matrix.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.com.anzen.app.abanking.error.matrix.dto.ErrorMatrixDto;

/**
 * <p>TODO [Add comments of the class]</p>
 * 
 * @version abanking-error-matrix
 * @since abanking-error-matrix
 */
@Component
public class Util {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Util.class);
	
	/**
	 * <p>TODO [Add comments of method]</p>
	 * 
	 * @param errorCode
	 * @return
	 */
	public ErrorMatrixDto getEmptyValueError(String errorCode) {

		logger.info("Value code: {} ", errorCode);
		ErrorMatrixDto matrixDto = new ErrorMatrixDto();		
		matrixDto.setErrorCode(MatrixConstants.BAD_REQUEST_CODE);
		matrixDto.setStatus(MatrixConstants.BAD_REQUEST_STATUS);
		matrixDto.setMessage(MatrixConstants.BAD_REQUEST_MESSAGE);
		return matrixDto;
	}

	/**
	 * <p>TODO [Add comments of method]</p>
	 * 
	 * @param obj
	 * @return
	 */
	public ErrorMatrixDto createEmptyMessage() {

		logger.info("Creating object with empty response of database");
		ErrorMatrixDto matrixDto = new ErrorMatrixDto();		
		matrixDto.setErrorCode(MatrixConstants.NO_ATTRIBUTE_TO_ITERATE_CODE);
		matrixDto.setStatus(MatrixConstants.BAD_REQUEST_STATUS);
		matrixDto.setMessage(MatrixConstants.EMPTY_MESSAGE_RESPONSE);
		return matrixDto; 
	}
}