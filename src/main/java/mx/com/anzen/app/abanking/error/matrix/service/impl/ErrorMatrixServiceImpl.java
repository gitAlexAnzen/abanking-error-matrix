/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.error.matrix.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.anzen.app.abanking.error.matrix.dto.ErrorMatrixDto;
import mx.com.anzen.app.abanking.error.matrix.jpa.model.ErrorMatrix;
import mx.com.anzen.app.abanking.error.matrix.jpa.repository.ErrorMatrixRepository;
import mx.com.anzen.app.abanking.error.matrix.service.ErrorMatrixService;
import mx.com.anzen.app.abanking.error.matrix.util.Util;

/**
 * <p>TODO [Add comments of the class]</p>
 * 
 * @version abanking-error-matrix
 * @since abanking-error-matrix
 */
@Service
public class ErrorMatrixServiceImpl implements ErrorMatrixService {

	private static final Logger logger = LoggerFactory.getLogger(ErrorMatrixServiceImpl.class);

	@Autowired
	ErrorMatrixRepository matrixRepository;

	@Autowired
	Util util;

	/* 
	 * @see mx.com.anzen.app.abanking.error.matrix.service.ErrorMarixService#findErrorMatrix(java.lang.String)
	 */
	@Override
	public ErrorMatrixDto findErrorMatrix(String errorCode) {

		logger.info("Starting search of code: {} in matrix", errorCode);
		ErrorMatrixDto matrixDto = new ErrorMatrixDto();

		if(errorCode == null || errorCode.isEmpty() ) {

			matrixDto = util.getEmptyValueError(errorCode);

		} else {

			ErrorMatrix errorMatrix = matrixRepository.findOne(errorCode.toUpperCase());
			matrixDto = validateResponse(errorCode, errorMatrix, matrixDto);
		}

		logger.info("Executed searching  of error matrix");	
		return matrixDto;
	}

	/**
	 * <p>TODO [Add comments of method]</p>
	 * 
	 * @param errorCode
	 * @param errorMatrix
	 * @param matrixDto
	 * @return
	 */
	private ErrorMatrixDto validateResponse(String errorCode,ErrorMatrix errorMatrix, ErrorMatrixDto matrixDto) {

		logger.info("Validating information of object: ErrorMatrix ");
		if(errorMatrix == null) {
			logger.info("No code found  in database: {} ", errorCode);
			matrixDto = util.createEmptyMessage();

		} else {

			matrixDto.setErrorCode(errorMatrix.getErrorCode());
			matrixDto.setStatus(errorMatrix.getStatus());
			matrixDto.setMessage(errorMatrix.getMessage());
		}
		return matrixDto;
	}

}
