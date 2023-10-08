import java.awt.*;

interface TextAnalyzer {
    Label processText(String text);
}

abstract class KeywordAnalyzer implements TextAnalyzer{
    String[] badWords;
    String[] words;
    String verdict;

    public Label processText(String text){
        for (String elem:
                words) {
            for (String word :
                    badWords) {
                if (elem.contains(word)){
                    return new Label(verdict);
                }
            }
        }
        return new Label("ок");
    }
}
//class NegativeTextAnalyzer extends KeywordAnalyzer  {
//    String[] text;
//    public NegativeTextAnalyzer(){
//
//    }
//
//    @Override
//    public Label processText(String text) {
//        verdict = "негативное содержание";
//        super(text);
//    }
//}
//
//class SpamAnalyzer extends KeywordAnalyzer{
//    String[] text;
//    public SpamAnalyzer(String[] args){
//        text = args;
//    }
//}



class TooLongTextAnalyzer implements TextAnalyzer{
    int maxL;
    public TooLongTextAnalyzer(int maxL){
        this.maxL = maxL;
    }
}