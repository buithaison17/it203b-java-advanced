import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Post(List<String> tags) {
}

public class XuatSac6 {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        List<String> str1 = new ArrayList<>(Arrays.asList("java", "backend"));
        List<String> str2 = new ArrayList<>(Arrays.asList("python", "data"));
        posts.add(new Post(str1));
        posts.add(new Post(str2));

        List<String> result = posts.stream().flatMap(p -> p.tags().stream()).toList();
        result.forEach(System.out::println);
    }
}
