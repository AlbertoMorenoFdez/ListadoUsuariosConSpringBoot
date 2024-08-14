
package com.prueba.servicio;

import com.prueba.dao.IndividuoDao;
import com.prueba.domain.Individuo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IndividuoServicioImplement implements IndividuoServicio {

    @Autowired
    private IndividuoDao individuoDao;
    
    @Override
    @Transactional(readOnly =true)
    public List<Individuo> listaIndividuos() {
        return (List<Individuo>) individuoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Individuo individuo) {
        individuoDao.save(individuo);
    }

    @Override
    @Transactional
    public void eliminar(Individuo individuo) {
        individuoDao.delete(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Individuo individuo) {
        return individuoDao.findById(individuo.getId_individuo()).orElse(null);
    }
    
}
