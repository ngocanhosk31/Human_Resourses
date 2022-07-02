package com.resourse.human;

public class Manager extends Staff implements ICalculator, Comparable<Staff> {
	// override lại hàm compareTo của interface Comparable để so sánh lương giữa các
	// phần tử
	@Override
	public int compareTo(Staff o) {
		// TODO Auto-generated method stub
		return (int) (this.tinhLuong() - ((ICalculator) o).tinhLuong());
	}

	private String chucDanh;

	public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, String ngayVaoLam, int soNgayNghi,
			Department boPhan, String chucDanh) {
		super(maNhanVien, tenNhanVien, tuoiNhanVien, ngayVaoLam, soNgayNghi, boPhan);
		// TODO Auto-generated constructor stub
		this.chucDanh = chucDanh;
	}

	// Triển khai hàm tính lương kế thừa từ lớp cha Staff
	public double tinhLuong() {
		double luong = 0;
		switch (chucDanh) {
		case "Business Leader":
			luong = getHeSoLuong() * 5000000 + 8000000;
			break;
		case "Project Leader":
			luong = getHeSoLuong() * 5000000 + 5000000;
			break;
		case "Technical Leader":
			luong = getHeSoLuong() * 5000000 + 6000000;
			break;
		}
		return luong;

	}

	public String getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(String chucDanh) {
		if (chucDanh != null)
			this.chucDanh = chucDanh;
	}

	@Override
	void displayInformation(int input) {
		switch (input) {
		case 1:
			System.out.printf("ma: %-10s ten: %-10s tuoi: %-10d ngay vao: %-10s so ngay nghi: %-10d chuc: %-10s\n",
					this.getMaNhanVien(), this.getTenNhanVien(), this.getTuoiNhanVien(), this.getNgayVaoLam(),
					this.getSoNgayNghi(), this.getChucDanh());
			break;

		case 3:

			System.out.printf("quan ly: %-10s chuc vu: %-20s bo phan: %-10s\n", this.getTenNhanVien(),
					this.getChucDanh(), getBoPhan().getTenBoPhan());
			break;

		case 6:
			System.out.printf("quan ly: %-12s ma: %-10s luong: %-10.0f chuc vu: %-20s\n", this.getTenNhanVien(),
					this.getMaNhanVien(), this.tinhLuong(), this.getChucDanh());

		}

	}

}
