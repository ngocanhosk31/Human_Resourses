package com.resourse.human;

public class Employee extends Staff implements ICalculator, Comparable<Staff> {
	// override lại hàm compareTo của interface Comparable để so sánh lương giữa các
	// phần tử
	@Override
	public int compareTo(Staff o) {
		// TODO Auto-generated method stub
		return (int) (this.tinhLuong() - ((ICalculator) o).tinhLuong());
	}

	private int soGioLamThem;

	// Triển khai hàm tính lương kế thừa từ lớp cha Staff
	public double tinhLuong() {

		return getHeSoLuong() * 3000000 + soGioLamThem * 200000;
	}

	public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, String ngayVaoLam, int soNgayNghi,
			Department boPhan, int soGioLamThem) {
		super(maNhanVien, tenNhanVien, tuoiNhanVien, ngayVaoLam, soNgayNghi, boPhan);
		this.soGioLamThem = soGioLamThem;
	}

	public int getSoGioLamThem() {
		return soGioLamThem;
	}

	public void setSoGioLamThem(int soGioLamThem) {
		this.soGioLamThem = soGioLamThem;
	}
	// oberride hàm displayInformation từ class cha Staff, tham số là chức năng
	// người dùng nhập

	@Override
	void displayInformation(int input) {
		// TODO Auto-generated method stub
		switch (input) {
		case 1:
			System.out.printf("ma: %-10s ten: %-10s tuoi: %-10d ngay vao: %-10s so ngay nghi: %-10d\n",
					this.getMaNhanVien(), this.getTenNhanVien(), this.getTuoiNhanVien(), this.getNgayVaoLam(),
					this.getSoNgayNghi());
			break;

		case 3:
			System.out.printf("nhan vien: %-10s bo phan: %-10s\n", this.getTenNhanVien(), getBoPhan().getTenBoPhan());
			break;

		case 6:
			System.out.printf("nhan vien: %-10s ma: %-10s luong: %.0f\n", this.getTenNhanVien(), this.getMaNhanVien(),
					this.tinhLuong());

		}
	}

}
