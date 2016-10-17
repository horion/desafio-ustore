package service;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import domain.Memory;
import utils.Utils;

public class MemoryService {

	private Sigar sigar;
	private Sigar getSigar() {
		if (sigar == null) {
			sigar = new Sigar();
		}
		return sigar;
	}
	
	
	public Long retornarUsoMemoriaLivre() throws SigarException {
		return getSigar().getMem().getActualFree();
	}

	public Long retornarUsoMemoriaTotal() throws SigarException {
		return getSigar().getMem().getTotal();
	}

	public Long retornarUsoMemoriaEmUso() throws SigarException {
		return getSigar().getMem().getActualUsed();
	}
	
	public Memory retornaTodosOsDado(){
		Memory memory = new Memory();
		try {
			memory.setMemoriaLivre(Utils.readableFileSize(retornarUsoMemoriaLivre()));
			memory.setMemoriaEmUso(Utils.readableFileSize(retornarUsoMemoriaEmUso()));
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return memory;
	}
}
