import java.util.ArrayList;

class Language {

  protected String name;
  protected int numSpeakers;
  protected String regionsSpoken;
  protected String wordOrder;

  public Language(String langName, int speakers, String regions, String wdOrder) {
    this.name = langName;
    this.numSpeakers = speakers;
    this.regionsSpoken = regions;
    this.wordOrder = wdOrder;
  }

  public void getInfo() {
    System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
    System.out.println("The language follows the word order: " + this.wordOrder + ".");
  }
  
  public static void main(String[] args) {
    // initialisation of few languages
    Language korean = new Language("Korean", 123456789, "Republic of South Korea", "subject-object-verb");
    Language akatek = new Mayan("Akatek", 987654321);
    Language mandarinChinese = new SinoTibetan("Mandarin Chinese", 555555555);
    Language burmese = new SinoTibetan("Burmese", 222222222);

    // consolidating into an ArrayList
    ArrayList<> listOfLanguages = new ArrayList<>();
    listOfLanguages.add(korean);
    listOfLanguages.add(akatek);
    listOfLanguages.add(mandarinChinese);
    listOfLanguages.add(burmese);

    // get info for all languages
    for (Language lang : listOfLanguages) {
      lang.getInfo();
    }
  }
}
