// TODO: 
// - Think about adding support for Images. 

// Book datatype. Contains important fields about a book. 
public class Book {

	// All books have these pieces of data.
	private String AuthorName; 
	private String BookTitle; 
	private long PageCount; 
	public long TimesRead; 
	
	// The Constructor of the class. 
	public Book(String AuthorName, String BookTitle, long PageCount){
		this.AuthorName = AuthorName; 
		this.BookTitle = BookTitle; 
		this.PageCount = PageCount; 
	}

	// The Getter Methods. 
	public String getAuthorName(){
		return AuthorName; 
	}

	public String getBookTitle(){
		return BookTitle; 
	}

	public long getPageCount(){
		return PageCount; 
	}

	public long getTimesRead(){
		return TimesRead;
	}
	
	// Setter method for the TimesRead. 
	public void setTimesRead(long TimesRead){
		this.TimesRead = TimesRead; 
	}

	// Main method. 
	public static void main(String[] args){
		String an = "Malcolm Gladwell"; 
		String bt = "Outliers"; 
		long pgct = 450;

		Book b = new Book(an, bt, pgct); 

		System.out.println(b.getAuthorName());
		System.out.println(b.getBookTitle()); 
		System.out.println(b.getPageCount()); 
		b.setTimesRead(10);
		System.out.println(b.getTimesRead()); 
	} 	
}

