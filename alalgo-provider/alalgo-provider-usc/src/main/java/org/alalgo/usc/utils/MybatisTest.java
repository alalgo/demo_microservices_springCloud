package org.alalgo.usc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

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

/**
 * 编码执行sql，了解mybatis底层原理
 * @author security
 *
 */
public class MybatisTest {

	public static void main(String[] args) throws IOException {
		try(
			//SqlSession sqlSession = buildNoxml();
			SqlSession sqlSession = buildxml();
		){/*
			UserDO userDo = new UserDO();
			userDo.setUserId(567);
			userDo.setUsername("JACK");
			userDo.setPassword("343432");
			userDo.setPhoneNumber("12345676543");
			userDo.setEnable(true);
			userDo.setCreateTime(new Date());
			userDo.setUpdateTime(new Date());
			sqlSession.insert("org.alalgo.usc.model.UserMapper.insertUser",userDo);	
			*/
			sqlSession.selectList("org.alalgo.usc.model.UserMapper.getUserByName");
			//sqlSession.select
			sqlSession.commit();
		}
		MappedStatement a;
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
		c.stream().forEach(item->{System.out.println(item.getId());});
		return sqlFactory.openSession();
	}
}
