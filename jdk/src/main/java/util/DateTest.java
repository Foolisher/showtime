package util;

import lombok.Data;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created by wanggen/付笑 on 2016-04-16.
 */
@Data
public class DateTest {

	@Test
	public void test(){

		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

	}

}
