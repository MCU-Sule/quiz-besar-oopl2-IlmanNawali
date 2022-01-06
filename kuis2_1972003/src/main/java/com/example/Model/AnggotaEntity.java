/**
 * 1972003 Ilman Nawali
 */
package com.example.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "anggota", schema = "kuis2pbo2", catalog = "")
public class AnggotaEntity {
    private Integer id;
    private String nama;
    private String alamat;
    private String notelpon;
    private Date tglLahir;
    private Date tglMasuk;
    private Collection<PeminjamanEntity> peminjamenById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama", nullable = true, length = 50)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return nama;
    }

    @Basic
    @Column(name = "alamat", nullable = true, length = 50)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "notelpon", nullable = true, length = 14)
    public String getNotelpon() {
        return notelpon;
    }

    public void setNotelpon(String notelpon) {
        this.notelpon = notelpon;
    }

    @Basic
    @Column(name = "tglLahir", nullable = true)
    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    @Basic
    @Column(name = "tglMasuk", nullable = true)
    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnggotaEntity that = (AnggotaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nama, that.nama) && Objects.equals(alamat, that.alamat) && Objects.equals(notelpon, that.notelpon) && Objects.equals(tglLahir, that.tglLahir) && Objects.equals(tglMasuk, that.tglMasuk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, alamat, notelpon, tglLahir, tglMasuk);
    }

    @OneToMany(mappedBy = "anggotaByAnggotaId")
    public Collection<PeminjamanEntity> getPeminjamenById() {
        return peminjamenById;
    }

    public void setPeminjamenById(Collection<PeminjamanEntity> peminjamenById) {
        this.peminjamenById = peminjamenById;
    }
}
