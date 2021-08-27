package com.tofindwork.work.mapper;

import com.tofindwork.work.entity.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleMapper {



    @Select("select r.role_id , r.role_name , r.marks  from user u " +
            "left join user_role ur on u.user_id=ur.user_id " +
            "left join role r on ur.role_id=r.role_id " +
            "where u.user_id=#{userId}")
    @Results(
            value = {
                    @Result(id = true,property = "roleId",column = "role_id"),
                    @Result(property = "roleName",column = "role_name"),
                    @Result(property = "marks",column = "marks"),
                    @Result(property = "permissions",column = "role_id",
                            many =@Many(select = "com.tofindwork.work.mapper.PermissionMapper.findPermissionByRole",fetchType = FetchType.DEFAULT))
            }
    )
    List<Role> findRoleListByUserId(@Param("userId")int userId);


//    @Insert("insert into user_role(user_id,role_id)values(#{userId},3)")
    void addRoleByUserId(int userId);

    void delUserRole(int userId, List<String> roleList);

    void addUserRoleBatch(int userId, List<String> roleList);
}
