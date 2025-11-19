package com.core.domain.exception;

import com.core.domain.entity.*;

public final class CategoriaInvalidaException extends ExcepcionDominio{
	
	private static final long serialVersionUID = 1L;

		public CategoriaInvalidaException(Categoria categoria) {
			super("La categoría " + categoria + " no cumple las reglas de negocio.");
		}
}
