/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.error.matrix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.com.anzen.app.abanking.error.matrix.dto.ErrorMatrixDto;
import mx.com.anzen.app.abanking.error.matrix.service.ErrorMatrixService;

/**
 * <p>TODO [Add comments of the class]</p>
 * 
 * @version abanking-error-matrix
 * @since abanking-error-matrix
 */
@RestController
@RequestMapping("/errorMatrix")
public class ErrorMatrixController {

	private static final Logger logger = LoggerFactory.getLogger(ErrorMatrixController.class);
	
	@Autowired
	private ErrorMatrixService matrixService;

	@ApiOperation(value = "Gets error description for nova bank")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ErrorMatrixDto getError(
			@ApiParam (value = "Represent error code to find")
			@RequestParam(name = "code", required = false) String errorCode) {

		logger.info("Starting searching error matrix");
		ErrorMatrixDto matrixDto = matrixService.findErrorMatrix(errorCode);

		logger.info("Error matrix executed success");
		return matrixDto;
	}

}
