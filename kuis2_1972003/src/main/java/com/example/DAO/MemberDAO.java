/**
 * 1972003 Ilman Nawali
 */
package com.example.DAO;

import com.example.Model.AnggotaEntity;
import com.example.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class MemberDAO implements daoInterface<AnggotaEntity>{
    @Override
    public int addData(AnggotaEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(AnggotaEntity data) {
        return 0;
    }

    @Override
    public int updateData(AnggotaEntity data) {
        return 0;
    }

    @Override
    public List<AnggotaEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(AnggotaEntity.class);

        query.from(AnggotaEntity.class);

        List<AnggotaEntity> clist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(clist);
    }
}
