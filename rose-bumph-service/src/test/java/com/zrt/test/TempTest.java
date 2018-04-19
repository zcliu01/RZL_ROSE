package com.zrt.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.stream.FileImageInputStream;

import org.junit.Test;

public class TempTest {

	@Test
	public void test() {
		BufferedOutputStream temp = null ;
		try {
			byte[] data = null;
		    FileImageInputStream input = null;
		      input = new FileImageInputStream(new File("D:/a.JPG"));
		      ByteArrayOutputStream output = new ByteArrayOutputStream();
		      byte[] buf = new byte[1024];
		      int numBytesRead = 0;
		      while ((numBytesRead = input.read(buf)) != -1) {
		      output.write(buf, 0, numBytesRead);
		      }
		      data = output.toByteArray();
		      output.close();
		      input.close();
		      temp = new BufferedOutputStream(new FileOutputStream("D:/aaa.JPG"));
		      temp.write(data);
		      System.out.println("aaaaaaaaaaaaaaaa");
		    temp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test1() {

		String aString =  "http://172.30.142.166:80/group1/M00/00/17/rB6OploWZoGAQZbRAAA7O6EfFmQ983.jpg";
		System.out.println(aString.length());
		
	}
	
	
	@Test
	public void test2() {
		
		String aString =  "李当心——身在佛门也有情，无禅可参的僧人。佛门中可评得上前三甲的人物，菩萨低眉，金刚怒目，说的是佛门的慈悲与愤怒，但即使愤怒，也不过是在硬度堪比金刚石的地面踩出了一百零八罗汉印，为师父报仇场面确实恢弘，扯过黄河淹了道德宗，但到底未曾伤及无辜。但是整本书中，我认为最出彩的倒不是李当心像唐僧那样的西天取经回归后的盛名，不是他作为那个白衣圣僧的一切。他的出彩在于他是一个娶了媳妇儿的佛门中人，是他媳妇儿的丈夫，是东西小丫头的父亲，是吴南北的师父，是龙树僧人的徒弟，是他作为李当心的生活。小时候我一直在想，出了家就不能成亲，但是如果真的在出家后，莫名其妙的动了情，爱上了一个人，难道从此就犯了戒，修不得佛，参不来禅？所以我不明白济公李修元为什么出家，不明白天龙八部里面虚竹的爹，那位方丈明明心中有情却不敢承认，之后一生牵挂，修得又是什么善果？明明佛门是清净地，但真正超然物外又是不可能的，不理俗事？本就都是俗人又怎么做的到，不过是看清楚轻重，不会舍本逐末的修行。像之前看的空间有同学转的佛学，什么劝阻人三次就够，略感荒谬。就看如何理解了，佛本慈悲，如果真心渡人，何谈三次，三千次能换回一个浪子回头也是功德，但你劝三千次，只是徒增他人烦恼，所以佛家又说，佛渡有缘人，所以能传后世的学说，大概都有其思辨，最是自圆其说。不过佛家水太深，我不了解而心存太多困惑，也不求甚解，到底还是喜欢李当心，修佛之人为成佛而修佛就是偏执，修佛之人未成佛之前就还是人，所以要能包容人情。里面有许多他和他女儿，他徒弟的互动情节，大多平淡中显真情故而妙趣横生，比如东西不给他看徐凤年送的手串，于是他便在徐凤年名下刻上一刀，天下的父亲对于自己女儿喜欢的男的总归有几分不顺眼，此处特别有《我的三个假想敌》的异曲同工之妙。对于他媳妇儿，描写不多，有意把李当心刻画成一个惧内的丈夫，但如此神通怎会真正惧内，不过是愿意宠之任之罢了。细节印象深刻的有两处，第一处是说李当心当年西行回来千万人中就见到她一人，于是执手一生，情不知何起，所谓缘分本来就不是个可以用逻辑区分的东西。第二处，是他去藏经阁抄书，半天不见人，他媳妇儿怒气冲冲出门吼人，但真正看到他没出什么事的那一刻，真真是柔情似水，所以那些剽悍，不过你演我看，你我都懂，于是就成了周瑜打黄盖，情趣不足为外人道也。";
		System.out.println(aString.getBytes().length);
		System.out.println(aString.substring(0, aString.indexOf("，")));
		
	}
	
	
	@Test
	public void test3() {
	}

}
