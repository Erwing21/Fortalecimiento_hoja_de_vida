package com.estudiante.hojadevida.faces;

import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;


public class RastreoFases implements PhaseListener {

    private static final long serialVersionUID = 1L;

    private static final String PREFIJO = "[Semana 16 | RastreoFases] ";


    @Override
    public void beforePhase(PhaseEvent evento) {
        PhaseId fase = evento.getPhaseId();
        System.out.println(PREFIJO + ">> INICIO fase " + fase.getOrdinal() + " " + fase.getName());
    }


    @Override
    public void afterPhase(PhaseEvent evento) {
        PhaseId fase = evento.getPhaseId();
        FacesContext contexto = evento.getFacesContext();
        String detalle = "";


        if (fase == PhaseId.RESTORE_VIEW) {
            detalle = contexto.isPostback()
                    ? " | POSTBACK: se restauro la vista que envio el formulario"
                    : " | GET inicial: se crea una vista nueva";
        }

        if (fase == PhaseId.PROCESS_VALIDATIONS) {
            detalle = contexto.isValidationFailed()
                    ? " | validacion FALLIDA: salta a RENDER_RESPONSE (fases 4 y 5 no se ejecutan)"
                    : " | validacion CORRECTA: continua con UPDATE_MODEL_VALUES";
        }

        if (fase == PhaseId.RENDER_RESPONSE) {
            UIViewRoot vista = contexto.getViewRoot();
            detalle = " | vista dibujada: " + (vista != null ? vista.getViewId() : "(ninguna)");
        }

        System.out.println(PREFIJO + "<< FIN    fase " + fase.getOrdinal() + " " + fase.getName() + detalle);
    }


    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
