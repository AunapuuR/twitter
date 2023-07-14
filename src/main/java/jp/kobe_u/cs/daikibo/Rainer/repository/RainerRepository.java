package jp.kobe_u.cs.daikibo.Rainer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.Rainer.entity.Rainer;

@Repository
public interface RainerRepository extends CrudRepository<Rainer, Long> {
    // add any custom query methods if required
}