package hu.training.servlet;

import java.util.ArrayList;
import java.util.Collection;

public class DbMock {
	private static Collection<Data> db;
	static {

		db = new ArrayList<>();
		db.add(new Data(1, "Shoshana Rankins", "20", "Auto Mechanic"));
		db.add(new Data(2, "Nichole Broman", "30", "Paralegal"));
		db.add(new Data(2, "Beth Hyppolite", "18", "Drafter"));
		db.add(new Data(3, "Melani Canup", "45l", "Preschool Teacher"));
		db.add(new Data(4, "Neoma Naughton", "52", "Physician"));
		db.add(new Data(5, "Lesia Jenning", "36", "Mason"));
		db.add(new Data(6, "Fabian Lareau", "28", "Respiratory Therapist"));
		db.add(new Data(7, "Teresa Ellingsworth", "19", "Receptionist"));
		db.add(new Data(8, "Lillian Esquer", "21", "Clinical Laboratory Technician"));
		db.add(new Data(9, "Gwenn Clewis", "29", "Bookkeeping clerk"));
		db.add(new Data(10, "Jerrold Harger", "36", "Computer Support Specialist"));
		db.add(new Data(11, "Justa Simpkins", "35", "Statistician"));
		db.add(new Data(12, "Onie Blauvelt", "30", "Interpreter & Translator"));
		db.add(new Data(13, "Constance Delawder", "26", "Patrol Officer"));
		db.add(new Data(14, "Janetta Rasmus", "22", "Musician"));
		db.add(new Data(15, "Iola Then", "38", "Janitor"));
		db.add(new Data(16,	"Marnie Sancho" ,"25",  "Accountant"));
		db.add(new Data(17,	"Sid Haman","47",  "Insurance Agent"));
	}
	public static Collection<Data> getDb() {
		return db;
	}

}
