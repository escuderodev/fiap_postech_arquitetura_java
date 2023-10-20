package br.com.escuderodev.bug_do_milenio_ee;

import jakarta.ejb.Stateless;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Stateless
public class BeanDataHora {

    public String getDataHoraServidor() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return simpleDateFormat.format(Calendar.getInstance().getTime());

    }
}
