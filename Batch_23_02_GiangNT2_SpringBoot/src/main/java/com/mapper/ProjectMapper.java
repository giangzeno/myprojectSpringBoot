package com.mapper;

import com.model.Project;
import com.model.ProjectExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    long countByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int deleteByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int deleteByPrimaryKey(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int insert(Project row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int insertSelective(Project row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    List<Project> selectByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    Project selectByPrimaryKey(Integer projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByExampleSelective(@Param("row") Project row, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByExample(@Param("row") Project row, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByPrimaryKeySelective(Project row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROJECT
     *
     * @mbg.generated Wed Jun 14 15:59:59 ICT 2023
     */
    int updateByPrimaryKey(Project row);
    
    List<Project> selectByRequiment(@Param("projectId") Integer projectId, @Param("projectName") String projectName,
			@Param("difficulty") String difficulty, @Param("deptId") Integer deptId, @Param("offset") Integer offset);

	Long coutSelect(@Param("projectId") Integer projectId, @Param("projectName") String projectName,
			@Param("difficulty") String difficulty, @Param("deptId") Integer deptId);

	Long selectByprojectNM(@Param("projectName") String projectName);

	Long validateExitsName(@Param("projectName") String projectName, @Param("projectID") Integer projectID);

	List<String> selectAllProjectName();

	List<Integer> selectAllProjectID();
}