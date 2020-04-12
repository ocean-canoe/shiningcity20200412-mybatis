package com.shiningcity.company.mapper;

import com.shiningcity.company.pojo.BaseCompany;
import com.shiningcity.company.pojo.BaseCompanyExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseCompanyMapper {
	
    long countByExample(BaseCompanyExample example);

    int deleteByExample(BaseCompanyExample example);

    int deleteByPrimaryKey(Integer pkid);
    
    int deleteByPrimaryKeyProcedure(Integer pkid);

    int insert(BaseCompany record);
    
    int insertMore(@Param("list") List<BaseCompany> comlist);
    
    int insertProcedure(Map<String, Object> map);

    int insertSelective(BaseCompany record);

    List<BaseCompany> selectByExample(BaseCompanyExample example);

    BaseCompany selectByPrimaryKey(Integer pkid);
    
    BaseCompany selectByIdProcedure(Integer pkid);

    int updateByExampleSelective(@Param("record") BaseCompany record, @Param("example") BaseCompanyExample example);

    int updateByExample(@Param("record") BaseCompany record, @Param("example") BaseCompanyExample example);

    int updateByPrimaryKeySelective(BaseCompany record);

    int updateByPrimaryKey(BaseCompany record);
    
    List<BaseCompany> selectComDetailListByMap(Map<String, Object> map);
    
    List<Map<String, Object>> selectComManMapListByMap(Map<String, Object> map);
    
    void selectAddIntProcedure(Map<String, Object> map);
    
    void selectAddDecimalProcedure(Map<String, Object> map);
    
    //mapper中方法可以重载。但在.xml中不能指定paramType
    //SysUser selectByCondition(@Param("id")Long id,@Param("userName")String userName,@Param("userPassword")String userPassword);
    //SysUser selectByCondition(Map params);
    //<select id="selectByCondition" resultMap="sysUser" flushCache="true">
	//    SELECT * FROM sys_user WHERE id = #{id} AND user_name = #{userName} AND user_password = #{userPassword};
	//</select>
    
    /*
     * 批量添加
     * @Param中的参数必须和mapper.xml中foreach的collection对应，若果不写@Param注解并且只传入一个list作为参数，则collection默认填list
     * int insertBatchRoleUser(@Param("lists") List<RoleUser> lists);
     * 
  <insert id="insertBatchRoleUser">
    INSERT INTO MS_USER_ROLE(ID, ROLEID, USERID,
    STATUS, CREATETIME, UPDATETIME,
    DELETETIME, CREATERID, UPDATERID,
    DELETERID)
    VALUES
    <foreach collection="lists" item="user" separator=",">	<!--separator：分隔符-->
      (
         #{user.id,jdbcType=VARCHAR}, #{user.roleid,jdbcType=VARCHAR}, #{user.userid,jdbcType=VARCHAR},
         #{user.status,jdbcType=INTEGER}, #{user.createtime,jdbcType=TIMESTAMP}, #{user.updatetime,jdbcType=TIMESTAMP},
         #{user.deletetime,jdbcType=TIMESTAMP}, #{user.createrid,jdbcType=VARCHAR}, #{user.updaterid,jdbcType=VARCHAR},
         #{user.deleterid,jdbcType=VARCHAR}
      )
    </foreach>
  </insert>
     *
     */
    
    /*
     * 批量删除
     * int deleteBatchRoleUser(@Param("roleId") String roleId, @Param("list") List<String> userIds);
     * 
  <!-- 批量删除 -->
  <delete id="deleteBatchRoleUser">
      DELETE FROM MS_USER_ROLE WHERE ROLEID = #{roleId,jdbcType=VARCHAR} AND USERID IN
      <foreach collection="list" item="id" separator="," open="(" close=")">	<!--separator：分隔符。open；close-->
        #{id,jdbcType=VARCHAR}
      </foreach>
  </delete>
     * 
     */
    
}