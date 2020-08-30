package io.gofiggy.figgy.internal.utils.bases;

import java.io.File;

import io.gofiggy.figgy.internal.encoders.Encoding;
import io.gofiggy.figgy.internal.encoders.Encodings;

public class BaseFileTools {
	String path = "";
	Encoding enc = Encodings.DEFAULT;
	Boolean useQueue = false;
	File asFile = null;
	
	public BaseFileTools() {}
	public BaseFileTools(String path) { this.path = path; };
	public BaseFileTools(Encoding encoding) { this.enc = encoding; }
	public BaseFileTools(String path, Encoding encoding) {
		this.enc = encoding;
		this.path = path;
	}
	
	public void pushUpdates() {
	}
	
	public void pullUpdates() {
	}
	
	public void getRawContents() {
	}
	
	public void setRawContents() {
	}
	
	public void delete() {
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public Encoding getEncoding() {
		return enc;
	}
	
	public void setEncoding(Encoding encoder) {
		this.enc = encoder;
	}
	
	public void getQueue() {
	}
	
	public void setQueue() {
	}
}
