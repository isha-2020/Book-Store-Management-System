package BookStoreManagement;
import java.util.Scanner;

import BookStoreManagement.BOoksadding;

public class MajesticStore {
	BOoksadding books = new BOoksadding();

	public static void main (String[]args){
		
		MajesticStore store = new MajesticStore();
		store.welcome();//Welcome interface

	}

	//Welcome Screen
	public void welcome() {
		System.out.println("*********************************");
		System.out.println("*******Majestic Book Depo********");
		System.out.println("*********************************");
		loginBoundary();//Login interface
	}

	//Administrator login interface
	public void loginBoundary() {
		System.out.print("Administrator account:");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.print("Login password:");
		Scanner scanner1 = new Scanner(System.in);
		String password = scanner1.nextLine();
		int flag = books.login(username, password);//login verification
		switch (flag) {
		case 0://password error
			System.out.println("Wrong password, please re-enter.");
			loginBoundary();
			break;

		case 1://verified
			System.out.println("Login successfully!");
			showMenu();//After successful login, jump to the menu function management
			break;
		case -1://account does not exist
			System.out.println("The administrator account you entered does not exist, please confirm and enter again.");
			loginBoundary();
			break;
		}
	}

	//Menu function display list
	public void showMenu() {
		System.out.println("Please enter the function number to enter the corresponding function:");
		System.out.println("All book information-number: 1");
		System.out.println("Enter a new books- number: 2");
		System.out.println("Modify the basic information of the book-number: 3");
		System.out.println("Delete book function-number: 4");
		System.out.println("Exit the system-number: 5");
		System.out.print("Please enter the function number:");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();//
		switch (a) {
		case 1://book information
			showBook();
			returnMethod();//Return to the main menu
			break;
		case 2://Enter new book
			addBook();
			break;
		case 3://modify the basic information of the book
			modBookInfo();
			break;
		case 4://delete book
			delete();
			break;
		case 5://logout
			welcome();
			scanner.close();
			break;
		}
	}

	//Return to the main menu function
	public void returnMethod() {
		System.out.print("Press ENTER to return to the function main menu:");
		Scanner scanner = new Scanner(System.in);
		String i = scanner.nextLine();
		showMenu();
	}

	//Book information display function
	public void showBook() {
		books.showBook();
	}

	//Input new book function
	public void addBook() {
		System.out.print("Please enter the name of the book to be added:");//Book title
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		System.out.print ( "Please enter" + bookname + "author:");//Author
		Scanner scanner1 = new Scanner(System.in);
		String author = scanner1.nextLine();
		System.out.print("Please enter "+ bookname +" the cost of book :");//publication date
		Scanner scanner2 = new Scanner(System.in);
		String price = scanner2.nextLine();
		System.out.print("Please enter" + bookname + "total number of pages (pages):");//total number of pages
		Scanner scanner3 = new Scanner(System.in);
		String sumpagination = scanner3.nextLine();
		System.out.print("Please enter" + bookname + "Number of copies");//total number of pages
		Scanner scanner4 = new Scanner(System.in);
		String copies = scanner3.nextLine();
		
		int flag = books.addBook(bookname, author, price, sumpagination,copies);
		//1 means success, 0 means the new book already exists in the library, -1 means the warehouse is full
		switch (flag) {
		case 1:
			System.out.println("new book" + bookname + "added successfully, the library currently has" + books.remainSpace() + "locations for storing new books.");
			returnMethod();//The return function in the book add interface, you can choose to continue adding or return to the main menu
			break;
		case 0:
			System.out.println("Failed to add book," + bookname + "Already exist in this library!");
			returnMethod();//The return function in the book add interface, you can choose to continue adding or return to the main menu
			showMenu();
			break;
		
		}
	}

	//Modify book information
	public void modBookInfo() {
		System.out.print("Please enter the title of the book you want to operate:");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		//Find related book information based on the title
		int flag = books.selectBook(bookname);
		switch (flag) {
		case 0:
			System.out.print("Related books are not found, enter 0 and press Enter to enter the function of this layer, and enter 1 and press Enter to return to the function main menu.");
			int a = scanner.nextInt();
			if (a == 0) {
				modBookInfo();
			} else if (a == 1) {

				showMenu();
			}
			break;

		case -1:
			System.out.println("The title of the book is empty, enter 0 and press Enter to enter the function of this layer, and enter 1 and press Enter to return to the function main menu.");
			int a1 = scanner.nextInt();
			if (a1 == 0) {
				modBookInfo();
			} else {
				showMenu();
			}
			break;

		case 1:
			System.out.print("The above information is the result of searching related book titles,where Enter 1 represents the title of the book"
					+ "Enter 2 represents the author, "
					+ "Enter 3 represents the publication date "
					+ "Enter 4 represents the total number of pages , "
					+ "The number 5 represents the copies"
					+ " Enter the relevant number to modify the relevant information: ");
			int a2 = scanner.nextInt();
			if (a2> 0 && a2 <6) {
				System.out.print("Please enter what you want to modify" + sortName(a2) + ":");
				Scanner scanner2 = new Scanner(System.in);
				String value = scanner2.nextLine();
				int index = books.selectIndex(bookname);
				books.modinfo(a2, value, index);
				System.out.println(bookname + "The related information of this book has been modified successfully!");
				returnMethod();
			} else {
				System.out.println("The number you entered is invalid. Please try again!");
				modBookInfo();
			}

			break;

		}
	}

	//Modified category name
	public String sortName(int flag) {
		if (flag == 1)
			return "Book Title";
		if (flag == 2)
			return "Author";
		if (flag == 3)
			return "Price";
		if (flag == 4)
			return "Total Pages";
		if (flag == 5)
			return "Total Copies";
		else
		  return "Customer";
	}

	//Delete book function
	public void delete() {
		System.out.print("Please enter the title of the book which are sold out:");
		Scanner scanner = new Scanner(System.in);
		String bookname = scanner.nextLine();
		int flag = books.testCustomer(bookname);
		
		if (flag == 1) {
			books.deleteBook(bookname);
			System.out.println(bookname + "Successfully sold out! Enter 0 to return to the main menu, enter 1 to continue deleting");
			delReturn();
		
		} 
		else {//This book does not exist
			System.out.println("This book does not exist in shop , please compare it carefully. Enter 0 to return to the main menu, enter 1 to continue to delete");
			delReturn();
		}

	}

	//Deleted return operation
	public void delReturn() {

		Scanner scanner1 = new Scanner(System.in);
		int i = scanner1.nextInt();
		if (i == 0) {
			showMenu();
		} else if (i == 1) {
			delete();
		}
	}

	
	

	
	}
