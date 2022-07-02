package com.resourse.human;

public abstract class Staff implements Comparable<Staff> {

	/*
	 * abstract class với nhiệm vụ hiển thị thông tin, các class con phải triển khai
	 * class này
	 */
	abstract void displayInformation(int input);

	private String maNhanVien;
	private String tenNhanVien;
	private int tuoiNhanVien;
	private final int HE_SO_LUONG = 1;
	private String ngayVaoLam;
	private Department boPhan;
	private int soNgayNghi;

// Khai báo constractor Staff với đầy đủ tham số thông tin
	public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, String ngayVaoLam, int soNgayNghi,
			Department boPhan) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.tuoiNhanVien = tuoiNhanVien;
		this.ngayVaoLam = ngayVaoLam;
		this.soNgayNghi = soNgayNghi;
		this.boPhan = boPhan;
	}

// Các hàm getter và setter thể hiện tính đóng gói encapsulation
	public Department getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(Department boPhan) {
		if (boPhan != null)
			this.boPhan = boPhan;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		if (maNhanVien != null)
			this.maNhanVien = maNhanVien;

	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		if (tenNhanVien != null)
			this.tenNhanVien = tenNhanVien;
	}

	public int getTuoiNhanVien() {
		return tuoiNhanVien;
	}

	public void setTuoiNhanVien(int tuoiNhanVien) {
		if (tuoiNhanVien > 18 && tuoiNhanVien <= 50)
			this.tuoiNhanVien = tuoiNhanVien;
	}

	public int getHeSoLuong() {
		return HE_SO_LUONG;
	}

	public String getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(String ngayVaoLam) {
		if (ngayVaoLam != null)
			this.ngayVaoLam = ngayVaoLam;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		if (soNgayNghi > 0 && soNgayNghi <= 30)
			this.soNgayNghi = soNgayNghi;
	}

}
