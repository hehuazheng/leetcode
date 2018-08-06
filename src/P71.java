import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
public class P71 {
    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        if(path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }
        String[] arr = path.split("/");
        List<String> list = new ArrayList<>();
        for(String s : arr) {
            if("..".equals(s)) {
                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            } else if("".equals(s) || ".".equals(s)) {
                continue;
            } else {
                list.add(s);
            }
        }

        if(list.size() >0 ) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append("/").append(s);
            }
            return sb.toString();
        } else {
            return "/";
        }
    }

    public static void main(String[] args) {
        System.out.println(new P71().simplifyPath("/home//foo/"));
        System.out.println(new P71().simplifyPath("/home/"));
        System.out.println(new P71().simplifyPath("/a/./b/../../c/"));
        System.out.println(new P71().simplifyPath("/"));
    }
}
