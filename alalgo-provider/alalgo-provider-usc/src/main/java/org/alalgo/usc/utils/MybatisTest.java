package org.alalgo.usc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.alalgo.usc.dos.UserDO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 编码执行sql，了解mybatis底层原理
 * @author security
 *
 */
@Slf4j
public class MybatisTest {

	public static void main(String[] args) throws IOException {
		//batchInsert();
		//insertOrUpdate();
		insertOrUpdates();
	}
	private static void  insertOrUpdate() throws IOException {
		SqlSession sqlSession = buildxml();
		try{
				UserDO userDo = new UserDO();
				userDo.setUserId(6314);
				userDo.setUsername("key");
				userDo.setPassword("343432");
				userDo.setPhoneNumber("12345676543");
				userDo.setEnable(true);
				userDo.setCreateTime(new Date());
				userDo.setUpdateTime(new Date());

			sqlSession.insert("org.alalgo.usc.model.UserMapper.insertOrUpdateUser",userDo);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			log.error("", e);
		}finally {
			sqlSession.close();
		}		
	}
	private static void batchInsert() throws IOException {
		SqlSession sqlSession = buildxml();
		try{
			List<UserDO> list = new ArrayList();
			for(int i=0 ; i<10 ;i++) {
				UserDO userDo = new UserDO();
				//userDo.setUserId(i);
				userDo.setUsername("JACK");
				userDo.setPassword("343432");
				userDo.setPhoneNumber("12345676543");
				userDo.setEnable(true);
				userDo.setCreateTime(new Date());
				userDo.setUpdateTime(new Date());
				list.add(userDo);
			}
			sqlSession.insert("org.alalgo.usc.model.UserMapper.insertUsers",list);
			//sqlSession.selectList("org.alalgo.usc.model.UserMapper.getUserByName");
			sqlSession.commit();
			list.stream().forEach((item)->{System.out.println(item.getUserId());});
		}catch(Exception e) {
			sqlSession.rollback();
			log.error("", e);
		}finally {
			sqlSession.close();
		}		
	}
	private static void insertOrUpdates() throws IOException {
		SqlSession sqlSession = buildxml();
		try{
			List<UserDO> list = new ArrayList();
			for(int i=6314 ; i<6322 ;i++) {
				UserDO userDo = new UserDO();
				userDo.setUserId(i);
				userDo.setUsername("xu");
				userDo.setPassword("343432");
				userDo.setPhoneNumber("12345676543");
				userDo.setEnable(true);
				userDo.setCreateTime(new Date());
				userDo.setUpdateTime(new Date());
				list.add(userDo);
			}
			sqlSession.insert("org.alalgo.usc.model.UserMapper.insertOrUpdateUsers",list);
			sqlSession.commit();
			list.stream().forEach((item)->{System.out.println(item.getUserId());});
		}catch(Exception e) {
			sqlSession.rollback();
			log.error("", e);
		}finally {
			sqlSession.close();
		}		
	}	
	/**
	 * 不使用xml配置文件，完全代码配置环境，构建SqlSessionFactory
	 * @return 
	 * @date: 2020年12月30日
	 * @author: security
	 */
	private static SqlSession buildNoxml() {
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword ("root");
		dataSource.setUrl("jdbc:mysql://192.168.6.201:3306/cloudIntegration");
		dataSource.setDefaultAutoCommit(false);	
		Environment environment = new Environment("develop"
				, new JdbcTransactionFactory(), dataSource);
		
		Configuration configuration = new Configuration();
		configuration.setEnvironment(environment);
		configuration.addMapper(UserDO.class);		
		configuration.getTypeAliasRegistry().registerAlias("Integer", java.lang.Integer.class);
		configuration.getTypeAliasRegistry().registerAlias("String", java.lang.String.class);
		
		SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(configuration);	
		System.out.println(sqlFactory.getConfiguration().getMappedStatements());
		TransactionFactory a;
		return sqlFactory.openSession();
	}
	/**
	 * 使用xml配置文件，通过读取xml构建SqlSessionFactory
	 * @return
	 * @throws IOException 
	 * @date: 2020年12月30日
	 * @author: security
	 */
	private static SqlSession buildxml() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(inputStream);
		Collection<MappedStatement> c = sqlFactory.getConfiguration().getMappedStatements();
		return sqlFactory.openSession();
	}
}
