import java.util.ArrayList;
import java.util.Scanner;

public class BibliographyUI {
  
  private BibliographyDatabase database;

  BibliographyUI(BibliographyDatabase newDatabase) {
    database = newDatabase;
  }

  ArrayList<Article> findArticlesFromYear(int year) {
    ArrayList<Journal> journals = database.getAllJournals();
    ArrayList<Article> articlesFromYear = new ArrayList<Article>();

    for (int i = 0; i < journals.size(); i++) {
      ArrayList<Issue> currIssues = journals.get(i).getIssues();
      for (int j = 0; j < currIssues.size(); j++) {
        if (currIssues.get(j).getYear() == year) {
          ArrayList<Article> articles = currIssues.get(j).getArticles();
          for (int k = 0; k < articles.size(); k++) {
            articlesFromYear.add(articles.get(k));
          }
        }
      }
    }

    return articlesFromYear;
  }

  String mostPublishedAuthor() {
    String author = "";
    ArrayList<Article> allArticles = database.getAllArticles();
    allArticles.sort((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()));

    int currentFrequency = 0;
    int highestFrequency = 0;
    for (int i = 0; i < allArticles.size(); i++) {
      currentFrequency++;
      String currentAuth = allArticles.get(i).getAuthor();
      if (i == allArticles.size() -1 || currentAuth != allArticles.get(i + 1).getAuthor()) {
        if (currentFrequency > highestFrequency) {
          highestFrequency = currentFrequency;
          author = currentAuth;
        }
        currentFrequency = 0;
      }
    }

    if (highestFrequency == 1) {
      return "No winner, all authors are only published once.";
    }
    return author;
  }

  void run() {

      System.out.println("Welcome to the " + database.getName() + "!\n"); 

      String[] choices = new String[4];

      choices[0] = "Find articles from a given year";
      choices[1] = "Add an article to an issue";
      choices[2] = "Find the most-published author";
      choices[3] = "Exit";
      
      boolean runProgram = true;

      while (runProgram) {
          // Choices: display the options
          for (int i=0; i < choices.length; i++)
          {
              System.out.println((i+1) + ") " + choices[i]);
          }

          System.out.println("Please enter your choice (1, 2, or 3):");
          
          // Get the user's choice
          Scanner input = new Scanner(System.in);
          int choice;

          try {
            choice = input.nextInt();
          } catch (Exception e) {
            System.out.println("Invalid input");
            //input.close();
            return;
          }

          if (choice > 4 || choice < 1)
          {
              System.out.println("Sorry, that is not a valid choice.");
          } else if (choice == 1) {

              System.out.println("      ");
              System.out.println("What year are you interested in?");

              Scanner yearInput = new Scanner(System.in);
              int year;

              try {
                  year = yearInput.nextInt();
              } catch (Exception e) {
                  System.out.println("Invalid input");
                  System.out.println(e);
                  continue;
              }

              ArrayList<Article> foundArticles = findArticlesFromYear(year);

              if (foundArticles.size() > 0) {
                System.out.println("      ");
                  System.out.println("--------------------------");
                  System.out.println("Here are the articles from " + year + ":");
                  System.out.println("--------------------------");
                  for (int i = 0; i < foundArticles.size(); i++) {
                    System.out.println(foundArticles.get(i).toString());
                  }
                  System.out.println("--------------------------");
                  System.out.println("                        ");
                  continue;
              } else {
                System.out.println("      ");
                  System.out.println("--------------------------");
                  System.out.println("No articles found for that year");
                  System.out.println("--------------------------");
                  System.out.println("      ");
                  return;
              }

          } else if (choice == 2) {
              System.out.println("      ");
              System.out.println("Here are the available issues:");

              ArrayList<Journal> journals = database.getAllJournals();
              ArrayList<Issue> issues = new ArrayList<Issue>();

              int counter = 0;
              for (int i = 0; i < journals.size(); i++) {
                for (int j = 0; j < journals.get(i).getIssues().size(); j++) {
                  counter++;
                  Issue currIssue = journals.get(i).getIssues().get(j);
                  issues.add(currIssue);
                  System.out.println(counter + ") " + currIssue.toString());
                }
              }
              System.out.println("What issue would you like to add to?:");

              Scanner issue = new Scanner(System.in);
              int iChoice;

              try {
                  iChoice = issue.nextInt();
              } catch (Exception e) {
                  System.out.println("Invalid input");
                  System.out.println(e);
                  continue;
              }
              int issueIndex = iChoice - 1;

              System.out.println("Please specify the article title:");
              Scanner in = new Scanner(System.in);
              String articleTitle = in.nextLine();
              System.out.println("Please specify the article author:");
              String articleAuthor = in.nextLine();
              
              issues.get(issueIndex).addArticle(new Article(articleTitle, articleAuthor));
              continue;
          } else if (choice == 3) {
              System.out.println("      ");
              System.out.println("--------------------------");
              System.out.println("The most published author is: " + this.mostPublishedAuthor());
              System.out.println("--------------------------");
              System.out.println("      ");
              continue;
          } else {
            System.out.println("Bye!");
              runProgram = false;
          }
      }
  }
  

  public static void main(String[] args)
  {
      ArrayList<Journal> sampleJournals = Journal.getSampleJournals();

      BibliographyDatabase sampleDatabase = new BibliographyDatabase("Bibliography Database", sampleJournals);

      BibliographyUI ui = new BibliographyUI(sampleDatabase);

      ui.run();
  }

}
