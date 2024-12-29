package com.fajrulkhaq.service;

import com.fajrulkhaq.model.Mahasiswa;
import com.fajrulkhaq.utils.InvalidDataNotFound;
import com.fajrulkhaq.utils.InvalidUnique;

import java.io.*;
import java.util.ArrayList;

public class MahasiswaService {
    ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    private static File file = new File("mahasiswa.csv");

    public static void checkAndCreateFile(File file){
        if (!checkFileExist(file)){
            createFile(file);
        } else {
            System.out.println("File sudah ada");
        }
    }

    public static Boolean checkFileExist(File file){
        return file.exists();
    }

    public static void createFile(File file){
        try {
            if(file.createNewFile()){
                System.out.println("File berhasil dibuat");
            } else {
                System.out.println("File gagal dibuat");
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            throw new IllegalStateException(e);
        }
    }


    private static void writeFile(ArrayList<Mahasiswa> dataMahasiswa){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(file)));
            for (Mahasiswa mahasiswa : dataMahasiswa){
                bufferedWriter.write(mahasiswa.getNim() + "," + mahasiswa.getNama()+ "," +mahasiswa.getJurusan() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ReadFile(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            while (line != null){
                String[] data = line.split(",");
                Mahasiswa mahasiswa = new Mahasiswa(data[0], data[1], data[2]);
                dataMahasiswa.add(mahasiswa);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void addData(Mahasiswa mahasiswa){
        try {
            validasiUniq(mahasiswa.getNim());
            Mahasiswa data = new Mahasiswa(mahasiswa.getNim(), mahasiswa.getNama(), mahasiswa.getJurusan());
            dataMahasiswa.add(data);
            writeFile(dataMahasiswa);
            System.out.println("Data berhasil ditambahkan");
        }catch (InvalidUnique e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Mahasiswa> readData(){
        if (dataMahasiswa.isEmpty()){
            ReadFile();
        }
        return dataMahasiswa;
    }

    public void updateData(Mahasiswa mahasiswa){
        try {
            validateDataNotFound(mahasiswa.getNim());
            for (Mahasiswa data : dataMahasiswa){
                if(data.getNim().equals(mahasiswa.getNim())){
                    data.setNama(mahasiswa.getNama());
                    data.setJurusan(mahasiswa.getJurusan());
                    System.out.println("Data berhasil di update");
                }
            }
            writeFile(dataMahasiswa);
        } catch (InvalidDataNotFound e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(Mahasiswa mahasiswa){
        dataMahasiswa.remove(mahasiswa);
    }

    public void deleteDataById(String nim){
        try {
            validateDataNotFound(nim);
            dataMahasiswa.removeIf(data -> data.getNim().equals(nim));
            writeFile(dataMahasiswa);
            System.out.println("Data berhasil dihapus");
        } catch (InvalidDataNotFound e){
            System.out.println(e.getMessage());
        }
    }

        public void validateDataNotFound(String nim){
           for (Mahasiswa mahasiswa : dataMahasiswa){
               if(mahasiswa.getNim().equals(nim)){
                   return;
               }
           }
           throw new InvalidDataNotFound("Data tidak ditemukan");
        }

        public void validasiUniq(String nim){
            for (Mahasiswa mahasiswa : dataMahasiswa){
                if(mahasiswa.getNim().equals(nim)){
                    throw new InvalidUnique("Nim sudah ada");
                }
            }
    }
}
