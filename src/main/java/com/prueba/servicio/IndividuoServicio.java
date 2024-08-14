
package com.prueba.servicio;

import com.prueba.domain.Individuo;
import java.util.List;

public interface IndividuoServicio {
    
    public List<Individuo> listaIndividuos();
    
    public void guardar(Individuo individuo);
    
    public void eliminar (Individuo individuo);
    
    public Individuo localizarIndividuo(Individuo individuo);
    
    
}
