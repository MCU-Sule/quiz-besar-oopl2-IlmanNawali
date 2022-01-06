/**
 * 1972003 Ilman Nawali
 */
package com.example.DAO;

import com.example.Model.AnggotaEntity;
import com.example.Model.PeminjamanEntity;
import com.example.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PeminjamanDAO implements daoInterface<PeminjamanEntity>{
    @Override
    public int addData(PeminjamanEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(PeminjamanEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.delete(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int updateData(PeminjamanEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.update(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public List<PeminjamanEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(PeminjamanEntity.class);

        query.from(PeminjamanEntity.class);

        List<PeminjamanEntity> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
