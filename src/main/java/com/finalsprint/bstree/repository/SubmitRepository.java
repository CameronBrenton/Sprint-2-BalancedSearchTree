// This is the SubmitRepository class

package com.finalsprint.bstree.repository;

import com.finalsprint.bstree.model.Submit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class SubmitRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // Insert into database
    @Transactional
    public void insertWithQuery(Submit submit) {
        entityManager.createNativeQuery("INSERT INTO submit (number1, " +
                        "number2, number3, number4, number5, number6, number7, number8, number9, number10) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, submit.getNumber1())
                .setParameter(2, submit.getNumber2())
                .setParameter(3, submit.getNumber3())
                .setParameter(4, submit.getNumber4())
                .setParameter(5, submit.getNumber5())
                .setParameter(6, submit.getNumber6())
                .setParameter(7, submit.getNumber7())
                .setParameter(8, submit.getNumber8())
                .setParameter(9, submit.getNumber9())
                .setParameter(10, submit.getNumber10())
                .executeUpdate();
    }

    @Transactional
    public void insertWithEntityManager(Submit submit) {
        this.entityManager.persist(submit);
    }
}
