package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.IconPais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IconPaisRepository extends JpaRepository<IconPais, Long> {

    @Query(value = "INSERT INTO iconPais (iconId, paisId) values(:iconId,:paisId)", nativeQuery = true)
    public Long insertRelation(@Param("iconId") Long iconId, @Param("paisId") Long paisId);

}
