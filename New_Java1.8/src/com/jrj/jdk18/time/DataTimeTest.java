package com.jrj.jdk18.time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class DataTimeTest {
	/**
	 * Duration用于计算两个“时间”间隔
	 * 
	 * 
	 * Period:用于计算日期之间的间隔的
	 * 
	 * Instant 这个是得到时间戳
	 * LocalDate只有日期没有时间
	 * LocalTime只有时间没有日期
	 */
	@Test
	public void test1(){
		
		Instant in = Instant.now();
		System.out.println(in);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant in1 = Instant.now();
		
		System.out.println(Duration.between(in, in1).toMillis());
		
		System.out.println("-----------");
		LocalDate now = LocalDate.now();//
		LocalDate wei=LocalDate.of(2030, 1, 1);
		Period pe = Period.between(now,wei);
		System.out.println("需要多长时间："+pe.getYears()+"年"+pe.getMonths()+"月"+pe.getDays()+"日");
		System.out.println(pe.getYears());
		System.out.println(pe.getMonths());
		System.out.println(now);
		System.out.println(wei);
	}
	
	@Test
	public void test2(){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dfm=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String format = now.format(dfm);
		System.out.println(format);

		String name="2018年08月13日 16:59:47";
		LocalDateTime parse = LocalDateTime.parse(name, dfm);
		System.out.println(parse);
		System.out.println(now);
	}
	@Test
	public void test3(){

		Instant now = Instant.now();
		//下面是带偏移量8小时
		OffsetDateTime atOffset = now.atOffset(ZoneOffset.ofHours(8));
		System.out.println(now);
		System.out.println(atOffset);
		//now.getNano()这个是转化为秒
		System.out.println(now.toEpochMilli());
		
		Instant milli = Instant.ofEpochMilli(10);
		System.out.println(milli);
	}
	@Test
	public void test4(){
		LocalDate now = LocalDate.now();//
		System.out.println(now);
	}
	
	@Test
	public void test5() throws Exception{

//
//		LocalDate start=LocalDate.now();
//		Thread.sleep(100);
//		LocalDate end=LocalDate.of(2018, 7, 30);
//		System.out.println(Period.between(start, end).getDays());
		LocalTime t1=LocalTime.now();
		LocalTime of = LocalTime.of(23, 0, 0);
		System.out.println(Duration.between(t1, of).getSeconds());
		
		LocalDateTime start = LocalDateTime.now();

		LocalDateTime of2 = LocalDateTime.of(2018, 7, 13, 23, 23,0);
		System.out.println(Duration.between(start, of2).getSeconds());

	}
	
	@Test
	public void test6(){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy年MM月dd HH-mm-ss");
		String format = now.format(date);
		System.out.println(format);
		System.out.println(now);
		LocalDateTime parse = LocalDateTime.parse(format, date);
		System.out.println(parse);
	}
	
	@Test
	public void test7(){
		LocalDateTime now = LocalDateTime.now();

		System.out.println(now);
		
		LocalDateTime month = now.withDayOfMonth(10);
		System.out.println(month);
		
		LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.println(with);
		
	}
	/**
	 * 获得所有的时区
	 */
	@Test
	public void test8(){
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
		
	}

}
