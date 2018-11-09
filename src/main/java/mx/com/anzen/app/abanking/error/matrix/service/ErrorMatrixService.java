/*
 * Copyright (c) 2018 Anzen Soluciones S.A. de C.V.
 * Mexico D.F.
 * All rights reserved.
 *
 * THIS SOFTWARE IS  CONFIDENTIAL INFORMATION PROPIETARY OF ANZEN SOLUCIONES.
 * THIS INFORMATION SHOULD NOT BE DISCLOSED AND MAY ONLY BE USED IN ACCORDANCE THE TERMS DETERMINED BY THE COMPANY ITSELF.
 */
package mx.com.anzen.app.abanking.error.matrix.service;

import mx.com.anzen.app.abanking.error.matrix.dto.ErrorMatrixDto;

/**
 * <p>TODO [Add comments of the class]</p>
 * 
 * @version abanking-error-matrix
 * @since abanking-error-matrix
 */
public interface ErrorMatrixService {
	
	public ErrorMatrixDto findErrorMatrix(String errorCode);

	
}
