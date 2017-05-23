package com.weihua.leetcode;

public class VersionNumberComparator {
    public static void main(String[] args) {
        VersionNumberComparator tester = new VersionNumberComparator();
        System.out.println(Integer.parseInt(" 12"));
        System.out.println(tester.compareVersion("1.0", "1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] firstVersions = version1.split("\\.");
        String[] secondVersions = version2.split("\\.");

        int length = Math.min(firstVersions.length, secondVersions.length);
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(firstVersions[i]) > Integer.parseInt(secondVersions[i])) {
                return 1;
            } else if (Integer.parseInt(firstVersions[i]) < Integer.parseInt(secondVersions[i])) {
                return -1;
            }
        }

        if (firstVersions.length > secondVersions.length) {
            for (int i = length; i < firstVersions.length; i++) {
                if (Integer.parseInt(firstVersions[i]) != 0 ) {
                    return 1;
                }
            }
            return 0;
        } else if (firstVersions.length < secondVersions.length) {
            for (int i = length; i < secondVersions.length; i++) {
                if (Integer.parseInt(secondVersions[i]) != 0 ) {
                    return -1;
                }
            }
            return 0;
        } else {
            return 0;
        }
    }
}
