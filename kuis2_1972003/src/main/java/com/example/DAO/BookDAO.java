/**
 * 1972003 Ilman Nawali
 */
package com.example.DAO;

import com.example.Model.BukuEntity;
import com.example.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookDAO implements daoInterface<BukuEntity>{
    @Override
    public int addData(BukuEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(BukuEntity data) {
        return 0;
    }

    @Override
    public int updateData(BukuEntity data) {
        return 0;
    }

    @Override
    public List<BukuEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(BukuEntity.class);

        query.from(BukuEntity.class);

        List<BukuEntity> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
