package service;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import domain.HardDisk;
import utils.Utils;



public class HDService {
	
	private FileSystem fileSystem;

	private FileSystem getFileSystem() {
		if (fileSystem == null) {
			fileSystem = FileSystems.getDefault();
		}
		return fileSystem;
	}


	private Long retornarEspacoDiscoLivre() {
		Long retorno = 0L;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				retorno = retorno + fs.getUsableSpace() ;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	private Long retornarEspacoDiscoEmUso() {
		Long retorno = 0L;
		Long total = 0L;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				total = total + fs.getTotalSpace();
				
				retorno = total - retornarEspacoDiscoLivre();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}
	
	public HardDisk retornaTodosOsDados(){
		HardDisk hd = new HardDisk();
		hd.setEspacoLivre(Utils.readableFileSize(retornarEspacoDiscoLivre()));
		hd.setEspacoEmUso(Utils.readableFileSize(retornarEspacoDiscoEmUso()));
		return hd;
		
	}
}
