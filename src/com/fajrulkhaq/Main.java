package com.fajrulkhaq;

import com.fajrulkhaq.model.Mahasiswa;
import com.fajrulkhaq.service.MahasiswaService;
import com.fajrulkhaq.utils.InputHandler;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        MahasiswaService data = new MahasiswaService();
        File file = new File("mahasiswa.csv");
        MahasiswaService.checkAndCreateFile(file);

//        data.addData(new Mahasiswa("123", "Fajrul", "Teknik Informatika"));
//        data.addData(new Mahasiswa("321", "robin", "Ekonomi"));
//        System.out.println(data.readData());
//
//        data.updateData(new Mahasiswa("123", "Fajrulkhaq", "Computer Science"));
//        System.out.println(data.readData());
//
//        data.deleteData(new Mahasiswa("123", "Fajrulkhaq", "Computer Science"));
////        data.deleteDataById("321");
//        System.out.println(data.readData());

        while (true){
            System.out.println("========== Menu Aplikasi ==========");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Menampilkan Data Mahasiswa");
            System.out.println("3. Update Data Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("5. Exit");
            int choice = InputHandler.getInt("Pilih Menu : ");

            switch (choice){
                case 1 -> {
                    String nim = InputHandler.getString("Masukkan Nim : ");
                    String nama =InputHandler.getString("Masukkan Nama : ");
                    String jurusan =InputHandler.getString("Masukkan Jurusan : ");
                    data.addData(new Mahasiswa(nim,nama,jurusan));
                }
                case 2 -> System.out.println(data.readData());
                case 3 -> {
                    String nim = InputHandler.getString("Masukkan Nim yang akan diupdate : ");
                    String nama =InputHandler.getString("Masukkan Nama yang akan diupdate : ");
                    String jurusan =InputHandler.getString("Masukkan Jurusan yang akan diupdate : ");
                    data.updateData(new Mahasiswa(nim,nama,jurusan));
                }
                case 4 -> {
                    String nim = InputHandler.getString("Masukkan Nim yang ingin dihapus : ");
                    data.deleteDataById(nim);
                }
                case 5 -> {
                    System.out.println("Keluar dari aplikasi");
                    System.exit(0);
                }
            }
        }
    }
}