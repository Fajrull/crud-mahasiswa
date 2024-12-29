package com.fajrulkhaq.model;

import java.util.Objects;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;

    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public Mahasiswa(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mahasiswa mahasiswa = (Mahasiswa) o;
        return Objects.equals(nim, mahasiswa.nim) && Objects.equals(nama, mahasiswa.nama) && Objects.equals(jurusan, mahasiswa.jurusan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nim, nama, jurusan);
    }
}
