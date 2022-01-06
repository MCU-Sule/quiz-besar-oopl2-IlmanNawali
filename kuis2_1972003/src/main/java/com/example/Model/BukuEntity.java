/**
 * 1972003 Ilman Nawali
 */
package com.example.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "buku", schema = "kuis2pbo2", catalog = "")
public class BukuEntity {
    private Integer id;
    private String judul;
    private String penerbit;
    private String pengarang;
    private String tahunTerbit;
    private String jenisBuku;
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
    @Column(name = "judul", nullable = true, length = 50)
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Override
    public String toString() {
        return judul;
    }

    @Basic
    @Column(name = "penerbit", nullable = true, length = 50)
    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    @Basic
    @Column(name = "pengarang", nullable = true, length = 50)
    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    @Basic
    @Column(name = "tahunTerbit", nullable = true, length = 4)
    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    @Basic
    @Column(name = "jenisBuku", nullable = true, length = 50)
    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BukuEntity that = (BukuEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(judul, that.judul) && Objects.equals(penerbit, that.penerbit) && Objects.equals(pengarang, that.pengarang) && Objects.equals(tahunTerbit, that.tahunTerbit) && Objects.equals(jenisBuku, that.jenisBuku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, judul, penerbit, pengarang, tahunTerbit, jenisBuku);
    }

    @OneToMany(mappedBy = "bukuByBukuId")
    public Collection<PeminjamanEntity> getPeminjamenById() {
        return peminjamenById;
    }

    public void setPeminjamenById(Collection<PeminjamanEntity> peminjamenById) {
        this.peminjamenById = peminjamenById;
    }
}
