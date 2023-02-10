package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@CrossOrigin(origins = "*",allowedHeaders="*")
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	ISubscriptionService subscriptionService;
//	
//	@Autowired
//	IBlockService blockService;
//	
//	@Autowired
//	IBlockRepository  blockRepo;
	
//  @GetMapping("/all")
//  public List<Book> allAccess() {
//    List book = this.restTemplate.getForObject("http://localhost:8082/book/allBooks", List.class);
//    return book;
//  }
	
	
		@GetMapping("/all")
		public String allAccess() {
			return "Public Content.";
		}

		@GetMapping("/user")
		@PreAuthorize("hasRole('USER')")
		public String userAccess() {
			return "User Content.";
			//resttemplate taking to booking
		}

		@GetMapping("/attendee")
		@PreAuthorize("hasRole('ATTENDEE')")
		public String attendeeAccess() {
			return "Attendee Board.";
			// resttemplate taking to check_in
		}

		@GetMapping("/admin")
		@PreAuthorize("hasRole('ADMIN') or hasRole('ATTENDEE') or hasRole('USER')")
		public String adminAccess() {
			return "Admin Board.";
			// resttemplate taking to admin
		}
	
	
	

//  @GetMapping("/user")
//  @PreAuthorize("hasRole('ROLE_READER') or hasRole('ROLE_AUTHOR')")
//  public String userAccess() {
//    return "User Content.";
//  }
//  
//  @GetMapping("/guest")
//  @PreAuthorize("hasRole('ROLE_GUEST')")
//  public String guestAccess() {
//    return "Moderator Board.";
//  }
//
//  @GetMapping("/author")
//  @PreAuthorize("hasRole('ROLE_AUTHOR')")
//  public String authorAccess() {
//    return "Moderator Board.";
//  }
//
//  @GetMapping("/reader")
//  @PreAuthorize("hasRole('ROLE_READER')")
//  public String readerAccess() {
//    return "Admin Board.";
//  }
  
//  @GetMapping("/search/{bookTitle}")
//  public List<Book> getBookBytitle(@PathVariable String bookTitle){
//	  String url = "http://localhost:8082/book/title"+"/"+bookTitle;
//	  List book = this.restTemplate.getForObject(url, List.class);
//	    return book;
//  }
  
//  @GetMapping("/getauthername/{bookId}")
//  public String getBookAuthorName(@PathVariable int bookId) {
//	  String url="http://localhost:8082/book/getauthorname/"+bookId;
//	  String authorName = this.restTemplate.getForObject(url, String.class);
//	  return authorName;
//  }
//  
//  @GetMapping("/searchbycategory/{bookCategory}")
//  public List<Book> searchBookByCategory(@PathVariable String bookCategory){
//	  String url="http://localhost:8082/book/searchbycategory/"+bookCategory;
//	  List book = this.restTemplate.getForObject(url, List.class);
//	  return book;
//  }
  
//  @GetMapping("/searchbypublisher/{bookPublisher}")
//  public List<Book> searchBookByPublisher(@PathVariable String bookPublisher){
//	  String url = "http://localhost:8082/book/searchbypublisher/"+bookPublisher;
//	  List book = this.restTemplate.getForObject(url, List.class);
//	  return book;
//  }
  
//  @GetMapping("/search")
//  public List<Book> getBookByCategoryTitleAuthorPricePublisher(
//			@RequestParam String bookCategory,
//			@RequestParam String bookTitle,
//			@RequestParam int bookPrice,
//			@RequestParam String bookPublisher){
//	  String url = "http://localhost:8082/book/search?bookCategory="+bookCategory+"&bookTitle="+bookTitle+"&bookPrice="+bookPrice+"&bookPublisher="+bookPublisher;
//	  List book = this.restTemplate.getForObject(url, List.class);
//	 return book;  
//  }
  
//  @PutMapping("/admin/updateBook/{id}")
//  public ResponseEntity<String> updateBookByAuthor(@PathVariable("id") Integer id, @RequestBody Book book) {
//		String url = "http://localhost:8082/book/updateBook/"+id;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity entity = new HttpEntity(book,headers);
//		ResponseEntity<String> status = this.restTemplate.exchange(url, HttpMethod.PUT,entity, String.class);
//		return status;
//	}
  
//  @GetMapping("/getBookInfo/{bookId}")
//	public List<Book> getBookInfo(@PathVariable Integer bookId){
//	  String url =  "http://localhost:8082/book/getBookInfo/"+bookId;
//	  List book = this.restTemplate.getForObject(url, List.class);
//	  return book;
//  }
  
//  @GetMapping("/getAllBookDetails/{bookId}")
//  public Optional<Book> getBookByAllDetails(@PathVariable Integer bookId){
//	  String url="http://localhost:8082/book/getAllBookDetails/"+bookId;
//	  Optional  book = this.restTemplate.getForObject(url, Optional.class);
//	  return book;
//  }
  
//  @GetMapping("/getbookcontent/{bookTitle}")
//  public String getBookContentByTitle(@PathVariable String  bookTitle) {
//	  String url = "http://localhost:8082/book/getbookContent/"+bookTitle;
//	  String content = this.restTemplate.getForObject(url, String.class);
//	  return content;
//  }
  
