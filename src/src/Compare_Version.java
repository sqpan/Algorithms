
public class Compare_Version {

	public static void main(String[] args) {
		String v1 = "1";
		String v2 = "0";
		System.out.println(compareVersion(v1,v2));
	}

	public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.min(v1.length, v2.length); i++) {
            int one = Integer.parseInt(v1[i]);
            int two = Integer.parseInt(v2[i]);
            if (one > two) {
            	return 1;
            }
            else if (one < two) {
            	return -1;
            }
            //int compare = Integer.compare(one, two);
            //if (compare != 0) {
            //    return compare;
            //}
        }
        if (v1.length > v2.length) {
            return 1;
        }
        else if (v2.length > v1.length) {
            return -1;
        }
        return 0;
    }
}
