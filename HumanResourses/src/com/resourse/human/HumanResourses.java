package com.resourse.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HumanResourses {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Khởi tạo 2 bộ phận
		Department boPhan1 = new Department("bo phan 1", 1, 2);
		Department boPhan2 = new Department("bo phan 2", 2, 3);
		List<Department> dList = new ArrayList<>();
		dList.add(boPhan1);
		dList.add(boPhan2);
		int maNv = 1;
		int maQl = 1;
		// Khởi tạo nhân viên
		Employee nv1 = new Employee("0" + maNv, "Mai", 25, "20", 3, boPhan1, 28);
		Employee nv2 = new Employee("0" + ++maNv, "Lan", 28, "22", 5, boPhan2, 12);
		Manager ql1 = new Manager("00" + maQl, "Hung", 30, "5", 3, boPhan2, "Business Leader");
		Manager ql2 = new Manager("00" + ++maQl, "Hoa", 34, "30", 6, boPhan1, "Project Leader");
		Manager ql3 = new Manager("00" + ++maQl, "Tuan", 29, "23", 9, boPhan2, "Technical Leader");
		List<Staff> sfList = new ArrayList<>();
		sfList.add(nv1);
		sfList.add(nv2);
		sfList.add(ql1);
		sfList.add(ql2);
		sfList.add(ql3);
		int luaChon;
		do {
			hienMenu();
			System.out.print("chon chuc nang: ");
			int chucNang = Integer.parseInt(input.next());
			// Dùng switch - case để thực hiện chức năng tương ứng
			switch (chucNang) {
			case 1:

				System.out.println("------Danh sach nhan vien-----");
				for (Staff sf : sfList) {
					sf.displayInformation(chucNang);
				}
				break;
			case 2:
				System.out.println("------Cac bo phan trong cong ty-----");
				// Gọi hàm toString đã được override ở lớp Department để in ra thông tin bộ phận
				for (Department d : dList) {
					System.out.println(d.toString());
				}
				break;
			case 3:
				/*
				 * Kiểm tra nhân viên thuộc bộ phận 1 hay 2 In ra thông tin nhân viên theo từng
				 * bộ phận
				 */

				for (Staff sf : sfList) {
					String tenBP = sf.getBoPhan().getTenBoPhan();
					sf.displayInformation(chucNang);
				}
				break;
			case 4:
				// Thêm đầy đủ thông tin nhân viên và add vào ArrayList ban đầu
				System.out.print("ban muon them bao nhieu nhan vien? ");
				int soNhanVienThem = Integer.parseInt(input.next());
				String boPhan;
				String capBac;
				String maCuaQl;
				String maCuaNv;
				for (int i = 1; i <= soNhanVienThem; i++) {
					System.out.println("them nhan vien " + i);
					Staff nvThem = null;
					sfList.add(nvThem);
					System.out.print("bo phan (1 hoac 2)? ");
					boPhan = input.next();
					System.out.print("nhap ten: ");
					String ten = input.next();
					System.out.print("nhap tuoi: ");
					int tuoi = Integer.parseInt(input.next());
					System.out.print("nhap ngay vao lam: ");
					String ngayVaoLam = input.next();
					int soNgayNghi = 0;
					String chucVu = null;
					if (boPhan.equals("1")) {
						input.nextLine();
						System.out.print("quan ly hay nhan vien? ");
						capBac = input.nextLine();
						if (capBac.equalsIgnoreCase("quan ly")) {
							maCuaQl = "00" + ++maQl;
							System.out.print("chuc vu (1-Business Leader, 2-Project Leader, 3-Technical Leader)");
							int chucDanh = Integer.parseInt(input.next());
							switch (chucDanh) {
							case 1:
								chucVu = "Business Leader";
								break;
							case 2:
								chucVu = "Project Leader";
								break;
							case 3:
								chucVu = "Technical Leader";
							}
							nvThem = new Manager(maCuaQl, ten, tuoi, ngayVaoLam, soNgayNghi, boPhan1, chucVu);
						} else if (capBac.equalsIgnoreCase("nhan vien")) {
							// System.out.print("nhap so gio lam them: ");
							int soGioLamThem = 0;
							maCuaNv = "0" + ++maNv;
							nvThem = new Employee(maCuaNv, ten, tuoi, ngayVaoLam, soNgayNghi, boPhan1, soGioLamThem);
						}

					} else if (boPhan.equals("2")) {
						input.nextLine();
						System.out.print("quan ly hay nhan vien? ");
						capBac = input.nextLine();
						if (capBac.equalsIgnoreCase("quan ly")) {
							maCuaQl = "00" + ++maQl;
							System.out.print("chuc vu (1-Business Leader, 2-Project Leader, 3-Technical Leader)");
							int chucDanh = Integer.parseInt(input.next());
							switch (chucDanh) {
							case 1:
								chucVu = "Business Leader";
								break;
							case 2:
								chucVu = "Project Leader";
								break;
							case 3:
								chucVu = "Technical Leader";
							}
							nvThem = new Manager(maCuaQl, ten, tuoi, ngayVaoLam, soNgayNghi, boPhan2, chucVu);
						} else if (capBac.equalsIgnoreCase("nhan vien")) {
							// System.out.print("nhap so gio lam them: ");
							int soGioLamThem = 0;
							maCuaNv = "0" + ++maNv;
							nvThem = new Employee(maCuaNv, ten, tuoi, ngayVaoLam, soNgayNghi, boPhan2, soGioLamThem);
						}
						sfList.add(nvThem);
					}
					System.out.print("Nhan vien duoc them vao cong ty: ");
					nvThem.displayInformation(3);
				}
				break;
			case 5:
				// Nhập mã hoặc tên để so sánh với dữ liệu đã có
				System.out.println("tim kiem theo ten hoac ma(1-ma, 2-ten)");
				System.out.print("nhap yeu cau (1 hoac 2): ");
				int yeuCau = input.nextInt();
				input.nextLine();
				if (yeuCau == 1) {
					System.out.print("nhap ma: ");
					String maTimKiem = input.nextLine();
					Staff nvTimKiem = null;
					for (Staff sf : sfList) {
						if (sf.getMaNhanVien().equalsIgnoreCase(maTimKiem)) {
							// System.out.println("tim thay");
							nvTimKiem = sf;
							break;
						}
					}
					if (nvTimKiem != null) {

						nvTimKiem.displayInformation(1);

					} else {
						System.out.println("k tim thay");
					}
				} else if (yeuCau == 2) {
					System.out.print("nhap ten: ");
					String tenTimKiem = input.next();
					Staff nvTimKiem = null;
					for (Staff sf : sfList) {
						if (sf.getTenNhanVien().equalsIgnoreCase(tenTimKiem)) {
							nvTimKiem = sf;
							break;
						}
					}
					if (nvTimKiem != null) {
						nvTimKiem.displayInformation(1);
					} else {
						System.out.println("k tim thay");
					}
				}
				break;
			case 6:
				System.out.println("---Bảng lương---");
				for (Staff sf : sfList) {
					sf.displayInformation(chucNang);
				}
				break;
			case 7:
				// List đã được sắp xếp theo thứ tự của lương
				System.out.println("---Lương nhân viên theo thứ tự tăng dần---");
				Collections.sort(sfList);
				for (Staff sf : sfList) {
					sf.displayInformation(6);
				}
				break;
			case 8:
				System.out.println("---Lương nhân viên theo thứ tự giảm dần---");
				Collections.sort(sfList, Collections.reverseOrder());
				for (Staff sf : sfList) {
					sf.displayInformation(6);
				}
			}
			System.out.print("ban muon chon tiep khong? (1-co 2-khong)");
			luaChon = Integer.parseInt(input.next());
			if (luaChon == 2) {
				System.out.print("ket thuc");
			}
		} while (luaChon == 1);
	}

	public static void hienMenu() {
		System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
		System.out.println("2. Hiển thị các bộ phận trong công ty");
		System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
		System.out.println("4. Thêm nhân viên mới vào công ty");
		System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
		System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
		System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
		System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
	}

}
