package br.com.escuderodev.bug_do_milenio_ee.controller;

import br.com.escuderodev.bug_do_milenio_ee.BeanDataHora;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "dataHoraController")
@RequestScoped
public class DataHoraController {

    @EJB
    private BeanDataHora beanDataHora;

    public BeanDataHora getBeanDataHora() {
        return beanDataHora;
    }

    public void setBeanDataHora(BeanDataHora beanDataHora) {
        this.beanDataHora = beanDataHora;
    }
}
