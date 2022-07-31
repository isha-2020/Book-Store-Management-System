package BookStoreManagement;

public class BookData {
	public BookData() {
		{
			String customer= "No";
			for (int i = 0; i <customers.length; i++) {
				customers[i]=customer;
			}
			for (int i = 0; i <5; i++) {
				switch (i) {
				case 0:
					booknames[i]="Programming with java";
					authors[i]="E balaguruswamy";
					price[i]="569";
					sumpaginations[i]="1320";
					copies[i]="67";
					break;
				case 1:
					booknames[i]="Complete core java";
					authors[i]="Kailash upadhay";
					price[i]="395";
					sumpaginations[i]="656";
					copies[i]="50";
					
					break;
				case 2:
					booknames[i]="DSA in Java";
					authors[i]="michel goodrich";
					price[i]="490";
					sumpaginations[i]="1120";
					copies[i]="107";
					break;
				case 3:
					booknames[i]="English dictionary";
					authors[i]="Oxford";
					price[i]="599";
					sumpaginations[i]="1310";
					copies[i]="89";
					break;
				case 4:
					booknames[i]="Quantitative aptitude";
					authors[i]="Arun Sharma";
					price[i]="799";
					sumpaginations[i]="954";
					copies[i]="23";
					break;
				}
			}
													
		}
	}

	public String[] booknames = new String[10];//book name
	public String[] authors = new String[10];//Author
	public String[] price = new String[10];//Publication date
	public String[] sumpaginations = new String[10];//Total number of pages
	public String[] copies = new String[10];
	public String[] customers = new String[10];//customer

}