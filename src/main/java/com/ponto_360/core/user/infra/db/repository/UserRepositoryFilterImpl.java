package com.ponto_360.core.user.infra.db.repository;

import com.ponto_360.core.user.infra.db.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryFilterImpl implements UserRepositoryFilter {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAllFilter(String name, String cpf) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(name)) {
            Expression<String> nameLower = cb.lower(user.get("fullName"));
            String nameSearch = "%" + name.toLowerCase() + "%";

            predicates.add(cb.like(nameLower, nameSearch));
        }

        if (StringUtils.hasText(cpf)) {
            Expression<String> cpfLower = cb.lower(user.get("cpf"));
            String cpfSearch = "%" + cpf.toLowerCase() + "%";

            predicates.add(cb.like(cpfLower, cpfSearch));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
