package br.com.viattec.portalquestoes.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

@Component
public class PortalQuestoesDialect extends AbstractProcessorDialect{

	protected PortalQuestoesDialect() {
		super("Portal Questões", "pq", StandardDialect.PROCESSOR_PRECEDENCE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();		
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		return processadores;
	}

}
