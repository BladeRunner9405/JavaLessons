package interfaces;

import java.awt.*;
import java.util.Objects;

interface TextAnalyzer {
  Label processText(String text);
}

abstract class KeywordAnalyzer implements TextAnalyzer {
  String[] keywords;

  String label;

  @Override
  public Label processText(String text) {
    text = text.toLowerCase();
    for (String elem : keywords) {
      if (text.contains(elem)) {
        return new Label(label);
      }
    }
    return new Label("ОК");
  }
}

class SpamAnalyzer extends KeywordAnalyzer {

  public SpamAnalyzer(String[] keywords) {
    this.keywords = keywords;
    this.label = "спам";
  }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {
  public NegativeTextAnalyzer() {
    this.keywords = new String[] {":(", "=(", ":|"};
    this.label = "негативное содержание";
  }
}

class TooLongTextAnalyzer implements TextAnalyzer {
  int maxl;

  public TooLongTextAnalyzer(int maxl) {
    this.maxl = maxl;
  }

  @Override
  public Label processText(String text) {
    if (text.length() <= maxl) {
      return new Label("ОК");
    }
    return new Label("слишком длинный");
  }
}

class Test {
  public static void main(String[] args) {
    String comment = " Привет! Тест!";
    System.out.println(
        checkLabels(
            new TextAnalyzer[] {
              new SpamAnalyzer(new String[] {"привет"}),
              new NegativeTextAnalyzer(),
              new TooLongTextAnalyzer(16)
            },
            comment));
  }

  public static Label checkLabels(TextAnalyzer[] analyzers, String comment) {
    for (TextAnalyzer analyzer : analyzers) {
      Label label = analyzer.processText(comment);
      if (!Objects.equals(label, new Label("ОК"))) {
        return label;
      }
    }
    return new Label("ОК");
  }
}
