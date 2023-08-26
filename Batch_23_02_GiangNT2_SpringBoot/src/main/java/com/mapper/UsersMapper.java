package com.mapper;

import com.model.Users;
import com.model.UsersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    long countByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int deleteByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int insert(Users row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int insertSelective(Users row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    List<Users> selectByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    Users selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByExampleSelective(@Param("row") Users row, @Param("example") UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByExample(@Param("row") Users row, @Param("example") UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByPrimaryKeySelective(Users row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByPrimaryKey(Users row);
}