import java.util.ArrayList;

public class Issue {

  private int year;
  private int volume;
  private int issue;
  private ArrayList<Article> articles;
  private Journal journal;

  public Issue(int newYear, int newVolume, int newIssue, Journal newJournal) {
    year = newYear;
    volume = newVolume;
    issue = newIssue;
    articles = new ArrayList<Article>();
    journal = newJournal;
  }

  public Issue(int newYear, int newVolume, int newIssue, ArrayList<Article> newArticles, Journal newJournal) {
    year = newYear;
    volume = newVolume;
    issue = newIssue;
    articles = newArticles;
    journal = newJournal;
  }

  public int getYear() { return year; }
  public int getVolume() { return volume; }
  public int getIssue() { return issue; }
  public ArrayList<Article> getArticles() { return articles; }

  public void setYear(int newYear) { year = newYear; }
  public void setVolume(int newVolume) { volume = newVolume; }
  public void setIssue(int newIssue) { issue = newIssue; }

  public void addArticle(Article a) {
    articles.add(a);
  }

  public String toString() {
    String retString = journal.getTitle() + ", Volume " + volume + ", Issue " + issue;

    return retString;
  }
}
