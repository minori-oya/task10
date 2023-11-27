package com.task10.crudapi_login.mapper;

import com.task10.crudapi_login.entity.Client;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ClientMapper {
    @Select("SELECT * FROM clients ")
    List<Client> findAll();

    @Select("SELECT * FROM clients WHERE id = #{id}")
    Optional<Client> findById(int id);

    @Insert("INSERT INTO clients(name, age, phoneNumber) VALUES (#{name}, #{age}, #{phoneNumber})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Client client);

    @Update("UPDATE clients SET name = #{name}, age = #{age}, phoneNumber = #{phoneNumber} WHERE id = #{id}")
    void update(Client client);

    @Delete("DELETE FROM clients WHERE id = #{id}")
    void delete(int id);

    //nameが#{name}で始まるデータを削除
    @Delete("DELETE FROM clients WHERE name like = #{name}")
    void deleteName(String name);

    Optional<Object> findByName(String name);
}
