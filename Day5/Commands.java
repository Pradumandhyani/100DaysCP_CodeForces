// C. Cd and pwd commands
// time limit per test3 seconds
// memory limit per test256 megabytes
// inputstandard input
// outputstandard output
// Vasya is writing an operating system shell, and it should have commands for working with directories. To begin with, he decided to go with just two commands: cd (change the current directory) and pwd (display the current directory).

// Directories in Vasya's operating system form a traditional hierarchical tree structure. There is a single root directory, denoted by the slash character "/". Every other directory has a name — a non-empty string consisting of lowercase Latin letters. Each directory (except for the root) has a parent directory — the one that contains the given directory. It is denoted as "..".

// The command cd takes a single parameter, which is a path in the file system. The command changes the current directory to the directory specified by the path. The path consists of the names of directories separated by slashes. The name of the directory can be "..", which means a step up to the parent directory. «..» can be used in any place of the path, maybe several times. If the path begins with a slash, it is considered to be an absolute path, that is, the directory changes to the specified one, starting from the root. If the parameter begins with a directory name (or ".."), it is considered to be a relative path, that is, the directory changes to the specified directory, starting from the current one.

// The command pwd should display the absolute path to the current directory. This path must not contain "..".

// Initially, the current directory is the root. All directories mentioned explicitly or passed indirectly within any command cd are considered to exist. It is guaranteed that there is no attempt of transition to the parent directory of the root directory.

// Input
// The first line of the input data contains the single integer n (1 ≤ n ≤ 50) — the number of commands.

// Then follow n lines, each contains one command. Each of these lines contains either command pwd, or command cd, followed by a space-separated non-empty parameter.

// The command parameter cd only contains lower case Latin letters, slashes and dots, two slashes cannot go consecutively, dots occur only as the name of a parent pseudo-directory. The command parameter cd does not end with a slash, except when it is the only symbol that points to the root directory. The command parameter has a length from 1 to 200 characters, inclusive.

// Directories in the file system can have the same names.

// Output
// For each command pwd you should print the full absolute path of the given directory, ending with a slash. It should start with a slash and contain the list of slash-separated directories in the order of being nested from the root to the current folder. It should contain no dots.

// Examples
// inputCopy
// 7
// pwd
// cd /home/vasya
// pwd
// cd ..
// pwd
// cd vasya/../petya
// pwd
// outputCopy
// /
// /home/vasya/
// /home/
// /home/petya/
// inputCopy
// 4
// cd /a/b
// pwd
// cd ../a/b
// pwd
// outputCopy
// /a/b/
// /a/a/b/


// import java.util.*;
// public class Commands {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n=sc.nextInt();
//         List<String> arr = new ArrayList<>();
        
//         for (int i = 0; i < n; i++) {
//             arr.add(sc.nextLine());
//         }
        
//         sc.close();
//         // for(int i=0;i<arr.size();i++){
//         //     if(arr.get(i).equals("pwd")){
//         //         System.out.print("/");
                

//         //     }
            
//         // }
//         helper(arr);

//     }

//     public static String helper(List<String>list){
//         Queue<String> q = new LinkedList<>();
//         StringBuilder ans = new StringBuilder();
//         for(int i=0;i<list.size();i++){
            
//             if(list.get(i).equals("pwd")){
//                 ans.append("/");
//                 System.out.println(ans.toString());
//             }
//         }
//     }
// }

import java.util.*;

public class Commands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        List<String> path = new ArrayList<>();

        while (n-- > 0) {
            String command = sc.next();
            if (command.equals("pwd")) {
                System.out.print("/");
                for (String dir : path) {
                    System.out.print(dir + "/");
                }
                System.out.println();
            } else if (command.equals("cd")) {
                String parameter = sc.next();
                int pos = 0;
                if (parameter.charAt(0) == '/') {
                    path.clear();
                    pos = 1;
                }
                while (pos < parameter.length()) {
                    int nextPos = parameter.indexOf('/', pos);
                    if (nextPos != -1) {
                        String dir = parameter.substring(pos, nextPos);
                        if (!dir.equals("..")) {
                            path.add(dir);
                        } else {
                            if (!path.isEmpty()) {
                                path.remove(path.size() - 1);
                            }
                        }
                        pos = nextPos + 1;
                    } else {
                        String dir = parameter.substring(pos);
                        if (!dir.equals("..")) {
                            path.add(dir);
                        } else {
                            if (!path.isEmpty()) {
                                path.remove(path.size() - 1);
                            }
                        }
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