//  @PostMapping("/subscribe/create")
//  public Integer createSubscription(@RequestBody SubscriptionMapperDto subscriptionRequest) throws Exception
//  {
//	  Integer subscriptionId = null;
//	  int subscriptionIdCheck = subscriptionService.getSubscriptionIdbyUserIdBookId(subscriptionRequest.getUserId(),subscriptionRequest.getBookId());
//	  if(subscriptionIdCheck == 0) {
//	  int id = subscriptionService.createSubcription(subscriptionRequest.getUserId(), subscriptionRequest.getBookId());
//	  subscriptionId = Integer.valueOf(id);
//	  }
//	  else
//	  {
//		  new Exception("Already Subscribed");
//	  }
//	  return subscriptionId;
//  }
  
//  @DeleteMapping("/unsubscribe/{id}")
//  public ResponseEntity deleteSubscription(@PathVariable int  id) {
//	  ResponseEntity<String> responseEntity = new ResponseEntity<>("Success",HttpStatus.OK);
//	  try{
//		  subscriptionService.deleteSubscripton(id);
//	  }
//	  catch(Exception e) {
//			e.printStackTrace();
//			responseEntity = new ResponseEntity<String>("Failed",HttpStatus.NOT_FOUND);
//		}
//	  return responseEntity;
//  }
  
//  @PostMapping("/getsubscriptionid")
//  public int getSubscriptionId(@RequestBody SubscriptionMapperDto subscriber) {
//	  return subscriptionService.getSubscriptionIdbyUserIdBookId(subscriber.getUserId(), subscriber.getBookId());
//  }
  
//  @PostMapping("/addblock")
//  public String blockBook(@RequestBody SubscriptionMapperDto subscriber) {
//	 return blockService.addBlock(subscriber.getUserId(), subscriber.getBookId());
//  }
  
//  @PostMapping("/isblocked")
//  public boolean checkBookBlock(@RequestBody SubscriptionMapperDto subscriber) {
//	  return blockService.getBooksByUserIdBookId(subscriber.getUserId(), subscriber.getBookId());
//  }
  
//  @GetMapping("/subscribedbooks/{userId}")
//  public List<Optional> allSubscribedBooks(@PathVariable int userId){
//	  List<Optional> bookList = new ArrayList<>();
//	  List<Subscription> bookIds = subscriptionService.getAllBookIdBySubscriptionId(userId);
//	  for(int i=0;i<bookIds.size();i++) {
//		  String url="http://localhost:8082/book/getAllBookDetails/"+bookIds.get(i).getBookId();
//		  Optional  book = this.restTemplate.getForObject(url, Optional.class);
//		  bookList.add(book);
//	  }
//	  return bookList;
//  }

  
//  @GetMapping("/blockedbooks/{userId}")
//  public List<Optional> allBlockedbooksbyid(@PathVariable int userId){
//	  List<Optional> bookList = new ArrayList<>();
//	  List<Block> blockList = blockRepo.findByUserId(userId);
//	  for(int i=0;i<blockList.size();i++) {
//		  String url="http://localhost:8082/book/getAllBookDetails/"+blockList.get(i).getBookId();
//		  Optional  book = this.restTemplate.getForObject(url, Optional.class);
//		  bookList.add(book);
//	  }
//	  return bookList;
//  }
  
//  @GetMapping("/searchforupdate/{bookTitle}")
//  public Integer getBookBytitleupdate(@PathVariable String bookTitle){
//	  String url = "http://localhost:8082/book/getbookid"+"/"+bookTitle;
//	  Integer book = this.restTemplate.getForObject(url, Integer.class);
//	  return book;
//  }
//  
//  @GetMapping("/getauthoridbyname/{name}")
//  public Integer getAuthorIdbyName(@PathVariable String name) {
//	  String url = "http://localhost:8082/book/getauthoridbyname"+"/"+name;
//	  Integer id = this.restTemplate.getForObject(url, Integer.class);
//	  return id;
//  }
  
//  @PostMapping("/createbook/{authorId}")
//  public ResponseEntity createBook(@PathVariable int authorId,@RequestBody Book book) {
//	    String url = "http://localhost:8082/book/createBook"+"/"+authorId;
//	    Book bookObj = new Book();
//	    bookObj.setBookTitle(book.getBookTitle());
//	    bookObj.setBookPublisher(book.getBookPublishedDate());
//	    bookObj.setBookActive(true);
//	    bookObj.setBookCategory(book.getBookCategory());
//	    bookObj.setBookContent(book.getBookContent());
//	    bookObj.setBookDescription(book.getBookDescription());
//	    bookObj.setBookPublisher(book.getBookPublisher());
//	    bookObj.setBookLogo(book.getBookLogo());
//	    bookObj.setBookPrice(book.getBookPrice());
//	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
//	    bookObj.setBookPublishedDate(timeStamp);
//	    
//	    HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity entity = new HttpEntity(bookObj,headers);
//		ResponseEntity<String> status = this.restTemplate.exchange(url, HttpMethod.POST,entity, String.class);
//		return status;
//  }
  
//  @GetMapping("/getbooklistbyauthorid/{id}")
//  public List<Book> getbookbyauthorId(@PathVariable int id){
//	  String url = "http://localhost:8082/book/getbooklistbyauthor"+"/"+id;
//	  List book = this.restTemplate.getForObject(url, List.class);
//	  return book;
//  }
}
