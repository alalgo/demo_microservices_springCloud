package org.alalgo.usc.model;

import java.util.List;

import org.alalgo.usc.dos.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MenuMapper {
	@Select("select * from menu;")
	public List<Menu> findAllMenu();
}
