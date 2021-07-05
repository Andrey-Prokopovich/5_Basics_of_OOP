package by.javatraining.task1.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать,
 * вывести на консоль содержимое, дополнить, удалить.
 */

public class Directory implements Serializable {

	private static final long serialVersionUID = -2238345847445757925L;

	private String path;
	private List<File> fileList;

	public Directory() {
		fileList = new LinkedList<File>();
	}

	public Directory(String path) {
		this();

		setPath(path);
	}

	public String getPath() {
		return path;
	}

	public List<File> getFileList() {
		return fileList;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setFileList(List<File> fileList) {
		this.fileList = fileList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileList == null) ? 0 : fileList.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Directory other = (Directory) obj;
		if (fileList == null) {
			if (other.fileList != null) {
				return false;
			}
		} else if (!fileList.equals(other.fileList)) {
			return false;
		}
		if (path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!path.equals(other.path)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Directory [path=" + path + ", fileList=" + fileList + "]";
	}
}
