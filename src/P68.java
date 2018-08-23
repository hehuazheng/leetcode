import java.util.ArrayList;
import java.util.List;

public class P68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        List<String> lineList = new ArrayList<>();
        int currentLength = 0;
        for (int i = 0; i < words.length; ) {
            int prevLength = currentLength + lineList.size();
            if (prevLength + words[i].length() <= maxWidth) {
                currentLength += words[i].length();
                lineList.add(words[i]);
                i++;
            } else {
                list.add(generateStr(lineList, currentLength, maxWidth, false));
                currentLength = 0;
                lineList.clear();
            }
        }

        if (lineList.size() > 0) {
            list.add(generateStr(lineList, currentLength, maxWidth, true));
        }
        return list;
    }

    String generateStr(List<String> list, int currentLength, int maxWidth, boolean isLast) {
        if(list.size() == 1) {
            StringBuilder sb = new StringBuilder(list.get(0));
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
            return sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        if (!isLast) {
            int wordsCount = list.size();
            int spaceToBeAdded = maxWidth - currentLength - wordsCount + 1;
            int divide = spaceToBeAdded / (wordsCount - 1);
            int remain = spaceToBeAdded % (wordsCount - 1);
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j != list.size() - 1) {
                    sb.append(' ');
                    for (int k = 0; k < divide; k++) {
                        sb.append(' ');
                    }
                    if (remain-- > 0) {
                        sb.append(' ');
                    }
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(list.get(i));
            }
            while(sb.length() < maxWidth) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    static void output(List<String> list) {
        for (String s : list) {
            System.out.println("#" + s + "#");
        }
    }

    public static void main(String[] args) {
//        output(new P68().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
//                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
//        output(new P68().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        output(new P68().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
