package com.dw.ngms.cis.uam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dw.ngms.cis.uam.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   @Query("SELECT u FROM User u WHERE u.userName = :userName")
   User findByLoginName(@Param("userName") String userName);

   @Query("SELECT u FROM User u WHERE u.email = :email")
   User findByEmail(@Param("email") String email);

   @Query("SELECT u FROM User u WHERE u.userTypeName = :userTypeName")
   List<User> findByUserTypeName(@Param("userTypeName") String userTypeName);

   @Query("SELECT u FROM User u WHERE u.isApproved = :approvalStatus")
   List<User> findByApprovalStatus(@Param("approvalStatus") String approvalStatus);
   
   @Query(value = "SELECT U.* FROM USERS U INNER JOIN EXTERNALUSERROLES EUR ON (EUR.USERCODE = U.USERCODE) "
	   		+ "WHERE U.USERTYPENAME = 'EXTERNAL' AND U.ISAPPROVED = ?1 AND EUR.USERPROVINCECODE = ?2", nativeQuery = true)
   List<User> findExternalUsersByApprovalStatusAndProvinceCode(String approvalStatus, String provincecode);
   
   @Query(value = "SELECT U.* FROM USERS U INNER JOIN EXTERNALUSERASSISTANTS EUA ON (EUA.USERID = U.USERID) "
	   		+ "WHERE U.USERTYPENAME = 'EXTERNAL' AND EUA.ISAPPROVED = ?1 AND EUR.SURVEYORUSERCODE = ?2", nativeQuery = true)
   List<User> findAssistantsForPendingApprovalStatusAndProvinceCode(String approvalStatus, String surveyorusercode);
  
   @Query(value = "SELECT U.* FROM USERS U INNER JOIN INTERNALUSERROLES IUR ON (IUR.USERCODE = u.USERCODE) "
   		+ "WHERE U.USERTYPENAME = 'INTERNAL' AND IUR.USERPROVINCECODE = ?1", nativeQuery = true)
   List<User> findInternalUsersByProvinceCode(String provincecode);
   
   @Query(value = "SELECT U.* FROM USERS U INNER JOIN EXTERNALUSERROLES EUR ON (EUR.USERCODE = u.USERCODE) "
	   		+ "WHERE U.USERTYPENAME = 'EXTERNAL' AND EUR.USERPROVINCECODE = :provincecode", nativeQuery = true)
   List<User> findExternalUsersByProvinceCode(@Param("provincecode") String provincecode);
   
   @Query("SELECT u FROM User u WHERE u.userCode = :usercode and u.userName = :username")
   User findByUserByNameAndCode(@Param("usercode") String usercode,@Param("username") String username);

   @Query("SELECT u FROM User u WHERE u.userCode = :usercode and u.userName = :username and u.userTypeName = :usertypename")
   User findByUserCodeUserNameAndTypeName(@Param("usercode") String usercode,@Param("username") String username, @Param("usertypename") String usertypename);

}
