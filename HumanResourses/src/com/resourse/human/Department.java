package com.resourse.human;

public class Department {
	private String tenBoPhan;
	private int maBoPhan;
	private int soLuongNhanVien;

	public Department(String tenBoPhan) {

		this.tenBoPhan = tenBoPhan;
	}

	public Department(String tenBoPhan, int maBoPhan, int soLuongNhanVien) {

		this(tenBoPhan);
		this.maBoPhan = maBoPhan;
		this.soLuongNhanVien = soLuongNhanVien;
	}

	public int getMaBoPhan() {
		return maBoPhan;
	}

	public void setMaBoPhan(int maBoPhan) {
		if (maBoPhan > 0)
			this.maBoPhan = maBoPhan;
	}

	public String getTenBoPhan() {
		return tenBoPhan;
	}

	public void setTenBoPhan(String tenBoPhan) {
		if (tenBoPhan != null)
			this.tenBoPhan = tenBoPhan;
	}

	public int getSoLuongNhanVien() {
		return soLuongNhanVien;
	}

	public void setSoLuongNhanVien(int soLuongNhanVien) {
		if (soLuongNhanVien > 0)
			this.soLuongNhanVien = soLuongNhanVien;
	}

	// override hàm toString định dạng hiển thị thông tin các bộ phận
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ten bo phan: " + tenBoPhan + " - ma bo phan: " + maBoPhan + " - so nhan vien: " + soLuongNhanVien
				+ " nhan vien";
	}

}
