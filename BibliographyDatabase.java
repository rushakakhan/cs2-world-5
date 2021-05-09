import java.util.ArrayList;

public class BibliographyDatabase {
   
    private String name;
    private ArrayList<Journal> journals;
        

    public BibliographyDatabase(String newName)
    {
        name = newName;
        journals = new ArrayList<Journal>();
    }
    
    public BibliographyDatabase(String newName, ArrayList<Journal> newJournals)
    {
        name = newName;
        journals = newJournals;
    }
    
    public String getName() { return name; }
    public ArrayList<Journal> getAllJournals() {
      return journals;
    }
    
    public ArrayList<Article> getAllArticles() {
      ArrayList<Article> allArticles = new ArrayList<Article>();
      for (int i = 0; i < journals.size(); i++) {
        ArrayList<Issue> currIssues = journals.get(i).getIssues();
        for (int j = 0; j < currIssues.size(); j++) {
          ArrayList<Article> articles = currIssues.get(j).getArticles();
          for (int k = 0; k < articles.size(); k++) {
            allArticles.add(articles.get(k));
          }
        }
      }
      return allArticles;
    }

    
    //
    // toString()
    public String toString()
    {
        return name + " with " + journals.size() + " journals";
    }
    
    ////
    // Other methods
    
    public void addJournal(Journal j)
    {
      journals.add(j);
    }
    
    public void removeJournalByIndex(int index)
    {
      if (index >= 0 && index < journals.size()) {
        journals.remove(index);
      } else {
        System.out.println("Invalid index value");
      }
    }

    public void removeJournalByTitle(String titleString, boolean exactMatch) 
    {
      boolean isMatch;

      for (int i = 0; i < journals.size(); i++) {
        String title = journals.get(i).getTitle();
        if (exactMatch) {
          isMatch = title == titleString;
        } else {
          isMatch = title.contains(titleString);
        }

        if (isMatch) {
          removeJournalByIndex(i);
          break;
        }
      }
    }

    public void addJournalList(ArrayList<Journal> newJournals) {
      for (int i = 0; i < newJournals.size(); i++) {
        journals.add(newJournals.get(i));
      }
    }
    
}
