package test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PrintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDateTime date = LocalDateTime.now();//.truncatedTo(ChronoUnit.SECONDS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String formattedDate = date.format(formatter);
		System.out.println("La Fecha de ahora es "+ formattedDate);
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println("La fecha .. a ver:" + now);
	}

}
