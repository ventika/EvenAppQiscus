package com.example.eventapp;

public class Acara {
	public String namaAcara;
	public String tanggal;
	public String jam;
	public Acara(String namaAcara, String tanggal, String jam) {
		super();
		this.namaAcara = namaAcara;
		this.tanggal = tanggal;
		this.jam = jam;
	}
	public String getNamaAcara() {
		return namaAcara;
	}
	public String getTanggal() {
		return tanggal;
	}
	public String getJam() {
		return jam;
	}
	
	
}
