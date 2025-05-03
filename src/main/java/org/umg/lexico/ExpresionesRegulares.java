package org.umg.lexico;

public class ExpresionesRegulares {

    public static final String EXP_REG_1 = "^(?=(?:.*[A-Z]){2,})(?=.*[!@#$&*])(?=(?:.*[0-9]){2,})(?=(?:.*[a-z]){3,}).{8,}$";

    public static final String EXP_REG_2 = "^[a-z0-9_-]{3,16}$";

    public static final String EXP_REG_3 = "^-?[0-9]+(\\.[0-9]+)?$";

    public static final String EXP_REG_4 = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$";

    public static final String EXP_REG_5 = "^[0-9]+[.,]00$";

}


