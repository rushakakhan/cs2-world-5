import java.util.ArrayList;

public class Journal {
  
  private String title;
  private ArrayList<Issue> issues;

  public Journal(String newTitle) {
    title = newTitle;
    issues = new ArrayList<Issue>();
  }

  public Journal(String newTitle, ArrayList<Issue> newIssues) {
    title = newTitle;
    issues = newIssues;
  }

  public String getTitle() { return title; }
  public ArrayList<Issue> getIssues() {
    return issues;
  }

  public void addIssue(Issue i) {
    issues.add(i);
  }

  public static ArrayList<Journal> getSampleJournals() {

    ArrayList<Journal> arrayOfJournals = new ArrayList<Journal>();

    Journal journal1 = new Journal("Journal of Computer Science");
    Journal journal2 = new Journal("Journal of Consciousness Expansion");
    
    arrayOfJournals.add(journal1);
    arrayOfJournals.add(journal2);

    Issue issue1 = new Issue(1988, 11, 1, journal1);
    issue1.addArticle(new Article("C++ Programming Fundamentals", "John Doe"));
    issue1.addArticle(new Article("All about Java", "Johnny Java"));

    Issue issue2 = new Issue(2001, 8, 2, journal1);
    issue2.addArticle(new Article("Ruby For Beginners", "Matz"));
    issue2.addArticle(new Article("Eloquent Ruby", "Russ Olsen"));

    Issue issue3 = new Issue(1970, 5, 2, journal2);
    issue3.addArticle(new Article("The Tao te Ching in Plain English", "Jane Doe"));
    issue3.addArticle(new Article("Enlightment through Music", "Jim Morrison"));

    Issue issue4 = new Issue(2015, 12, 3, journal2);
    issue4.addArticle(new Article("Dimishing the Ego", "Eckart Tolle"));
    issue4.addArticle(new Article("A Case for Consciousness", "Lao Tzu"));

    journal1.addIssue(issue1);
    journal1.addIssue(issue2);

    journal2.addIssue(issue3);
    journal2.addIssue(issue4);

    return arrayOfJournals;
  }
}
