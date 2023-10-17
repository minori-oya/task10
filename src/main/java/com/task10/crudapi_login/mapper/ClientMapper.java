package com.task10.crudapi_login.mapper;

import com.task10.crudapi_login.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;


@Mapper
public interface ClientMapper {
    @Select("SELECT * FROM clients ")
    List<Client> findAll();

    @Select("SELECT * FROM clients WHERE id = #{id}")
    Optional<Client> findById(int id);
}
