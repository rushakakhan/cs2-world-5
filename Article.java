public class Article {

  private String title;
  private String author;
  private Issue issue;

  public Article(String newTitle, String newAuthor) {
    title = newTitle;
    author = newAuthor;
    issue = null;
  }

  public Article(String newTitle, String newAuthor, Issue newIssue) {
    title = newTitle;
    author = newAuthor;
    issue = newIssue;
  }

  // Getters and setters
    
  public String getTitle() { return title; }
  public String getAuthor() { return author; }
  public Issue getIssue() { return issue; }
  
  public void setTitle(String newTitle) { title = newTitle; }
  public void setAuthor(String newAuthor) { author = newAuthor; }
  public void setIssue(Issue newIssue) { issue = newIssue; }

  public String toString() {
    String retString = title + " by " + author;
    return retString;
  }
}
