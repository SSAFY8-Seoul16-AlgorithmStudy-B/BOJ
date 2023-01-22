import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ4358 {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		float allNum = 0;
		
		while ((name = br.readLine()) != null) {
			name.replaceAll("%", "%%");
			if (map.containsKey(name)) map.replace(name, map.get(name)+1);
			else map.put(name, 1);
			allNum++;
		}
		
		for(String key : map.keySet()){
			System.out.printf("%s %.4f\n", key, (map.get(key)/allNum)*100);
		}
	}

}
