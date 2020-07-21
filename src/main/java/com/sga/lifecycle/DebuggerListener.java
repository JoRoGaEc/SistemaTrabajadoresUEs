package com.sga.lifecycle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class DebuggerListener implements javax.faces.event.PhaseListener{

	//Logger para mandar la impresion a la consola
	Logger log = (Logger) LogManager.getRootLogger();
	
	@Override
	public void afterPhase(PhaseEvent pe) {
		if(log.isInfoEnabled()) {//Si esta habilitado este nivel 
			log.info("Antes de la fase  " + pe.getPhaseId().toString());
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent pe) {
			if(log.isInfoEnabled()) {
				log.info("Despues de la fase " + pe.getPhaseId());
			}
		
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}

}
