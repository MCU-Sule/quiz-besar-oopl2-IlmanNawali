/**
 * 1972003 Ilman Nawali
 */
package com.example.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "peminjaman", schema = "kuis2pbo2", catalog = "")
public class PeminjamanEntity {
    private Integer id;
    private Date tanggalPinjam;
    private Date tanggalPengembalian;
    private BukuEntity bukuByBukuId;
    private AnggotaEntity anggotaByAnggotaId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tanggalPinjam", nullable = true)
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    @Basic
    @Column(name = "tanggalPengembalian", nullable = true)
    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeminjamanEntity that = (PeminjamanEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(tanggalPinjam, that.tanggalPinjam) && Objects.equals(tanggalPengembalian, that.tanggalPengembalian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tanggalPinjam, tanggalPengembalian);
    }

    @ManyToOne
    @JoinColumn(name = "Buku_id", referencedColumnName = "id", nullable = false)
    public BukuEntity getBukuByBukuId() {
        return bukuByBukuId;
    }

    public void setBukuByBukuId(BukuEntity bukuByBukuId) {
        this.bukuByBukuId = bukuByBukuId;
    }

    @ManyToOne
    @JoinColumn(name = "Anggota_id", referencedColumnName = "id", nullable = false)
    public AnggotaEntity getAnggotaByAnggotaId() {
        return anggotaByAnggotaId;
    }

    public void setAnggotaByAnggotaId(AnggotaEntity anggotaByAnggotaId) {
        this.anggotaByAnggotaId = anggotaByAnggotaId;
    }
}
