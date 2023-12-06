package com.rocha.app.a.product.entity;

public enum TipoUsuario {

	USUARIO_AFILIADO(1),
	USUARIO_EMPLEADO(2),
	USUARIO_INVITADO(3);

    private final int codigo;

    TipoUsuario(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
