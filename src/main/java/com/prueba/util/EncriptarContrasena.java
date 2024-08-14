
package com.prueba.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarContrasena {
    
    public static void main(String[] args) {
        
        String contrasena = "123";
        System.out.println("Contraseña actual = " + contrasena);
        System.out.println("Contraseña encriptada = " + encriptarContrasena(contrasena));
        
        String contrasena2 = "321";
        System.out.println("Contraseña2 actual = " + contrasena2);
        System.out.println("Contraseña2 encriptada = " + encriptarContrasena(contrasena2));
        
    }
    
    public static String encriptarContrasena(String contrasena){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(contrasena);
    }
    
}
