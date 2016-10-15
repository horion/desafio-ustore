package service;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;



public class HDService {
	
	private FileSystem fileSystem;

	private FileSystem getFileSystem() {
		if (fileSystem == null) {
			fileSystem = FileSystems.getDefault();
		}
		return fileSystem;
	}

	private String retornarEspacoDiscoTotal() {
		String retorno = null;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				retorno = String.valueOf(fs.getTotalSpace());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	private String retornarEspacoDiscoLivre() {
		String retorno = null;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				retorno = String.valueOf((fs.getTotalSpace() - fs.getUsableSpace()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	private String retornarEspacoDiscoEmUso() {
		String retorno = null;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				retorno = String.valueOf(fs.getUsableSpace());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}
	
	public String retornaTodosOsDados(){
		StringBuffer sb = new StringBuffer();
		sb.append("Total: ");
		sb.append(retornarEspacoDiscoTotal());
		sb.append(",");
		sb.append("Livre: ");
		sb.append(retornarEspacoDiscoLivre());
		sb.append(",");
		sb.append("Em Uso: ");
		sb.append(retornarEspacoDiscoEmUso());
		return sb.toString();
		
	}
}
