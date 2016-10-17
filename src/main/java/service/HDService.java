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
		Long retorno = null;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				retorno = fs.getUsableSpace();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	private Long retornarEspacoDiscoEmUso() {
		Long retorno = null;
		for (FileStore fs : getFileSystem().getFileStores()) {
			try {
				retorno = fs.getTotalSpace() - fs.getUsableSpace();
				break;
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
