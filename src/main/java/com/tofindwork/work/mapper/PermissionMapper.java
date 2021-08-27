package com.tofindwork.work.mapper;

import com.tofindwork.work.entity.Permission;
import com.tofindwork.work.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {


    @Select("select p.permission_id as permissionId,p.name as name,p.url as url from role r " +
            "left join role_permission rp on r.role_id=rp.role_id " +
            "left join permission p on rp.permission_id=p.permission_id " +
            "where r.role_id=#{roleId} ")
    List<Permission> findPermissionByRole(@Param("roleId")int roleId);



}
