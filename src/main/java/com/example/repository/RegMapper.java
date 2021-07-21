package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.pc.model.Reg;

@Mapper
public interface RegMapper {
	//登録
	public int insertOne(Reg reg);
    //取得
	public List<Reg> findMany(Reg reg);
    //取得(1件)
	public Reg findOne(String name);

	//更新(1件)
	public void updateOne(@Param("name")String name,
			@Param("os")String os,
			@Param("cpu")String cpu,
			@Param("ghz")double ghz,
			@Param("gpu")String gpu,
			@Param("ram")int ram,
			@Param("hddCapa")int hddCapa,
			@Param("byt")String byt,
			@Param("ssdCapa")int ssdCapa,
			@Param("byt2")String byt2,
			@Param("eth")String eth,
			@Param("strWifi")String sreWifi,
			@Param("resolution")String resolution,
			@Param("lcd")double lcd,
			@Param("manufacturers")String manufacturers,
			@Param("release")String release,
			@Param("description")String description);

	//削除
	public int deleteOne(@Param("name")String name);

}
