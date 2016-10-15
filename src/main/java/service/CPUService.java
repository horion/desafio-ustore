package service;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class CPUService {

	private Sigar sigar;
	private Sigar getSigar() {
		if (sigar == null) {
			sigar = new Sigar();
		}
		return sigar;
	}
	
	
	public String retornarUsoMemoriaLivre() throws SigarException {
		return String.valueOf(getSigar().getMem().getActualFree());
	}

	public String retornarUsoMemoriaTotal() throws SigarException {
		return String.valueOf(getSigar().getMem().getTotal());
	}

	public String retornarUsoMemoriaEmUso() throws SigarException {
		return String.valueOf(getSigar().getMem().getActualUsed());
	}
	
	public String retornaTodosOsDado(){
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("Total: ");
			sb.append(retornarUsoMemoriaLivre());
			sb.append(",");
			sb.append("Livre: ");
			sb.append(retornarUsoMemoriaTotal());
			sb.append(",");
			sb.append("Em Uso: ");
			sb.append(retornarUsoMemoriaEmUso());
		} catch (SigarException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
