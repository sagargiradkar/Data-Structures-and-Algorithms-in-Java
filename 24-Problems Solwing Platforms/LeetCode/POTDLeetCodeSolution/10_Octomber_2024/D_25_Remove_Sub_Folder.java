import java.util.*;

public class D_25_Remove_Sub_Folder {
    
    static class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
            List<String> result = new ArrayList<>();

            for (String currFolder : folder) {
                boolean isSubFolder = false;
                String tempFolder = currFolder;

                while (!currFolder.isEmpty()) {
                    int position = currFolder.lastIndexOf('/');  
                    if (position == -1) break;

                    currFolder = currFolder.substring(0, position);

                    if (folderSet.contains(currFolder)) {
                        isSubFolder = true;
                        break;
                    }
                }

                if (!isSubFolder) {
                    result.add(tempFolder);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        String[] folders = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        Solution solution = new Solution();
        List<String> result = solution.removeSubfolders(folders);

        System.out.println("Folders after removing sub-folders: " + result);
    }
}