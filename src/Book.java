// TODO: 
// - Think about adding support for Images. 

// Book datatype. Contains important fields about a book. 
public class Book {
	        
	// All books have these pieces of data.
	public String AuthorName; 
	public String BookTitle; 
	public long PageCount; 
	public long TimesRead; 
	
	// The Constructor of the class. 
	public Book(String AuthorName, String BookTitle, long PageCount){
		this.AuthorName = AuthorName; 
		this.BookTitle = BookTitle; 
		this.PageCount = PageCount; 
	}

	// The Getter methods.  
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
	
	// The Setter methods. Use this to change any of the fields.
	public void setTimesRead(long TimesRead){
		this.TimesRead = TimesRead; 
	}
	
	public void setAuthorName (String AuthorName){
		this.AuthorName = AuthorName; 
	}

	public void setBookTitle(String BookTitle){
		this.BookTitle = BookTitle; 
	}

	public void setPageCount(String PageCount){
		this.PageCount = PageCount; 
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

